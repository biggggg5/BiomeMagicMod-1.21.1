package com.biggggg5.bigsbiomemagicmod.datagen.Builders;

import com.biggggg5.bigsbiomemagicmod.recipe.UnripeStructurePodRecipe;
import net.minecraft.advancements.Criterion;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nullable;

public class UnripeStructurePodRecipeBuilder implements RecipeBuilder {
    private final Ingredient ingredient1;
    private final Ingredient ingredient2;
    private final ItemStack result;

    public UnripeStructurePodRecipeBuilder(ItemStack result, Ingredient ingredient1, Ingredient ingredient2) {
        this.result = result;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
    }

    public static UnripeStructurePodRecipeBuilder recipe(ItemStack result, Item ing1, Item ing2) {
        return new UnripeStructurePodRecipeBuilder(result, Ingredient.of(ing1), Ingredient.of(ing2));
    }

    @Override
    public RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String group) {
        return this;
    }

    @Override
    public Item getResult() {
        return this.result.getItem();
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        output.accept(id, new UnripeStructurePodRecipe(ingredient1, ingredient2, result.copy()), null);
    }
}