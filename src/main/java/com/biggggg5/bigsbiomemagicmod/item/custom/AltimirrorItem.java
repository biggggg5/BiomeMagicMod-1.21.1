package com.biggggg5.bigsbiomemagicmod.item.custom;

import com.biggggg5.bigsbiomemagicmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AltimirrorItem extends Item {
    public AltimirrorItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player) {
            Item hand = player.getItemInHand(InteractionHand.OFF_HAND).getItem();
            int yLevel = (int) player.getY();
            if (hand == ModItems.ALTIMIRROR.get() || isSelected) {
                player.displayClientMessage(
                        Component.literal("Y: " + yLevel),
                        true
                );
            }
        }
    }
}
