package com.biggggg5.bigsbiomemagicmod.block.entity;

import com.biggggg5.bigsbiomemagicmod.component.ModDataComponents;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

import static com.biggggg5.bigsbiomemagicmod.block.custom.BiomeChannelerBlock.FULL;

public class BiomeChannelerBlockEntity extends BlockEntity {
    public final ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return 1;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private float rotation;

    public BiomeChannelerBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.BIOMECHANNELER_BE.get(), pos, blockState);
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if (rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public void clearContents() {
        inventory.setStackInSlot(0, ItemStack.EMPTY);
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(inventory.getSlots());
        for (int i = 0; i < inventory.getSlots(); i++) {
            inv.setItem(i, inventory.getStackInSlot(i));
        }

            Containers.dropContents(this.level, this.worldPosition, inv);
        }



    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", inventory.serializeNBT(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));
    }


    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if (coreInserted()) {
            ResourceLocation biome = inventory.getStackInSlot(0).get(ModDataComponents.BIOMELOCATION);
            ResourceLocation catalyst = inventory.getStackInSlot(0).get(ModDataComponents.BIOMECATALYST);
            ResourceKey<Biome> biomeKey = ResourceKey.create(Registries.BIOME, biome);
            Block targetBlock = level.registryAccess().registryOrThrow(Registries.BLOCK).get(catalyst);

            loopSound();
            if (blockCount == 0)checkTerraforming(targetBlock);
            biomeProcess(level, biomeKey);
        } else returnToDefault();
    }

    private void biomeProcess(Level level, ResourceKey<Biome> biomeKey) {
        ResourceLocation catalyst = inventory.getStackInSlot(0).get(ModDataComponents.BIOMECATALYST);

        if (countdown == 3 && blockCount >= 50) {
            level.playSound (null, getBlockPos(), SoundEvents.PLAYER_LEVELUP, SoundSource.BLOCKS, 1.0f, 1.0f );
            changeBiome(biomeKey);
            clearContents();
        } else if (blockCount < 50 && countdown == 3) {
            level.playSound (null, getBlockPos(), SoundEvents.GENERIC_DEATH, SoundSource.BLOCKS, 1.0f, 1.0f );
            drops();
            ServerPlayer player = (ServerPlayer) level.getNearestPlayer(getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ(), 5.0, true);
            if (player != null) {
                player.displayClientMessage(Component.literal("The ritual has failed due to insufficient terraforming. "+ (50-blockCount) + " more "+ catalyst.getPath() +" needed."), false);
            }
        }
    }

    int blockCount = 0;

    private void checkTerraforming(Block targetBlock) {
        if (this.level == null || this.level.isClientSide()) {
            return;
        }

        ServerLevel serverLevel = (ServerLevel) this.level;
        ChunkPos chunkPos = new ChunkPos(this.worldPosition);
        ChunkAccess chunk = serverLevel.getChunk(chunkPos.x, chunkPos.z, ChunkStatus.FULL, false);

        if (chunk == null) {
            return;
        }

        int chunkMinX = chunkPos.getMinBlockX();
        int chunkMaxX = chunkPos.getMaxBlockX();
        int chunkMinZ = chunkPos.getMinBlockZ();
        int chunkMaxZ = chunkPos.getMaxBlockZ();
        int minY = serverLevel.getMinBuildHeight();
        int maxY = serverLevel.getMaxBuildHeight() - 1;


        for (int x = chunkMinX; x <= chunkMaxX; x++) {
            for (int z = chunkMinZ; z <= chunkMaxZ; z++) {
                for (int y = minY; y <= maxY; y++) {
                    BlockPos pos = new BlockPos(x, y, z);
                    BlockState state = chunk.getBlockState(pos);

                    if (state.is(targetBlock)) {
                        blockCount++;
                    }
                }
            }
        }
    }

    public void changeBiome(ResourceKey<Biome> biomeKey) {
        if (this.level == null || this.level.isClientSide()) {
            return;
        }

        ServerLevel serverLevel = (ServerLevel) this.level;
        Registry<Biome> biomeRegistry = serverLevel.registryAccess().registryOrThrow(Registries.BIOME);
        Holder<Biome> biomeHolder = biomeRegistry.getHolderOrThrow(biomeKey);

        ChunkPos chunkPos = new ChunkPos(this.worldPosition);
        ChunkAccess chunk = serverLevel.getChunk(chunkPos.x, chunkPos.z, ChunkStatus.FULL, false);

        if (chunk != null) {
            int minX = chunkPos.getMinBlockX();
            int maxX = chunkPos.getMaxBlockX();
            int minY = serverLevel.getMinBuildHeight();
            int maxY = serverLevel.getMaxBuildHeight() - 1;
            int minZ = chunkPos.getMinBlockZ();
            int maxZ = chunkPos.getMaxBlockZ();

            BoundingBox chunkBounds = new BoundingBox(minX, minY, minZ, maxX, maxY, maxZ);

            BiomeResolver resolver = getBiomeResolver(chunkBounds, biomeHolder, chunk);

            chunk.fillBiomesFromNoise(resolver, serverLevel.getChunkSource().randomState().sampler());
            chunk.setUnsaved(true);

            serverLevel.getChunkSource().chunkMap.resendBiomesForChunks(List.of(chunk));
        }
    }

    private static @NotNull BiomeResolver getBiomeResolver(BoundingBox chunkBounds, Holder<Biome> biomeHolder, ChunkAccess chunk) {
        MutableInt biomeEntries = new MutableInt(0);
        return (biomeX, biomeY, biomeZ, sampler) -> {
            int blockX = QuartPos.toBlock(biomeX);
            int blockY = QuartPos.toBlock(biomeY);
            int blockZ = QuartPos.toBlock(biomeZ);

            if (chunkBounds.isInside(blockX, blockY, blockZ)) {
                biomeEntries.increment();
                return biomeHolder;
            } else {
                return chunk.getNoiseBiome(biomeX, biomeY, biomeZ);
            }
        };
    }


    private boolean coreInserted() {
        return !inventory.getStackInSlot(0).isEmpty();
    }

    private int soundTicker = 19;
    private int countdown = 0;

    private void loopSound() {
        soundTicker++;
        if (soundTicker >= 20) {
            level.playSound (null, getBlockPos(), SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1.2f, 1.0f );
            soundTicker = 0;
            countdown++;
        }
    }

    private void returnToDefault() {
        soundTicker = 19;
        countdown = 0;
        blockCount = 0;
        this.level.setBlockAndUpdate(this.worldPosition, this.getBlockState().setValue(FULL, false));
    }


    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }
}



