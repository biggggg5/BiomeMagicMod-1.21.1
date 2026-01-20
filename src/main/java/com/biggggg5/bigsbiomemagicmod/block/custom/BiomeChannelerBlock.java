package com.biggggg5.bigsbiomemagicmod.block.custom;

import com.biggggg5.bigsbiomemagicmod.block.entity.BiomeChannelerBlockEntity;
import com.biggggg5.bigsbiomemagicmod.block.entity.ModBlockEntities;
import com.biggggg5.bigsbiomemagicmod.component.ModDataComponents;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class BiomeChannelerBlock extends BaseEntityBlock {
public static final MapCodec<BiomeChannelerBlock> CODEC = simpleCodec(BiomeChannelerBlock::new);

public static final BooleanProperty FULL = BooleanProperty.create("full");

    public BiomeChannelerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FULL, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FULL);
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
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BiomeChannelerBlockEntity(blockPos, blockState);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()) {
            if(level.getBlockEntity(pos) instanceof BiomeChannelerBlockEntity biomeChannelerBlockEntity) {
                biomeChannelerBlockEntity.drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (level.getBlockEntity(pos) instanceof BiomeChannelerBlockEntity biomeChannelerBlockEntity) {
            if(biomeChannelerBlockEntity.inventory.getStackInSlot(0).isEmpty() && !stack.isEmpty() && stack.has(ModDataComponents.BIOMELOCATION) && stack.has(ModDataComponents.BIOMECATALYST)){
                biomeChannelerBlockEntity.inventory.insertItem(0, stack.copy(), false);
                if (!player.isCreative())stack.shrink(1);
                level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 2f);
                level.setBlockAndUpdate(pos, state.setValue(FULL, true));

            } else if (!biomeChannelerBlockEntity.inventory.getStackInSlot(0).isEmpty() && stack.isEmpty()) {
                ItemStack stackOnChanneler = biomeChannelerBlockEntity.inventory.extractItem(0, 1, false);
                player.setItemInHand(InteractionHand.MAIN_HAND, stackOnChanneler);
                biomeChannelerBlockEntity.clearContents();
                level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 1f);
                level.setBlockAndUpdate(pos, state.setValue(FULL, false));
            }

        }
        return ItemInteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if(level.isClientSide()) {
            return null;
        }

        return createTickerHelper(blockEntityType, ModBlockEntities.BIOMECHANNELER_BE.get(),
                (level1, blockPos, blockState, blockEntity) -> blockEntity.tick(level1, blockPos, blockState));
    }
}
