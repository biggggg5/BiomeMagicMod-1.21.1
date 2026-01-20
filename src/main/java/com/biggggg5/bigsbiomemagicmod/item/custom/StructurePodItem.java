package com.biggggg5.bigsbiomemagicmod.item.custom;

import com.biggggg5.bigsbiomemagicmod.component.ModDataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class StructurePodItem extends BlockItem {
    public StructurePodItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public Component getName(ItemStack stack) {
        ResourceLocation structure = stack.get(ModDataComponents.STRUCTURELOCATION);

        if (stack.has(ModDataComponents.STRUCTURELOCATION))
            //Tie this to lang thing
            return Component.literal("Structure Pod: " + structure.getPath());
        return super.getName(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        ResourceLocation structure = stack.get(ModDataComponents.STRUCTURELOCATION);

        if (structure == null) {
            //Tie this to lang thing
            tooltipComponents.add(Component.literal("This pod has no Structure and will not function. (Creative Only)"));

            super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        }
    }


}
