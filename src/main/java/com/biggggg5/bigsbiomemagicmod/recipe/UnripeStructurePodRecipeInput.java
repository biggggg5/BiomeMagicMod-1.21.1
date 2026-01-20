package com.biggggg5.bigsbiomemagicmod.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.items.ItemStackHandler;

public record UnripeStructurePodRecipeInput (ItemStackHandler inventory) implements RecipeInput {
    @Override
    public ItemStack getItem(int index) {
        return inventory.getStackInSlot(index);
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return inventory.getStackInSlot(0).isEmpty() && inventory.getStackInSlot(1).isEmpty();
    }
}
