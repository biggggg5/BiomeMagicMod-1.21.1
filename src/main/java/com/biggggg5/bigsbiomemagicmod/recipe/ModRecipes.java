package com.biggggg5.bigsbiomemagicmod.recipe;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, BigsBiomeMagicMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, BigsBiomeMagicMod.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<UnripeStructurePodRecipe>> UNRIPE_STRUCTURE_POD_SERIALIZER =
            SERIALIZERS.register("unripe_structure_pod", UnripeStructurePodRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<UnripeStructurePodRecipe>> UNRIPE_STRUCTURE_POD_TYPE =
            TYPES.register("unripe_structure_pod", () -> new RecipeType<UnripeStructurePodRecipe>() {
                @Override
                public String toString() {
                    return "unripe_structure_pod";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }

}
