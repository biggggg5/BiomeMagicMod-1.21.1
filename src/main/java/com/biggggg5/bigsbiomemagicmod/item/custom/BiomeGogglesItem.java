package com.biggggg5.bigsbiomemagicmod.item.custom;

import com.biggggg5.bigsbiomemagicmod.effect.ModEffects;
import com.biggggg5.bigsbiomemagicmod.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import org.jetbrains.annotations.Nullable;

public class BiomeGogglesItem extends Item implements Equipable {

    public BiomeGogglesItem(Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }

    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        return swapWithEquipmentSlot(this, worldIn, playerIn, handIn);
    }



    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (level.isClientSide) return;
        if (!(entity instanceof Player player)) return;

        if (player.getItemBySlot(EquipmentSlot.HEAD).equals(stack)) {

            if (!player.hasEffect(ModEffects.BIOME_VISION_EFFECT)) {
                player.addEffect(new MobEffectInstance(
                        ModEffects.BIOME_VISION_EFFECT,
                        110,
                        0,
                        true, false, true
                ));

}}}}

