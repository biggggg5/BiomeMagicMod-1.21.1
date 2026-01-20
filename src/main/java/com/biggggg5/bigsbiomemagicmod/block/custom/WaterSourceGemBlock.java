package com.biggggg5.bigsbiomemagicmod.block.custom;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import com.biggggg5.bigsbiomemagicmod.block.entity.ModBlockEntities;
import com.biggggg5.bigsbiomemagicmod.block.entity.WaterSourceGemBlockEntity;
import com.biggggg5.bigsbiomemagicmod.potion.ModPotions;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.FluidUtil;
import org.jetbrains.annotations.Nullable;

public class WaterSourceGemBlock extends BaseEntityBlock {
    public static final MapCodec<WaterSourceGemBlock> CODEC = simpleCodec(WaterSourceGemBlock::new);


    public WaterSourceGemBlock(Properties properties) {
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
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new WaterSourceGemBlockEntity (blockPos, blockState);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        FluidUtil.interactWithFluidHandler(player, hand, level, pos, null);
        ItemStack waterBottle = PotionContents.createItemStack(Items.POTION, Potions.WATER);
        if (stack.is(Items.GLASS_BOTTLE)) {
            player.setItemInHand(hand, waterBottle);
            level.playSound(player, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1f, 1f);
        }
        else if (stack.is(waterBottle.getItem())) {
            player.setItemInHand(hand, new ItemStack(Items.GLASS_BOTTLE));
            level.playSound(player, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1f, 1f);
        }
        return ItemInteractionResult.SUCCESS;
    }
}
