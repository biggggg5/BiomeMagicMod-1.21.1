package com.biggggg5.bigsbiomemagicmod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record UnripeStructurePodRecipe(Ingredient ingredient1, Ingredient ingredient2, ItemStack result) implements Recipe<UnripeStructurePodRecipeInput> {


    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(Ingredient.EMPTY);
        list.add(ingredient1);
        list.add(ingredient2);
        return list;
    }

    @Override
    public boolean matches(UnripeStructurePodRecipeInput input, Level level) {
    ItemStack stack1 = input.getItem(0);
    ItemStack stack2 = input.getItem(1);
        if (level.isClientSide()) {
            return false;
        }
        return stack1.getCount() == 16 && stack2.getCount() == 16 && ((ingredient1.test(stack1) && ingredient2.test(stack2)) ||
        (ingredient1.test(stack2) && ingredient2.test(stack1)) );
    }

    @Override
    public ItemStack assemble(UnripeStructurePodRecipeInput input, HolderLookup.Provider provider) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return result.copy();
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.UNRIPE_STRUCTURE_POD_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.UNRIPE_STRUCTURE_POD_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<UnripeStructurePodRecipe> {

        public static final MapCodec<UnripeStructurePodRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        Ingredient.CODEC.fieldOf("ingredient1").forGetter(UnripeStructurePodRecipe::ingredient1),
                        Ingredient.CODEC.fieldOf("ingredient2").forGetter(UnripeStructurePodRecipe::ingredient2),
                        ItemStack.CODEC.fieldOf("result").forGetter(UnripeStructurePodRecipe::result)
                ).apply(instance, UnripeStructurePodRecipe::new)
        );

        public static final StreamCodec<RegistryFriendlyByteBuf, UnripeStructurePodRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, UnripeStructurePodRecipe::ingredient1,
                        Ingredient.CONTENTS_STREAM_CODEC, UnripeStructurePodRecipe::ingredient2,
                        ItemStack.STREAM_CODEC, UnripeStructurePodRecipe::result,
                        UnripeStructurePodRecipe::new
                );

        @Override
        public MapCodec<UnripeStructurePodRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, UnripeStructurePodRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
