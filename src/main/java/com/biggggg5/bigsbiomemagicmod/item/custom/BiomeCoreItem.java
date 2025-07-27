package com.biggggg5.bigsbiomemagicmod.item.custom;

import com.biggggg5.bigsbiomemagicmod.component.ModDataComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class BiomeCoreItem extends Item {


    public BiomeCoreItem(Properties properties) {
        super(properties);
    }

    @Override
    public void verifyComponentsAfterLoad(ItemStack stack) {

        if (stack.has(ModDataComponents.BIOMELOCATION) && stack.has(ModDataComponents.BIOMECATALYST)) {
            stack.set(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true);
            stack.set(DataComponents.RARITY, Rarity.UNCOMMON);
        }
        super.verifyComponentsAfterLoad(stack);

    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        ResourceLocation biome = stack.get(ModDataComponents.BIOMELOCATION);

        if (biome != null) {
            tooltipComponents.add(Component.literal("Attuned to the " + biome.getPath()));
        } else tooltipComponents.add(Component.literal("This orb is unattuned and will not function. (Creative Only)"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}
