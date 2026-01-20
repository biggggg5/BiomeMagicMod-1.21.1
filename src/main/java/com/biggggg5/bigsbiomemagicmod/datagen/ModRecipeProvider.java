package com.biggggg5.bigsbiomemagicmod.datagen;

import com.biggggg5.bigsbiomemagicmod.block.ModBlocks;
import com.biggggg5.bigsbiomemagicmod.component.ModDataComponents;
import com.biggggg5.bigsbiomemagicmod.datagen.Builders.UnripeStructurePodRecipeBuilder;
import com.biggggg5.bigsbiomemagicmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ItemStack snowyplainscore = new ItemStack(ModItems.BIOMECORE.get());
        snowyplainscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("snowy_plains"));
        snowyplainscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("snow_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, snowyplainscore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                        .define('S', Items.SNOW_BLOCK)
                        .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_snowy_plains");

        ItemStack plainscore = new ItemStack(ModItems.BIOMECORE.get());
        plainscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("plains"));
        plainscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("dirt"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, plainscore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.DIRT)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_plains");

        ItemStack desertcore = new ItemStack(ModItems.BIOMECORE.get());
        desertcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("desert"));
        desertcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("sand"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, desertcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.SAND)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_desert");


        ItemStack badlandscore = new ItemStack(ModItems.BIOMECORE.get());
        badlandscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("badlands"));
        badlandscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("red_sand"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, badlandscore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.RED_SAND)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_badlands");



    ItemStack bamboocore = new ItemStack(ModItems.BIOMECORE.get());
        bamboocore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("bamboo_jungle"));
        bamboocore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("bamboo"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, bamboocore)
            .pattern("SSS")
                .pattern("SUS")
                .pattern("PPP")
                .define('S', Items.BAMBOO)
                .define('P', Items.PODZOL)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
            .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
            .save(recipeOutput, "bigsbiomemagicmod:biomecore_bamboo_jungle");


        ItemStack basaltcore = new ItemStack(ModItems.BIOMECORE.get());
        basaltcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("basalt_deltas"));
        basaltcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("basalt"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, basaltcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.BASALT)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_basalt_deltas");

        ItemStack beachcore = new ItemStack(ModItems.BIOMECORE.get());
        beachcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("beach"));
        beachcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("sand"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, beachcore)
                .pattern("WWW")
                .pattern("WUS")
                .pattern("SSS")
                .define('S', Items.SAND)
                .define('W', Items.WATER_BUCKET)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_beach");

        ItemStack birchcore = new ItemStack(ModItems.BIOMECORE.get());
        birchcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("birch_forest"));
        birchcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("birch_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, birchcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.BIRCH_LOG)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_birch");

        ItemStack cherrycore = new ItemStack(ModItems.BIOMECORE.get());
        cherrycore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("cherry_grove"));
        cherrycore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("cherry_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, cherrycore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.CHERRY_LOG)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_cherry");

        ItemStack crimsoncore = new ItemStack(ModItems.BIOMECORE.get());
        crimsoncore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("crimson_forest"));
        crimsoncore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("crimson_nylium"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, crimsoncore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.CRIMSON_NYLIUM)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_crimson");

        ItemStack coldcore = new ItemStack(ModItems.BIOMECORE.get());
        coldcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("cold_ocean"));
        coldcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, coldcore)
                .pattern("WWW")
                .pattern("KUK")
                .pattern("SSS")
                .define('S', Items.GRAVEL)
                .define('K', Items.KELP)
                .define('W', Items.WATER_BUCKET)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_cold");

        ItemStack darkoakcore = new ItemStack(ModItems.BIOMECORE.get());
        darkoakcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("dark_forest"));
        darkoakcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("dark_oak_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, darkoakcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.DARK_OAK_LOG)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_dark_forest");

        ItemStack deepcoldcore = new ItemStack(ModItems.BIOMECORE.get());
        deepcoldcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("deep_cold_ocean"));
        deepcoldcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, deepcoldcore)
                .pattern("WWW")
                .pattern("PUP")
                .pattern("SSS")
                .define('S', Items.GRAVEL)
                .define('W', Items.WATER_BUCKET)
                .define('P', Items.PRISMARINE)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_deep_cold");

        ItemStack deepdarkcore = new ItemStack(ModItems.BIOMECORE.get());
        deepdarkcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("deep_dark"));
        deepdarkcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("sculk"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, deepdarkcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.SCULK)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_deep_dark");

        ItemStack deepfrozencore = new ItemStack(ModItems.BIOMECORE.get());
        deepfrozencore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("deep_frozen_ocean"));
        deepfrozencore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, deepfrozencore)
                .pattern("WIW")
                .pattern("PUP")
                .pattern("SSS")
                .define('S', Items.GRAVEL)
                .define('P', Items.PRISMARINE)
                .define('W', Items.WATER_BUCKET)
                .define('I', Items.ICE)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_deep_frozen_ocean");

        ItemStack deeplukewarmcore = new ItemStack(ModItems.BIOMECORE.get());
        deeplukewarmcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("deep_lukewarm_ocean"));
        deeplukewarmcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, deeplukewarmcore)
                .pattern("WWW")
                .pattern("PUP")
                .pattern("SSS")
                .define('S', Items.SAND)
                .define('P', Items.PRISMARINE)
                .define('W', Items.WATER_BUCKET)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_deep_lukewarm_ocean");

        ItemStack deepoceancore = new ItemStack(ModItems.BIOMECORE.get());
        deepoceancore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("deep_ocean"));
        deepoceancore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, deepoceancore)
                .pattern("WWW")
                .pattern("PUP")
                .pattern("SDS")
                .define('S', Items.GRAVEL)
                .define('P', Items.PRISMARINE)
                .define('W', Items.WATER_BUCKET)
                .define('D', Items.DIRT)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_deep_ocean");

        ItemStack dripcore = new ItemStack(ModItems.BIOMECORE.get());
        dripcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("dripstone_caves"));
        dripcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("dripstone_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, dripcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("PPP")
                .define('S', Items.DRIPSTONE_BLOCK)
                .define('P', Items.POINTED_DRIPSTONE)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_dripstone_caves");

        ItemStack endbarrenscore = new ItemStack(ModItems.BIOMECORE.get());
        endbarrenscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("end_barrens"));
        endbarrenscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("end_stone"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, endbarrenscore)
                .pattern("SSS")
                .pattern("SUR")
                .pattern("RRR")
                .define('S', Items.END_STONE)
                .define('R', Items.END_ROD)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_end_barrens");

        ItemStack endhighlandscore = new ItemStack(ModItems.BIOMECORE.get());
        endhighlandscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("end_highlands"));
        endhighlandscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("end_stone"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, endhighlandscore)
                .pattern("PPP")
                .pattern("CUC")
                .pattern("SSS")
                .define('S', Items.END_STONE)
                .define('C', Items.CHORUS_FRUIT)
                .define('P', Items.PURPUR_BLOCK)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_end_highlands");

        ItemStack endmidlandscore = new ItemStack(ModItems.BIOMECORE.get());
        endmidlandscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("end_midlands"));
        endmidlandscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("end_stone"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, endmidlandscore)
                .pattern("PPP")
                .pattern("PUP")
                .pattern("SSS")
                .define('S', Items.END_STONE)
                .define('P', Items.PURPUR_BLOCK)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_end_midlands");

        ItemStack erodedcore = new ItemStack(ModItems.BIOMECORE.get());
        erodedcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("eroded_badlands"));
        erodedcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("red_sandstone"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, erodedcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.TERRACOTTA)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_eroded_badlands");

        ItemStack flowerforestcore = new ItemStack(ModItems.BIOMECORE.get());
        flowerforestcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("flower_forest"));
        flowerforestcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("oak_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, flowerforestcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("DPD")
                .define('S', Items.OAK_LOG)
                .define('D', Items.DANDELION)
                .define('P', Items.POPPY)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_flower_forest");

        ItemStack forestcore = new ItemStack(ModItems.BIOMECORE.get());
        forestcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("forest"));
        forestcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("oak_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, forestcore)
                .pattern("SSS")
                .pattern("SUB")
                .pattern("BBB")
                .define('S', Items.OAK_LOG)
                .define('B', Items.BIRCH_LOG)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_forest");

        ItemStack frozencore = new ItemStack(ModItems.BIOMECORE.get());
        frozencore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("frozen_ocean"));
        frozencore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, frozencore)
                .pattern("WIW")
                .pattern("WUW")
                .pattern("SSS")
                .define('S', Items.GRAVEL)
                .define('W', Items.WATER_BUCKET)
                .define('I', Items.ICE)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_frozen_ocean");

        ItemStack frozenpeakscore = new ItemStack(ModItems.BIOMECORE.get());
        frozenpeakscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("frozen_peaks"));
        frozenpeakscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("snow_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, frozenpeakscore)
                .pattern("SIS")
                .pattern("IUI")
                .pattern("TTT")
                .define('S', Items.SNOW_BLOCK)
                .define('I', Items.PACKED_ICE)
                .define('T', Items.STONE)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_frozen_peaks");

        ItemStack frozenrivercore = new ItemStack(ModItems.BIOMECORE.get());
        frozenrivercore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("frozen_river"));
        frozenrivercore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("ice"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, frozenrivercore)
                .pattern("SWS")
                .pattern("SUW")
                .pattern("WSS")
                .define('S', Items.ICE)
                .define('W', Items.WATER_BUCKET)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_frozen_river");

        ItemStack grovecore = new ItemStack(ModItems.BIOMECORE.get());
        grovecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("grove"));
        grovecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("snow_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, grovecore)
                .pattern("WSW")
                .pattern("WUW")
                .pattern("SSS")
                .define('S', Items.SNOW_BLOCK)
                .define('W', Items.SPRUCE_LOG)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_grove");


        ItemStack icespikescore = new ItemStack(ModItems.BIOMECORE.get());
        icespikescore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("ice_spikes"));
        icespikescore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("snow_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, icespikescore)
                .pattern("SIS")
                .pattern("IUI")
                .pattern("ISI")
                .define('S', Items.SNOW_BLOCK)
                .define('I', Items.ICE)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_ice_spikes");


        ItemStack jaggedpeakscore = new ItemStack(ModItems.BIOMECORE.get());
        jaggedpeakscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("jagged_peaks"));
        jaggedpeakscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("stone"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, jaggedpeakscore)
                .pattern("WWW")
                .pattern("WUW")
                .pattern("SSS")
                .define('S', Items.STONE)
                .define('W', Items.SNOW_BLOCK)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_jagged_peaks");

        ItemStack junglecore = new ItemStack(ModItems.BIOMECORE.get());
        junglecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("jungle"));
        junglecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("jungle_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, junglecore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.JUNGLE_LOG)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_jungle");


        ItemStack lukewarmcore = new ItemStack(ModItems.BIOMECORE.get());
        lukewarmcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("lukewarm_ocean"));
        lukewarmcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, lukewarmcore)
                .pattern("WWW")
                .pattern("WUW")
                .pattern("SCS")
                .define('S', Items.SAND)
                .define('C', Items.CLAY)
                .define('W', Items.WATER_BUCKET)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_lukewarm_ocean");

        ItemStack lushcavescore = new ItemStack(ModItems.BIOMECORE.get());
        lushcavescore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("lush_caves"));
        lushcavescore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("moss_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, lushcavescore)
                .pattern("SSS")
                .pattern("VUV")
                .pattern("VSV")
                .define('S', Items.MOSS_BLOCK)
                .define('V', Items.VINE)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_lush_caves");

        ItemStack mangrovecore = new ItemStack(ModItems.BIOMECORE.get());
        mangrovecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("mangrove_swamp"));
        mangrovecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("mangrove_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, mangrovecore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.MANGROVE_LOG)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_mangrove_swamp");

        ItemStack meadowcore = new ItemStack(ModItems.BIOMECORE.get());
        meadowcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("meadow"));
        meadowcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("dirt"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, meadowcore)
                .pattern("GGG")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.DIRT)
                .define('G', Items.GRASS_BLOCK)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_meadow");

        ItemStack mushroomcore = new ItemStack(ModItems.BIOMECORE.get());
        mushroomcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("mushroom_fields"));
        mushroomcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("mycelium"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, mushroomcore)
                .pattern("WSR")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.MYCELIUM)
                .define('W', Items.BROWN_MUSHROOM)
                .define('R', Items.RED_MUSHROOM)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_mushroom_fields");

        ItemStack netherwastescore = new ItemStack(ModItems.BIOMECORE.get());
        netherwastescore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("nether_wastes"));
        netherwastescore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("netherrack"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, netherwastescore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.NETHERRACK)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_nether_wastes");

        ItemStack oceancore = new ItemStack(ModItems.BIOMECORE.get());
        oceancore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("ocean"));
        oceancore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, oceancore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.WATER_BUCKET)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_ocean");

        ItemStack oldbirchcore = new ItemStack(ModItems.BIOMECORE.get());
        oldbirchcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("old_growth_birch_forest"));
        oldbirchcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("birch_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, oldbirchcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("GGG")
                .define('S', Items.BIRCH_LOG)
                .define('G', Items.GRASS_BLOCK)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_old_growth_birch_forest");

        ItemStack oldpinecore = new ItemStack(ModItems.BIOMECORE.get());
        oldpinecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("old_growth_pine_taiga"));
        oldpinecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("spruce_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, oldpinecore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("GGG")
                .define('S', Items.SPRUCE_LOG)
                .define('G', Items.COARSE_DIRT)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_old_growth_pine_taiga");

        ItemStack oldsprucecore = new ItemStack(ModItems.BIOMECORE.get());
        oldsprucecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("old_growth_spruce_taiga"));
        oldsprucecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("spruce_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, oldsprucecore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("GGG")
                .define('S', Items.SPRUCE_LOG)
                .define('G', Items.GRASS_BLOCK)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_old_growth_spruce_taiga");

        ItemStack rivercore = new ItemStack(ModItems.BIOMECORE.get());
        rivercore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("river"));
        rivercore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, rivercore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("CCC")
                .define('S', Items.WATER_BUCKET)
                .define('C', Items.CLAY)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_river");

        ItemStack savannacore = new ItemStack(ModItems.BIOMECORE.get());
        savannacore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("savanna"));
        savannacore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("acacia_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, savannacore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.ACACIA_LOG)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_savanna");


        ItemStack savannaplateaucore = new ItemStack(ModItems.BIOMECORE.get());
        savannaplateaucore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("savanna_plateau"));
        savannaplateaucore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("acacia_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, savannaplateaucore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("DDD")
                .define('S', Items.ACACIA_LOG)
                .define('D', Items.DIRT)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_savanna_plateau");

        ItemStack endislandscore = new ItemStack(ModItems.BIOMECORE.get());
        endislandscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("small_end_islands"));
        endislandscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("end_stone"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, endislandscore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("EEE")
                .define('S', Items.END_STONE)
                .define('E', Items.ENDER_PEARL)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_small_end_islands");

        ItemStack snowybeachcore = new ItemStack(ModItems.BIOMECORE.get());
        snowybeachcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("snowy_beach"));
        snowybeachcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("sand"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, snowybeachcore)
                .pattern("WWW")
                .pattern("SUS")
                .pattern("BBB")
                .define('S', Items.SAND)
                .define('B', Items.WATER_BUCKET)
                .define('W', Items.SNOW_BLOCK)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_snowy_beach");

        ItemStack snowyslopescore = new ItemStack(ModItems.BIOMECORE.get());
        snowyslopescore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("snowy_slopes"));
        snowyslopescore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("snow_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, snowyslopescore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("TTT")
                .define('S', Items.SNOW_BLOCK)
                .define('T', Items.STONE)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_snowy_slopes");

        ItemStack snowytaigacore = new ItemStack(ModItems.BIOMECORE.get());
        snowytaigacore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("snowy_taiga"));
        snowytaigacore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("dirt"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, snowytaigacore)
                .pattern("PPP")
                .pattern("SUS")
                .pattern("DDD")
                .define('S', Items.SNOW_BLOCK)
                .define('D', Items.DIRT)
                .define('P', Items.SPRUCE_LOG)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_snowy_taiga");

        ItemStack soulsandvalleycore = new ItemStack(ModItems.BIOMECORE.get());
        soulsandvalleycore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("soul_sand_valley"));
        soulsandvalleycore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("soul_sand"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, soulsandvalleycore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.SOUL_SAND)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_soul_sand_valley");

        ItemStack sparsejunglecore = new ItemStack(ModItems.BIOMECORE.get());
        sparsejunglecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("sparse_jungle"));
        sparsejunglecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("dirt"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, sparsejunglecore)
                .pattern("JSJ")
                .pattern("JUJ")
                .pattern("SSS")
                .define('J', Items.JUNGLE_LOG)
                .define('S', Items.DIRT)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_sparse_jungle");

        ItemStack stonypeakscore = new ItemStack(ModItems.BIOMECORE.get());
        stonypeakscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("stony_peaks"));
        stonypeakscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("stone"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, stonypeakscore)
                .pattern("CSC")
                .pattern("SUS")
                .pattern("CSC")
                .define('S', Items.STONE)
                .define('C', Items.CALCITE)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_stony_peaks");

        ItemStack stonyshorecore = new ItemStack(ModItems.BIOMECORE.get());
        stonyshorecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("stony_shore"));
        stonyshorecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("stone"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, stonyshorecore)
                .pattern("SSS")
                .pattern("SUW")
                .pattern("WWW")
                .define('S', Items.STONE)
                .define('W', Items.WATER_BUCKET)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_stony_shore");

        ItemStack sunflowercore = new ItemStack(ModItems.BIOMECORE.get());
        sunflowercore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("sunflower_plains"));
        sunflowercore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("sunflower"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, sunflowercore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.SUNFLOWER)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_sunflower_plains");

        ItemStack swampcore = new ItemStack(ModItems.BIOMECORE.get());
        swampcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("swamp"));
        swampcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, swampcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.LILY_PAD)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_swamp");

        ItemStack taigacore = new ItemStack(ModItems.BIOMECORE.get());
        taigacore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("taiga"));
        taigacore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("spruce_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, taigacore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.SPRUCE_LOG)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_taiga");

        ItemStack theendcore = new ItemStack(ModItems.BIOMECORE.get());
        theendcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("the_end"));
        theendcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("endstone"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, theendcore)
                .pattern("ICI")
                .pattern("OUO")
                .pattern("SSS")
                .define('S', Items.END_STONE)
                .define('O', Items.OBSIDIAN)
                .define('I', Items.IRON_BARS)
                .define('C', Items.END_CRYSTAL)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_the_end");


        ItemStack voidcore = new ItemStack(ModItems.BIOMECORE.get());
        voidcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("the_void"));
        voidcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("air"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, voidcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.GLASS)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_the_void");

        ItemStack warmoceancore = new ItemStack(ModItems.BIOMECORE.get());
        warmoceancore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("warm_ocean"));
        warmoceancore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, warmoceancore)
                .pattern("WWW")
                .pattern("CUC")
                .pattern("SSS")
                .define('S', Items.SAND)
                .define('C', Items.SEA_PICKLE)
                .define('W', Items.WATER_BUCKET)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_warm_ocean");

        ItemStack warpedforestcore = new ItemStack(ModItems.BIOMECORE.get());
        warpedforestcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("warped_forest"));
        warpedforestcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("warped_nylium"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, warpedforestcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.WARPED_NYLIUM)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_warped_forest");

        ItemStack windsweptforestcore = new ItemStack(ModItems.BIOMECORE.get());
        windsweptforestcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("windswept_forest"));
        windsweptforestcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("grass_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, windsweptforestcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("GGG")
                .define('S', Items.OAK_LOG)
                .define('G', Items.GRASS_BLOCK)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_windswept_forest");


        ItemStack windsweptgravelcore = new ItemStack(ModItems.BIOMECORE.get());
        windsweptgravelcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("windswept_gravelly_hills"));
        windsweptgravelcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("gravel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, windsweptgravelcore)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.GRAVEL)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_windswept_gravelly_hills");

        ItemStack windswepthillcore = new ItemStack(ModItems.BIOMECORE.get());
        windswepthillcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("windswept_hills"));
        windswepthillcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("gravel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, windswepthillcore)
                .pattern("GWG")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', Items.STONE)
                .define('G', Items.GRASS_BLOCK)
                .define('W', Items.SNOW_BLOCK)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_windswept_hills");

        ItemStack windsweptsavannacore = new ItemStack(ModItems.BIOMECORE.get());
        windsweptsavannacore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("windswept_savanna"));
        windsweptsavannacore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("acacia_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, windsweptsavannacore)
                .pattern("WWW")
                .pattern("GUG")
                .pattern("SSS")
                .define('S', Items.STONE)
                .define('G', Items.DIRT)
                .define('W', Items.ACACIA_LOG)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_windswept_savanna");

        ItemStack woodedbadlandscore = new ItemStack(ModItems.BIOMECORE.get());
        woodedbadlandscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("wooded_badlands"));
        woodedbadlandscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("red_sand"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, woodedbadlandscore)
                .pattern("OOO")
                .pattern("DUD")
                .pattern("SSS")
                .define('S', Items.RED_SAND)
                .define('D', Items.DIRT)
                .define('O', Items.OAK_LOG)
                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
                .save(recipeOutput, "bigsbiomemagicmod:biomecore_wooded_badlands");

//
//        ItemStack blankcore = new ItemStack(ModItems.BIOMECORE.get());
//        blankcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("blank"));
//        blankcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("blank"));
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, blankcore)
//                .pattern("SSS")
//                .pattern("SUS")
//                .pattern("SSS")
//                .define('S', Items.blank)
//                .define('U', ModItems.UNATTUNEDBIOMECORE.get())
//                .unlockedBy("has_unattunedbiomecore", has(ModItems.UNATTUNEDBIOMECORE))
//                .save(recipeOutput, "bigsbiomemagicmod:biomecore_blank");
//
// }

        ItemStack pillagerPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        pillagerPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("pillager_outpost"));
        UnripeStructurePodRecipeBuilder.recipe(pillagerPod, Items.DARK_OAK_PLANKS, Items.ARROW)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_pillager_outpost"));

        ItemStack mineshaftPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        mineshaftPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("mineshaft"));
        UnripeStructurePodRecipeBuilder.recipe(mineshaftPod, Items.RAIL, Items.STONE)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mineshaft"));

        ItemStack mesaMineshaftPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        mesaMineshaftPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("mineshaft_mesa"));
        UnripeStructurePodRecipeBuilder.recipe(mesaMineshaftPod, Items.RAIL, Items.TERRACOTTA)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mineshaft_mesa"));

        ItemStack mansionPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        mansionPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("mansion"));
        UnripeStructurePodRecipeBuilder.recipe(mansionPod, Items.DARK_OAK_PLANKS, Items.EMERALD)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mansion"));

        ItemStack junglePod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        junglePod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("jungle_pyramid"));
        UnripeStructurePodRecipeBuilder.recipe(junglePod, Items.MOSSY_COBBLESTONE, Items.VINE)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_jungle_pyramid"));

        ItemStack desertPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        desertPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("desert_pyramid"));
        UnripeStructurePodRecipeBuilder.recipe(desertPod, Items.SANDSTONE, Items.SAND)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_desert_pyramid"));

        ItemStack iglooPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        iglooPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("igloo"));
        UnripeStructurePodRecipeBuilder.recipe(iglooPod, Items.SNOW_BLOCK, Items.STONE_BRICKS)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_igloo"));

        ItemStack shipwreckPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        shipwreckPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("shipwreck"));
        UnripeStructurePodRecipeBuilder.recipe(shipwreckPod, Items.OAK_PLANKS, Items.OAK_LOG)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_shipwreck"));

        ItemStack beachedShipwreckPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        beachedShipwreckPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("shipwreck_beached"));
        UnripeStructurePodRecipeBuilder.recipe(beachedShipwreckPod, Items.SAND, Items.OAK_LOG)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_shipwreck_beached"));

        ItemStack swampHutPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        swampHutPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("swamp_hut"));
        UnripeStructurePodRecipeBuilder.recipe(swampHutPod, Items.SPRUCE_PLANKS, Items.LILY_PAD)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_swamp_hut"));

        ItemStack strongholdPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        strongholdPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("stronghold"));
        UnripeStructurePodRecipeBuilder.recipe(strongholdPod, Items.ENDER_EYE, Items.STONE_BRICKS)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_stronghold"));

        ItemStack monumentPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        monumentPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("monument"));
        UnripeStructurePodRecipeBuilder.recipe(monumentPod, Items.COD, Items.PRISMARINE_SHARD)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_monument"));

        ItemStack coldOceanPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        coldOceanPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("ocean_ruin_cold"));
        UnripeStructurePodRecipeBuilder.recipe(coldOceanPod, Items.STONE_BRICKS, Items.GRAVEL)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_ocean_ruin_cold"));

        ItemStack warmOceanPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        warmOceanPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("ocean_ruin_warm"));
        UnripeStructurePodRecipeBuilder.recipe(warmOceanPod, Items.CUT_SANDSTONE, Items.POLISHED_GRANITE)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_ocean_ruin_warm"));

        ItemStack fortressPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        fortressPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("fortress"));
        UnripeStructurePodRecipeBuilder.recipe(fortressPod, Items.NETHER_BRICK, Items.GOLD_INGOT)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_fortress"));

        ItemStack fossilPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        fossilPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("nether_fossil"));
        UnripeStructurePodRecipeBuilder.recipe(fossilPod, Items.BONE_MEAL, Items.BONE_MEAL)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_nether_fossil"));

        ItemStack endCityPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        endCityPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("end_city"));
        UnripeStructurePodRecipeBuilder.recipe(endCityPod, Items.POPPED_CHORUS_FRUIT, Items.END_STONE)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_end_city"));

        ItemStack buriedTreasurePod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        buriedTreasurePod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("buried_treasure"));
        UnripeStructurePodRecipeBuilder.recipe(buriedTreasurePod, Items.CHEST, Items.MAP)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_buried_treasure"));

        ItemStack bastionRemnentPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        bastionRemnentPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("bastion_remnant"));
        UnripeStructurePodRecipeBuilder.recipe(bastionRemnentPod, Items.BLACKSTONE, Items.GOLD_INGOT)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_bastion_remnant"));

        ItemStack plainsVillagePod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        plainsVillagePod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("village_plains"));
        UnripeStructurePodRecipeBuilder.recipe(plainsVillagePod, Items.DIRT, Items.EMERALD)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_village_plains"));

        ItemStack desertVillagePod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        desertVillagePod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("village_desert"));
        UnripeStructurePodRecipeBuilder.recipe(desertVillagePod, Items.SAND, Items.EMERALD)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_village_desert"));

        ItemStack savannaVillagePod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        savannaVillagePod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("village_savanna"));
        UnripeStructurePodRecipeBuilder.recipe(savannaVillagePod, Items.ACACIA_LOG, Items.EMERALD)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_village_savanna"));

        ItemStack snowyVillagePod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        snowyVillagePod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("village_snowy"));
        UnripeStructurePodRecipeBuilder.recipe(snowyVillagePod, Items.SNOW_BLOCK, Items.EMERALD)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_village_snowy"));

        ItemStack taigaVillagePod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        taigaVillagePod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("village_taiga"));
        UnripeStructurePodRecipeBuilder.recipe(taigaVillagePod, Items.SPRUCE_LOG, Items.EMERALD)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_village_taiga"));

        ItemStack ruinedPortalPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        ruinedPortalPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("ruined_portal"));
        UnripeStructurePodRecipeBuilder.recipe(ruinedPortalPod, Items.CRYING_OBSIDIAN, Items.GOLD_NUGGET)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_ruined_portal"));

        ItemStack ruinedDesertPortalPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        ruinedDesertPortalPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("ruined_portal_desert"));
        UnripeStructurePodRecipeBuilder.recipe(ruinedDesertPortalPod, Items.CRYING_OBSIDIAN, Items.SAND)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_ruined_portal_desert"));

        ItemStack ruinedJunglePortalPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        ruinedJunglePortalPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("ruined_portal_jungle"));
        UnripeStructurePodRecipeBuilder.recipe(ruinedJunglePortalPod, Items.CRYING_OBSIDIAN, Items.VINE)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_ruined_portal_jungle"));

        ItemStack ruinedSwampPortalPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        ruinedSwampPortalPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("ruined_portal_swamp"));
        UnripeStructurePodRecipeBuilder.recipe(ruinedSwampPortalPod, Items.CRYING_OBSIDIAN, Items.LILY_PAD)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_ruined_portal_swamp"));

        ItemStack ruinedMountainPortalPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        ruinedMountainPortalPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("ruined_portal_mountain"));
        UnripeStructurePodRecipeBuilder.recipe(ruinedMountainPortalPod, Items.CRYING_OBSIDIAN, Items.SNOW_BLOCK)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_ruined_portal_mountain"));

        ItemStack ruinedOceanPortalPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        ruinedOceanPortalPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("ruined_portal_ocean"));
        UnripeStructurePodRecipeBuilder.recipe(ruinedOceanPortalPod, Items.CRYING_OBSIDIAN, Items.MAGMA_BLOCK)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_ruined_portal_ocean"));

        ItemStack ruinedNetherPortalPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        ruinedNetherPortalPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("ruined_portal_nether"));
        UnripeStructurePodRecipeBuilder.recipe(ruinedNetherPortalPod, Items.CRYING_OBSIDIAN, Items.NETHERRACK)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_ruined_portal_nether"));

        ItemStack ancientCityPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        ancientCityPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("ancient_city"));
        UnripeStructurePodRecipeBuilder.recipe(ancientCityPod, Items.DEEPSLATE_BRICKS, Items.DEEPSLATE_BRICKS)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_ancient_city"));

        ItemStack trailRuinsPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        trailRuinsPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("trail_ruins"));
        UnripeStructurePodRecipeBuilder.recipe(trailRuinsPod, Items.MUD_BRICKS, Items.BRICKS)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_trail_ruins"));

        ItemStack trialchamberPod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        trialchamberPod.set(ModDataComponents.STRUCTURELOCATION.get(), ResourceLocation.withDefaultNamespace("trial_chambers"));
        UnripeStructurePodRecipeBuilder.recipe(trialchamberPod, Items.COPPER_BLOCK, Items.COPPER_BLOCK)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_trial_chambers"));

        ItemStack minioutpostpod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minioutpostpod.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_outpost"));
        UnripeStructurePodRecipeBuilder.recipe(minioutpostpod, Items.GLOW_LICHEN, Items.ARROW)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_outpost"));

        ItemStack minimineshaftpostpod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minimineshaftpostpod.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_mineshaft"));
        UnripeStructurePodRecipeBuilder.recipe(minimineshaftpostpod, Items.GLOW_LICHEN, Items.RAIL)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_mineshaft"));

        ItemStack minijunglepod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minijunglepod.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_jungle_pyramid"));
        UnripeStructurePodRecipeBuilder.recipe(minijunglepod, Items.GLOW_LICHEN, Items.MOSSY_COBBLESTONE)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_jungle_pyramid"));

        ItemStack minidesertpod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minidesertpod.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_desert_pyramid"));
        UnripeStructurePodRecipeBuilder.recipe(minidesertpod, Items.GLOW_LICHEN, Items.SANDSTONE)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_desert_pyramid"));

        ItemStack miniigloopod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        miniigloopod.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_igloo"));
        UnripeStructurePodRecipeBuilder.recipe(miniigloopod, Items.GLOW_LICHEN, Items.SNOW_BLOCK)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_igloo"));

        ItemStack minishipwreckpod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minishipwreckpod.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_shipwreck"));
        UnripeStructurePodRecipeBuilder.recipe(minishipwreckpod, Items.GLOW_LICHEN, Items.OAK_LOG)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_shipwreck"));

        ItemStack ministrongholdpod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        ministrongholdpod.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_stronghold"));
        UnripeStructurePodRecipeBuilder.recipe(ministrongholdpod, Items.GLOW_LICHEN, Items.ENDER_EYE)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_stronghold"));

        ItemStack minimonumentpod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minimonumentpod.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_monument"));
        UnripeStructurePodRecipeBuilder.recipe(minimonumentpod, Items.GLOW_LICHEN, Items.PRISMARINE_SHARD)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_monument"));

        ItemStack minioceanruinspod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minioceanruinspod.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_ocean_ruins"));
        UnripeStructurePodRecipeBuilder.recipe(minioceanruinspod, Items.GLOW_LICHEN, Items.GRAVEL)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_ocean_ruins"));

        ItemStack minifortresspod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minifortresspod.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_fortress"));
        UnripeStructurePodRecipeBuilder.recipe(minifortresspod, Items.GLOW_LICHEN, Items.NETHER_BRICK)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_fortress"));

        ItemStack minitreasurepod = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minitreasurepod.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_buried_treasure"));
        UnripeStructurePodRecipeBuilder.recipe(minitreasurepod, Items.GLOW_LICHEN, Items.MAP)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_buried_treasure"));

        ItemStack minimansion = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minimansion.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_mansion"));
        UnripeStructurePodRecipeBuilder.recipe(minimansion, Items.GLOW_LICHEN, Items.DARK_OAK_PLANKS)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_mansion"));

        ItemStack miniendcity = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        miniendcity.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_end_city"));
        UnripeStructurePodRecipeBuilder.recipe(miniendcity, Items.GLOW_LICHEN, Items.END_STONE)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_end_city"));

        ItemStack minivillage = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minivillage.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_village"));
        UnripeStructurePodRecipeBuilder.recipe(minivillage, Items.GLOW_LICHEN, Items.EMERALD)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_village"));

        ItemStack miniancientcity = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        miniancientcity.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_ancient_city"));
        UnripeStructurePodRecipeBuilder.recipe(miniancientcity, Items.GLOW_LICHEN, Items.DEEPSLATE_BRICKS)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_ancient_city"));

        ItemStack minitrailruin = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minitrailruin.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_trail_ruin"));
        UnripeStructurePodRecipeBuilder.recipe(minitrailruin, Items.GLOW_LICHEN, Items.BRICKS)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_trail_ruin"));

        ItemStack minibastion = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minibastion.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_bastion"));
        UnripeStructurePodRecipeBuilder.recipe(minibastion, Items.GLOW_LICHEN, Items.BLACKSTONE)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_bastion"));

        ItemStack minitrialchamber = new ItemStack(ModBlocks.STRUCTUREPOD.get());
        minitrialchamber.set(ModDataComponents.STRUCTURELOCATION, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "mini_trial_chamber"));
        UnripeStructurePodRecipeBuilder.recipe(minitrialchamber, Items.GLOW_LICHEN, Items.COPPER_BLOCK)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath("bigsbiomemagicmod", "structurepod_mini_trial_chamber"));


    }}
