package com.biggggg5.bigsbiomemagicmod.item.custom;

import com.biggggg5.bigsbiomemagicmod.block.ModBlocks;
import com.biggggg5.bigsbiomemagicmod.block.custom.UnripeStructurePodBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;

public class StructureSeedItem extends Item {
    public StructureSeedItem(Properties properties) {
        super(properties);

    }

    protected boolean mayPlaceOn(BlockState state, BlockPos pos) {
        return state.is(BlockTags.DIRT) || state.getBlock() instanceof FarmBlock;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos placedPos = context.getClickedPos();
        BlockPos blockpos = context.getClickedPos().relative(context.getClickedFace());
        BlockState placedOnState = level.getBlockState(placedPos);
        Player player = context.getPlayer();
        ItemStack itemStack = context.getItemInHand();
        BlockState newPod = ModBlocks.UNRIPESTRUCTUREPOD.get().defaultBlockState();

        if (!level.isClientSide && mayPlaceOn(placedOnState, placedPos)) {
            level.setBlockAndUpdate(blockpos, newPod);
            if (!player.isCreative()){
                itemStack.shrink(1);
            }
        }
        return InteractionResult.SUCCESS;
    }
}
