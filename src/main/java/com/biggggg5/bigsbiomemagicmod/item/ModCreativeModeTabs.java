package com.biggggg5.bigsbiomemagicmod.item;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import com.biggggg5.bigsbiomemagicmod.block.ModBlocks;
import com.biggggg5.bigsbiomemagicmod.component.ModDataComponents;
import com.biggggg5.bigsbiomemagicmod.potion.ModPotions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BigsBiomeMagicMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BIOME_MAGIC_ITEMS = CREATIVE_MODE_TAB.register("biome_magic_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BIOMEGOOP.get()))
                    .title(Component.translatable("creativetab.bigsbiomemagicmod.biome_magic_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BIOMEGOOP);
                        output.accept(ModItems.BIOMEGOGGLES);
                        output.accept(ModItems.GLASSORB);
                        output.accept(ModItems.UNATTUNEDBIOMECORE);
                        output.accept(ModItems.BIOMECORE);
                        output.accept(ModItems.STRUCTURESEEDS);
                        output.accept(ModItems.STAFFOFSECRETPOWER);
                        output.accept(ModItems.COPPERSTAFFOFSECRETPOWER);
                        output.accept(ModItems.IRONSTAFFOFSECRETPOWER);
                        output.accept(ModItems.GOLDSTAFFOFSECRETPOWER);
                        output.accept(ModItems.NETHERITESTAFFOFSECRETPOWER);

                        output.accept(PotionContents.createItemStack(Items.POTION, ModPotions.BIOME_VISION_POTION));
                        output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.BIOME_VISION_POTION));
                        output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, ModPotions.BIOME_VISION_POTION));

                        output.accept(ModBlocks.WATERSOURCEGEM);
                        output.accept(ModBlocks.STRUCTUREPOD);
                        output.accept(ModBlocks.BIOMECHANNELER);
                    })


                    .build());

    public static final Supplier<CreativeModeTab> BIOME_MAGIC_CATALYSTS = CREATIVE_MODE_TAB.register("biome_magic_catalysts_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BIOMECORE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(BigsBiomeMagicMod.MOD_ID, "biome_magic_items_tab"))
                    .title(Component.translatable("creativetab.bigsbiomemagicmod.biome_magic_catalysts"))
                    .displayItems((itemDisplayParameters, output) -> {


                        ItemStack badlandscore = new ItemStack(ModItems.BIOMECORE.get());
                        badlandscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("badlands"));
                        badlandscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("red_sand"));
                        output.accept(badlandscore);

                        ItemStack bamboocore = new ItemStack(ModItems.BIOMECORE.get());
                        bamboocore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("bamboo_jungle"));
                        bamboocore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("bamboo"));
                        output.accept(bamboocore);

                        ItemStack basaltcore = new ItemStack(ModItems.BIOMECORE.get());
                        basaltcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("basalt_deltas"));
                        basaltcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("basalt"));
                        output.accept(basaltcore);

                        ItemStack beachcore = new ItemStack(ModItems.BIOMECORE.get());
                        beachcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("beach"));
                        beachcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("sand"));
                        output.accept(beachcore);

                        ItemStack birchcore = new ItemStack(ModItems.BIOMECORE.get());
                        birchcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("birch_forest"));
                        birchcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("birch_log"));
                        output.accept(birchcore);

                        ItemStack cherrycore = new ItemStack(ModItems.BIOMECORE.get());
                        cherrycore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("cherry_grove"));
                        cherrycore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("cherry_log"));
                        output.accept(cherrycore);

                        ItemStack crimsoncore = new ItemStack(ModItems.BIOMECORE.get());
                        crimsoncore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("crimson_forest"));
                        crimsoncore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("crimson_nylium"));
                        output.accept(crimsoncore);

                        ItemStack coldcore = new ItemStack(ModItems.BIOMECORE.get());
                        coldcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("cold_ocean"));
                        coldcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));
                        output.accept(coldcore);

                        ItemStack darkoakcore = new ItemStack(ModItems.BIOMECORE.get());
                        darkoakcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("dark_forest"));
                        darkoakcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("dark_oak_log"));
                        output.accept(darkoakcore);

                        ItemStack deepcoldcore = new ItemStack(ModItems.BIOMECORE.get());
                        deepcoldcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("deep_cold_ocean"));
                        deepcoldcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));
                        output.accept(deepcoldcore);

                        ItemStack deepdarkcore = new ItemStack(ModItems.BIOMECORE.get());
                        deepdarkcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("deep_dark"));
                        deepdarkcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("sculk"));
                        output.accept(deepdarkcore);

                        ItemStack deepfrozencore = new ItemStack(ModItems.BIOMECORE.get());
                        deepfrozencore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("deep_frozen_ocean"));
                        deepfrozencore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));
                        output.accept(deepfrozencore);

                        ItemStack deeplukewarmcore = new ItemStack(ModItems.BIOMECORE.get());
                        deeplukewarmcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("deep_lukewarm_ocean"));
                        deeplukewarmcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));
                        output.accept(deeplukewarmcore);

                        ItemStack deepoceancore = new ItemStack(ModItems.BIOMECORE.get());
                        deepoceancore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("deep_ocean"));
                        deepoceancore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));
                        output.accept(deepoceancore);

                        ItemStack desertcore = new ItemStack(ModItems.BIOMECORE.get());
                        desertcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("desert"));
                        desertcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("sand"));
                        output.accept(desertcore);

                        ItemStack dripcore = new ItemStack(ModItems.BIOMECORE.get());
                        dripcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("dripstone_caves"));
                        dripcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("dripstone_block"));
                        output.accept(dripcore);

                        ItemStack endbarrenscore = new ItemStack(ModItems.BIOMECORE.get());
                        endbarrenscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("end_barrens"));
                        endbarrenscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("end_stone"));
                        output.accept(endbarrenscore);

                        ItemStack endhighlandscore = new ItemStack(ModItems.BIOMECORE.get());
                        endhighlandscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("end_highlands"));
                        endhighlandscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("end_stone"));
                        output.accept(endhighlandscore);

                        ItemStack endmidlandscore = new ItemStack(ModItems.BIOMECORE.get());
                        endmidlandscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("end_midlands"));
                        endmidlandscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("end_stone"));
                        output.accept(endmidlandscore);

                        ItemStack erodedcore = new ItemStack(ModItems.BIOMECORE.get());
                        erodedcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("eroded_badlands"));
                        erodedcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("red_sandstone"));
                        output.accept(erodedcore);

                        ItemStack flowerforestcore = new ItemStack(ModItems.BIOMECORE.get());
                        flowerforestcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("flower_forest"));
                        flowerforestcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("oak_log"));
                        output.accept(flowerforestcore);

                        ItemStack forestcore = new ItemStack(ModItems.BIOMECORE.get());
                        forestcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("forest"));
                        forestcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("oak_log"));
                        output.accept(forestcore);

                        ItemStack frozencore = new ItemStack(ModItems.BIOMECORE.get());
                        frozencore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("frozen_ocean"));
                        frozencore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));
                        output.accept(frozencore);

                        ItemStack frozenpeakscore = new ItemStack(ModItems.BIOMECORE.get());
                        frozenpeakscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("frozen_peaks"));
                        frozenpeakscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("snow_block"));
                        output.accept(frozenpeakscore);

                        ItemStack frozenrivercore = new ItemStack(ModItems.BIOMECORE.get());
                        frozenrivercore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("frozen_river"));
                        frozenrivercore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("ice"));
                        output.accept(frozenrivercore);

                        ItemStack grovecore = new ItemStack(ModItems.BIOMECORE.get());
                        grovecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("grove"));
                        grovecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("snow_block"));
                        output.accept(grovecore);

                        ItemStack icespikescore = new ItemStack(ModItems.BIOMECORE.get());
                        icespikescore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("ice_spikes"));
                        icespikescore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("snow_block"));
                        output.accept(icespikescore);


                        ItemStack jaggedpeakscore = new ItemStack(ModItems.BIOMECORE.get());
                        jaggedpeakscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("jagged_peaks"));
                        jaggedpeakscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("stone"));
                        output.accept(jaggedpeakscore);

                        ItemStack junglecore = new ItemStack(ModItems.BIOMECORE.get());
                        junglecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("jungle"));
                        junglecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("jungle_log"));
                        output.accept(junglecore);

                        ItemStack lukewarmcore = new ItemStack(ModItems.BIOMECORE.get());
                        lukewarmcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("lukewarm_ocean"));
                        lukewarmcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));
                        output.accept(lukewarmcore);

                        ItemStack lushcavescore = new ItemStack(ModItems.BIOMECORE.get());
                        lushcavescore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("lush_caves"));
                        lushcavescore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("moss_block"));
                        output.accept(lushcavescore);

                        ItemStack mangrovecore = new ItemStack(ModItems.BIOMECORE.get());
                        mangrovecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("mangrove_swamp"));
                        mangrovecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("mangrove_log"));
                        output.accept(mangrovecore);

                        ItemStack meadowcore = new ItemStack(ModItems.BIOMECORE.get());
                        meadowcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("meadow"));
                        meadowcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("dirt"));
                        output.accept(meadowcore);

                        ItemStack mushroomcore = new ItemStack(ModItems.BIOMECORE.get());
                        mushroomcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("mushroom_fields"));
                        mushroomcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("mycelium"));
                        output.accept(mushroomcore);

                        ItemStack netherwastescore = new ItemStack(ModItems.BIOMECORE.get());
                        netherwastescore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("nether_wastes"));
                        netherwastescore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("netherrack"));
                        output.accept(netherwastescore);

                        ItemStack oceancore = new ItemStack(ModItems.BIOMECORE.get());
                        oceancore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("ocean"));
                        oceancore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));
                        output.accept(oceancore);

                        ItemStack oldbirchcore = new ItemStack(ModItems.BIOMECORE.get());
                        oldbirchcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("old_growth_birch_forest"));
                        oldbirchcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("birch_log"));
                        output.accept(oldbirchcore);

                        ItemStack oldpinecore = new ItemStack(ModItems.BIOMECORE.get());
                        oldpinecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("old_growth_pine_taiga"));
                        oldpinecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("spruce_log"));
                        output.accept(oldpinecore);

                        ItemStack oldsprucecore = new ItemStack(ModItems.BIOMECORE.get());
                        oldsprucecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("old_growth_spruce_taiga"));
                        oldsprucecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("spruce_log"));
                        output.accept(oldsprucecore);

                        ItemStack plainscore = new ItemStack(ModItems.BIOMECORE.get());
                        plainscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("plains"));
                        plainscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("dirt"));
                        output.accept(plainscore);

                        ItemStack rivercore = new ItemStack(ModItems.BIOMECORE.get());
                        rivercore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("river"));
                        rivercore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));
                        output.accept(rivercore);

                        ItemStack savannacore = new ItemStack(ModItems.BIOMECORE.get());
                        savannacore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("savanna"));
                        savannacore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("acacia_log"));
                        output.accept(savannacore);

                        ItemStack savannaplateaucore = new ItemStack(ModItems.BIOMECORE.get());
                        savannaplateaucore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("savanna_plateau"));
                        savannaplateaucore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("acacia_log"));
                        output.accept(savannaplateaucore);

                        ItemStack endislandscore = new ItemStack(ModItems.BIOMECORE.get());
                        endislandscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("small_end_islands"));
                        endislandscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("end_stone"));
                        output.accept(endislandscore);

                        ItemStack snowybeachcore = new ItemStack(ModItems.BIOMECORE.get());
                        snowybeachcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("snowy_beach"));
                        snowybeachcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("sand"));
                        output.accept(snowybeachcore);

                        ItemStack snowyplainscore = new ItemStack(ModItems.BIOMECORE.get());
                        snowyplainscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("snowy_plains"));
                        snowyplainscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("snow_block"));
                        output.accept(snowyplainscore);

                        ItemStack snowyslopescore = new ItemStack(ModItems.BIOMECORE.get());
                        snowyslopescore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("snowy_slopes"));
                        snowyslopescore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("snow_block"));
                        output.accept(snowyslopescore);

                        ItemStack snowytaigacore = new ItemStack(ModItems.BIOMECORE.get());
                        snowytaigacore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("snowy_taiga"));
                        snowytaigacore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("dirt"));
                        output.accept(snowytaigacore);

                        ItemStack soulsandvalleycore = new ItemStack(ModItems.BIOMECORE.get());
                        soulsandvalleycore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("soul_sand_valley"));
                        soulsandvalleycore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("soul_sand"));
                        output.accept(soulsandvalleycore);

                        ItemStack sparsejunglecore = new ItemStack(ModItems.BIOMECORE.get());
                        sparsejunglecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("sparse_jungle"));
                        sparsejunglecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("dirt"));
                        output.accept(sparsejunglecore);

                        ItemStack stonypeakscore = new ItemStack(ModItems.BIOMECORE.get());
                        stonypeakscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("stony_peaks"));
                        stonypeakscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("stone"));
                        output.accept(stonypeakscore);

                        ItemStack stonyshorecore = new ItemStack(ModItems.BIOMECORE.get());
                        stonyshorecore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("stony_shore"));
                        stonyshorecore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("stone"));
                        output.accept(stonyshorecore);

                        ItemStack sunflowercore = new ItemStack(ModItems.BIOMECORE.get());
                        sunflowercore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("sunflower_plains"));
                        sunflowercore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("sunflower"));
                        output.accept(sunflowercore);

                        ItemStack swampcore = new ItemStack(ModItems.BIOMECORE.get());
                        swampcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("swamp"));
                        swampcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));
                        output.accept(swampcore);

                        ItemStack taigacore = new ItemStack(ModItems.BIOMECORE.get());
                        taigacore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("taiga"));
                        taigacore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("spruce_log"));
                        output.accept(taigacore);

                        ItemStack theendcore = new ItemStack(ModItems.BIOMECORE.get());
                        theendcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("the_end"));
                        theendcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("endstone"));
                        output.accept(theendcore);

                        ItemStack voidcore = new ItemStack(ModItems.BIOMECORE.get());
                        voidcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("the_void"));
                        voidcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("air"));
                        output.accept(voidcore);

                        ItemStack warmoceancore = new ItemStack(ModItems.BIOMECORE.get());
                        warmoceancore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("warm_ocean"));
                        warmoceancore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("water"));
                        output.accept(warmoceancore);

                        ItemStack warpedforestcore = new ItemStack(ModItems.BIOMECORE.get());
                        warpedforestcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("warped_forest"));
                        warpedforestcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("warped_nylium"));
                        output.accept(warpedforestcore);

                        ItemStack windsweptforestcore = new ItemStack(ModItems.BIOMECORE.get());
                        windsweptforestcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("windswept_forest"));
                        windsweptforestcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("grass_block"));
                        output.accept(windsweptforestcore);

                        ItemStack windsweptgravelcore = new ItemStack(ModItems.BIOMECORE.get());
                        windsweptgravelcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("windswept_gravelly_hills"));
                        windsweptgravelcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("gravel"));
                        output.accept(windsweptgravelcore);

                        ItemStack windswepthillcore = new ItemStack(ModItems.BIOMECORE.get());
                        windswepthillcore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("windswept_hills"));
                        windswepthillcore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("gravel"));
                        output.accept(windswepthillcore);

                        ItemStack windsweptsavannacore = new ItemStack(ModItems.BIOMECORE.get());
                        windsweptsavannacore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("windswept_savanna"));
                        windsweptsavannacore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("acacia_log"));
                        output.accept(windsweptsavannacore);

                        ItemStack woodedbadlandscore = new ItemStack(ModItems.BIOMECORE.get());
                        woodedbadlandscore.set(ModDataComponents.BIOMELOCATION, ResourceLocation.withDefaultNamespace("wooded_badlands"));
                        woodedbadlandscore.set(ModDataComponents.BIOMECATALYST, ResourceLocation.withDefaultNamespace("red_sand"));
                        output.accept(woodedbadlandscore);





                    })


                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
