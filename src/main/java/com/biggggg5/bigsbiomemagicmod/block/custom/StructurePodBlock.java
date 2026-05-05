package com.biggggg5.bigsbiomemagicmod.block.custom;

import com.biggggg5.bigsbiomemagicmod.block.entity.ModBlockEntities;
import com.biggggg5.bigsbiomemagicmod.block.entity.StructurePodBlockEntity;
import com.biggggg5.bigsbiomemagicmod.component.ModDataComponents;
import com.biggggg5.bigsbiomemagicmod.item.ModItems;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;

public class StructurePodBlock extends BaseEntityBlock {
    public static final MapCodec<StructurePodBlock> CODEC = simpleCodec(StructurePodBlock::new);
    private static final Logger LOGGER = LogUtils.getLogger();

    public StructurePodBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (level.getBlockEntity(pos) instanceof StructurePodBlockEntity be) {
            ResourceLocation rl = stack.get(ModDataComponents.STRUCTURELOCATION.get());
            if (rl != null) {
                be.setResource(rl);
            }
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        ItemStack stack = super.getCloneItemStack(state, target, level, pos, player);
        if (level.getBlockEntity(pos) instanceof StructurePodBlockEntity be && be.getResource() != null) {
            stack.set(ModDataComponents.STRUCTURELOCATION.get(), be.getResource());
        }
        return stack;
    }

    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        ItemStack tool = params.getOptionalParameter(LootContextParams.TOOL);
        BlockEntity be = params.getOptionalParameter(LootContextParams.BLOCK_ENTITY);

        HolderGetter<Enchantment> getter = params.getLevel().holderLookup(Registries.ENCHANTMENT);
        Holder<Enchantment> silkTouch = getter.getOrThrow(Enchantments.SILK_TOUCH);

        if (tool != null && tool.getEnchantmentLevel(silkTouch) > 0) {
            ItemStack drop = new ItemStack(this);
            if (be instanceof StructurePodBlockEntity structurepodbe && structurepodbe.getResource() != null) {
                drop.set(ModDataComponents.STRUCTURELOCATION.get(), structurepodbe.getResource());
            }
            return List.of(drop);
        }
        return List.of();
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        HolderGetter<Enchantment> getter = level.holderLookup(Registries.ENCHANTMENT);
        Holder<Enchantment> silkTouch = getter.getOrThrow(Enchantments.SILK_TOUCH);
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (blockEntity instanceof StructurePodBlockEntity podBlockEntity) {
                ServerLevel serverLevel = (ServerLevel) level;
                ResourceLocation structureLocation = podBlockEntity.getResource();


                if (player.getMainHandItem().getEnchantmentLevel(silkTouch) != 1) {

                    level.playSound(null, pos, SoundEvents.VILLAGER_WORK_FLETCHER, SoundSource.BLOCKS, 1.0f, 1.0f);
                    level.playSound(null, pos, SoundEvents.VILLAGER_WORK_MASON, SoundSource.BLOCKS, 1.0f, 1.0f);
                    level.playSound(null, pos, SoundEvents.VILLAGER_WORK_TOOLSMITH, SoundSource.BLOCKS, 1.0f, 1.0f);

                    if (!spawnStructure(serverLevel, pos, structureLocation)) {
                        ItemStack seeds = new ItemStack(ModItems.STRUCTURESEEDS.get());
                        ItemEntity seedEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, seeds);
                        player.sendSystemMessage(Component.literal("The structure cannot spawn here so the pod has returned to seeds...")); //tie this to lang thing later
                        if (!player.isCreative())
                            level.addFreshEntity(seedEntity);
                    }
                    ;
                    if (!checkSafety(player, level)) {
                        spawnProtection(player, level);
                    }
                }
            }
        }
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    private boolean checkSafety(Player player, Level level) {
        BlockPos playerPos = player.blockPosition();
        BlockState sufBlock = level.getBlockState(playerPos.offset(0, 1, 0));

        return sufBlock.isAir();
    }

    ;

    private void spawnProtection(Player player, Level level) {
        BlockPos playerPos = player.blockPosition();
        ServerLevel serverLevel = (ServerLevel) level;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++){
                for (int z = -1; z <= 1; z++){

                    serverLevel.setBlock(playerPos.offset(x, y, z), Blocks.YELLOW_STAINED_GLASS.defaultBlockState(), 3);
            }}}}

    private boolean spawnStructure(ServerLevel level, BlockPos pos, ResourceLocation structureLocation) {
        if (structureLocation == null) {
            return false;
        }

        LOGGER.info("Attempting to spawn structure {} at {}", structureLocation, pos);

        try {
            Registry<Structure> structureRegistry = level.registryAccess()
                    .registryOrThrow(Registries.STRUCTURE);

            Optional<Holder.Reference<Structure>> structureHolder = structureRegistry.getHolder(structureLocation);
            if (structureHolder.isEmpty()) {
                LOGGER.debug("No structure found in registry for {}", structureLocation);
                return false;
            }

            Structure structure = structureHolder.get().value();

            if (generateStructure(level, structure, pos.above())) {
                LOGGER.info("Successfully spawned structure {} at {}", structureLocation, pos);
                return true;
            }

        } catch (Exception e) {
            LOGGER.error("Error placing structure {} at {}: {}",
                    structureLocation, pos, e.getMessage());
        }

        LOGGER.warn("Failed to spawn structure {} at {}", structureLocation, pos);
        return false;
    }

    private boolean generateStructure(ServerLevel level, Structure structure, BlockPos pos) {
        try {
            ChunkGenerator chunkGenerator = level.getChunkSource().getGenerator();
            RandomSource random = level.getRandom();
            ChunkPos chunkPos = new ChunkPos(pos);


            StructureStart structureStart = structure.generate(
                    level.registryAccess(),
                    chunkGenerator,
                    chunkGenerator.getBiomeSource(),
                    level.getChunkSource().randomState(),
                    level.getStructureManager(),
                    level.getSeed(),
                    chunkPos,
                    0,
                    level,
                    biome -> true
            );

            if (!structureStart.isValid()) {
                LOGGER.debug("Failed to generate valid structure start");
                return false;
            }

            structureStart.placeInChunk(level, level.structureManager(), chunkGenerator,
                    random, structureStart.getBoundingBox(), chunkPos);

            return true;

        } catch (Exception e) {
            LOGGER.error("Failed to generate structure: {}", e.getMessage());
            return false;
        }

    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof StructurePodBlockEntity be) {
            ResourceLocation rl = be.getResource();
            if (rl != null && !level.isClientSide) {
                player.sendSystemMessage(Component.literal("This pod contains the power to spawn the "+ rl.getPath()));
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new StructurePodBlockEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return null;
        }

        return createTickerHelper(blockEntityType, ModBlockEntities.STRUCTUREPOD_BE.get(),
                (level1, blockPos, blockState, blockEntity) -> blockEntity.tick(level1, blockPos, blockState));
    }
}
