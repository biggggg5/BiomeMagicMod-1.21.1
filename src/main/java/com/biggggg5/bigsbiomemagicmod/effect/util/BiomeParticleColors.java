package com.biggggg5.bigsbiomemagicmod.effect.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import org.joml.Vector3f;

import java.util.HashMap;
import java.util.Map;

public class BiomeParticleColors {
    private static final Vector3f DEFAULT_TOP = new Vector3f(0.83f, 0.0f, 1.0f);
    private static final Vector3f DEFAULT_BOTTOM = new Vector3f(0.0f, 0.0f, 0.0f);

    private static final Map<ResourceLocation, Vector3f> TOP_COLORS = new HashMap<>();
    private static final Map<ResourceLocation, Vector3f> BOTTOM_COLORS = new HashMap<>();



    static {
        TOP_COLORS.put(Biomes.PLAINS.location(), new Vector3f(0.3f, 0.39f, 0.18f));
        BOTTOM_COLORS.put(Biomes.PLAINS.location(), new Vector3f(0.37f, 0.26f, 0.18f));

        TOP_COLORS.put(Biomes.DESERT.location(), new Vector3f(0.84f, 0.79f, 0.62f));
        BOTTOM_COLORS.put(Biomes.DESERT.location(), new Vector3f(0.8f, 0.75f, 0.6f));

        TOP_COLORS.put(Biomes.SNOWY_PLAINS.location(), new Vector3f(0.88f, 0.91f, 0.91f));
        BOTTOM_COLORS.put(Biomes.SNOWY_PLAINS.location(), new Vector3f(0.31f, 0.26f, 0.18f));

        TOP_COLORS.put(Biomes.BADLANDS.location(), new Vector3f(0.722f, 0.388f, 0.122f));
        BOTTOM_COLORS.put(Biomes.BADLANDS.location(), new Vector3f(0.341f, 0.2f, 0.114f));

        TOP_COLORS.put(Biomes.BAMBOO_JUNGLE.location(), new Vector3f(0.37f, 0.36f, 0.18f));
        BOTTOM_COLORS.put(Biomes.BAMBOO_JUNGLE.location(), new Vector3f(0.3f, 0.39f, 0.18f));

        TOP_COLORS.put(Biomes.BASALT_DELTAS.location(), new Vector3f(0.361f, 0.361f, 0.361f));
        BOTTOM_COLORS.put(Biomes.BASALT_DELTAS.location(), new Vector3f(0.192f, 0.208f, 0.251f));

        TOP_COLORS.put(Biomes.BEACH.location(), new Vector3f(0.84f, 0.79f, 0.62f));
        BOTTOM_COLORS.put(Biomes.BEACH.location(), new Vector3f(0.071f, 0.341f, 0.498f));

        TOP_COLORS.put(Biomes.BIRCH_FOREST.location(), new Vector3f(0.471f, 0.424f, 0.29f));
        BOTTOM_COLORS.put(Biomes.BIRCH_FOREST.location(), new Vector3f(0.153f, 0.196f, 0.102f));

        TOP_COLORS.put(Biomes.CHERRY_GROVE.location(), new Vector3f(0.71f, 0.506f, 0.624f));
        BOTTOM_COLORS.put(Biomes.CHERRY_GROVE.location(), new Vector3f(0.114f, 0.071f, 0.094f));

        TOP_COLORS.put(Biomes.CRIMSON_FOREST.location(), new Vector3f(0.329f, 0f, 0f));
        BOTTOM_COLORS.put(Biomes.CRIMSON_FOREST.location(), new Vector3f(0.584f, 0.31f, 0.145f));

        TOP_COLORS.put(Biomes.COLD_OCEAN.location(), new Vector3f(0.106f, 0.118f, 0.875f));
        BOTTOM_COLORS.put(Biomes.COLD_OCEAN.location(), new Vector3f(0.059f, 0.067f, 0.51f));

        TOP_COLORS.put(Biomes.DARK_FOREST.location(), new Vector3f(0.125f, 0.09f, 0.055f));
        BOTTOM_COLORS.put(Biomes.DARK_FOREST.location(), new Vector3f(0.212f, 0.329f, 0.161f));

        TOP_COLORS.put(Biomes.DEEP_COLD_OCEAN.location(), new Vector3f(0.086f, 0.094f, 0.875f));
        BOTTOM_COLORS.put(Biomes.DEEP_COLD_OCEAN.location(), new Vector3f(0.333f, 0.557f, 0.529f)); //ocean mon color

        TOP_COLORS.put(Biomes.DEEP_DARK.location(), new Vector3f(0.078f, 0.169f, 0.204f));
        BOTTOM_COLORS.put(Biomes.DEEP_DARK.location(), new Vector3f(0.369f, 0.58f, 0.576f));

        TOP_COLORS.put(Biomes.DEEP_FROZEN_OCEAN.location(), new Vector3f(0.122f, 0.129f, 0.388f));
        BOTTOM_COLORS.put(Biomes.DEEP_FROZEN_OCEAN.location(), new Vector3f(0.333f, 0.557f, 0.529f));

        TOP_COLORS.put(Biomes.DEEP_LUKEWARM_OCEAN.location(), new Vector3f(0.137f, 0.322f, 0.447f));
        BOTTOM_COLORS.put(Biomes.DEEP_LUKEWARM_OCEAN.location(), new Vector3f(0.333f, 0.557f, 0.529f));

        TOP_COLORS.put(Biomes.DEEP_OCEAN.location(), new Vector3f(0.114f, 0.204f, 0.376f));
        BOTTOM_COLORS.put(Biomes.DEEP_OCEAN.location(), new Vector3f(0.333f, 0.557f, 0.529f));

        TOP_COLORS.put(Biomes.DRIPSTONE_CAVES.location(), new Vector3f(0.455f, 0.329f, 0.282f));
        BOTTOM_COLORS.put(Biomes.DRIPSTONE_CAVES.location(), new Vector3f(0.247f, 0.165f, 0.157f));

        TOP_COLORS.put(Biomes.END_BARRENS.location(), new Vector3f(0f, 0f, 0f));
        BOTTOM_COLORS.put(Biomes.END_BARRENS.location(), new Vector3f(0.937f, 0.961f, 0.718f)); //end stone

        TOP_COLORS.put(Biomes.END_HIGHLANDS.location(), new Vector3f(0.631f, 0.435f, 0.627f)); //purpur
        BOTTOM_COLORS.put(Biomes.END_HIGHLANDS.location(), new Vector3f(0.937f, 0.961f, 0.718f));

        TOP_COLORS.put(Biomes.END_MIDLANDS.location(), new Vector3f(0.937f, 0.961f, 0.718f));
        BOTTOM_COLORS.put(Biomes.END_MIDLANDS.location(), new Vector3f(0.631f, 0.435f, 0.627f));

        TOP_COLORS.put(Biomes.ERODED_BADLANDS.location(), new Vector3f(0.475f, 0.29f, 0.212f));
        BOTTOM_COLORS.put(Biomes.ERODED_BADLANDS.location(), new Vector3f(0.659f, 0.553f, 0.51f));

        TOP_COLORS.put(Biomes.FLOWER_FOREST.location(), new Vector3f(0.8f, 0.682f, 0.855f));
        BOTTOM_COLORS.put(Biomes.FLOWER_FOREST.location(), new Vector3f(0.208f, 0.259f, 0.157f));

        TOP_COLORS.put(Biomes.FOREST.location(), new Vector3f(0.239f, 0.373f, 0.165f));
        BOTTOM_COLORS.put(Biomes.FOREST.location(), new Vector3f(0.208f, 0.165f, 0.094f));

        TOP_COLORS.put(Biomes.FROZEN_OCEAN.location(), new Vector3f(0.122f, 0.129f, 0.388f));
        BOTTOM_COLORS.put(Biomes.FROZEN_OCEAN.location(), new Vector3f(0.482f, 0.635f, 0.894f)); //ice

        TOP_COLORS.put(Biomes.FROZEN_PEAKS.location(), new Vector3f(1f, 1f, 1f));
        BOTTOM_COLORS.put(Biomes.FROZEN_PEAKS.location(), new Vector3f(0.482f, 0.635f, 0.894f));

        TOP_COLORS.put(Biomes.FROZEN_RIVER.location(), new Vector3f(0.482f, 0.635f, 0.894f));
        BOTTOM_COLORS.put(Biomes.FROZEN_RIVER.location(), new Vector3f(1f, 1f, 1f));

        TOP_COLORS.put(Biomes.GROVE.location(), new Vector3f(1f, 1f, 1f));
        BOTTOM_COLORS.put(Biomes.GROVE.location(), new Vector3f(0.165f, 0.114f, 0.051f));

        TOP_COLORS.put(Biomes.ICE_SPIKES.location(), new Vector3f(0.369f, 0.467f, 0.671f));
        BOTTOM_COLORS.put(Biomes.ICE_SPIKES.location(), new Vector3f(1f, 1f, 1f));

        TOP_COLORS.put(Biomes.JAGGED_PEAKS.location(), new Vector3f(0.439f, 0.439f, 0.439f));
        BOTTOM_COLORS.put(Biomes.JAGGED_PEAKS.location(), new Vector3f(1f, 1f, 1f));

        TOP_COLORS.put(Biomes.JUNGLE.location(), new Vector3f(0.165f, 0.475f, 0.075f));
        BOTTOM_COLORS.put(Biomes.JUNGLE.location(), new Vector3f(0.157f, 0.133f, 0.047f));

        TOP_COLORS.put(Biomes.LUKEWARM_OCEAN.location(), new Vector3f(0.114f, 0.275f, 0.384f));
        BOTTOM_COLORS.put(Biomes.LUKEWARM_OCEAN.location(), new Vector3f(0.18f, 0.427f, 0.569f));

        TOP_COLORS.put(Biomes.LUSH_CAVES.location(), new Vector3f(0.439f, 0.537f, 0.165f));
        BOTTOM_COLORS.put(Biomes.LUSH_CAVES.location(), new Vector3f(0.773f, 0.588f, 0.31f));

        TOP_COLORS.put(Biomes.MANGROVE_SWAMP.location(), new Vector3f(0.255f, 0.318f, 0.075f));
        BOTTOM_COLORS.put(Biomes.MANGROVE_SWAMP.location(), new Vector3f(0.204f, 0.329f, 0.298f));

        TOP_COLORS.put(Biomes.MEADOW.location(), new Vector3f(0.267f, 0.361f, 0.255f));
        BOTTOM_COLORS.put(Biomes.MEADOW.location(), new Vector3f(0.42f, 0.298f, 0.216f));

        TOP_COLORS.put(Biomes.MUSHROOM_FIELDS.location(), new Vector3f(0.475f, 0.431f, 0.455f));
        BOTTOM_COLORS.put(Biomes.MUSHROOM_FIELDS.location(), new Vector3f(0.353f, 0.251f, 0.247f));

        TOP_COLORS.put(Biomes.NETHER_WASTES.location(), new Vector3f(0.698f, 0.322f, 0.086f));
        BOTTOM_COLORS.put(Biomes.NETHER_WASTES.location(), new Vector3f(0.176f, 0.051f, 0.055f));

        TOP_COLORS.put(Biomes.OCEAN.location(), new Vector3f(0.102f, 0.192f, 0.369f));
        BOTTOM_COLORS.put(Biomes.OCEAN.location(), new Vector3f(0.184f, 0.294f, 0.533f));

        TOP_COLORS.put(Biomes.OLD_GROWTH_BIRCH_FOREST.location(), new Vector3f(0.741f, 0.741f, 0.741f));
        BOTTOM_COLORS.put(Biomes.OLD_GROWTH_BIRCH_FOREST.location(), new Vector3f(0.106f, 0.157f, 0.059f));

        TOP_COLORS.put(Biomes.OLD_GROWTH_PINE_TAIGA.location(), new Vector3f(0.2f, 0.278f, 0.196f));
        BOTTOM_COLORS.put(Biomes.OLD_GROWTH_PINE_TAIGA.location(), new Vector3f(0.11f, 0.071f, 0.027f));

        TOP_COLORS.put(Biomes.OLD_GROWTH_SPRUCE_TAIGA.location(), new Vector3f(0.208f, 0.282f, 0.2f));
        BOTTOM_COLORS.put(Biomes.OLD_GROWTH_SPRUCE_TAIGA.location(), new Vector3f(0.259f, 0.161f, 0.051f));

        TOP_COLORS.put(Biomes.RIVER.location(), new Vector3f(0.004f, 0.227f, 0.435f));
        BOTTOM_COLORS.put(Biomes.RIVER.location(), new Vector3f(0.384f, 0.396f, 0.431f));

        TOP_COLORS.put(Biomes.SAVANNA.location(), new Vector3f(0.455f, 0.435f, 0.22f));
        BOTTOM_COLORS.put(Biomes.SAVANNA.location(), new Vector3f(0.251f, 0.235f, 0.2f));

        TOP_COLORS.put(Biomes.SAVANNA_PLATEAU.location(), new Vector3f(0.251f, 0.235f, 0.2f));
        BOTTOM_COLORS.put(Biomes.SAVANNA_PLATEAU.location(), new Vector3f(0.455f, 0.435f, 0.22f));

        TOP_COLORS.put(Biomes.SMALL_END_ISLANDS.location(), new Vector3f(0.937f, 0.961f, 0.718f));
        BOTTOM_COLORS.put(Biomes.SMALL_END_ISLANDS.location(), new Vector3f(0.227f, 0.588f, 0.537f));

        TOP_COLORS.put(Biomes.SNOWY_BEACH.location(), new Vector3f(1f, 1f, 1f));
        BOTTOM_COLORS.put(Biomes.SNOWY_BEACH.location(), new Vector3f(0.071f, 0.341f, 0.498f));

        TOP_COLORS.put(Biomes.SNOWY_SLOPES.location(), new Vector3f(0.894f, 0.914f, 0.914f));
        BOTTOM_COLORS.put(Biomes.SNOWY_SLOPES.location(), new Vector3f(0.459f, 0.471f, 0.467f));

        TOP_COLORS.put(Biomes.SNOWY_TAIGA.location(), new Vector3f(0.894f, 0.914f, 0.914f));
        BOTTOM_COLORS.put(Biomes.SNOWY_TAIGA.location(), new Vector3f(0.31f, 0.416f, 0.345f));

        TOP_COLORS.put(Biomes.SOUL_SAND_VALLEY.location(), new Vector3f(0.11f, 0.071f, 0.035f));
        BOTTOM_COLORS.put(Biomes.SOUL_SAND_VALLEY.location(), new Vector3f(0.227f, 0.588f, 0.537f));

        TOP_COLORS.put(Biomes.SPARSE_JUNGLE.location(), new Vector3f(0.294f, 0.533f, 0.204f));
        BOTTOM_COLORS.put(Biomes.SPARSE_JUNGLE.location(), new Vector3f(0.706f, 0.506f, 0.502f));

        TOP_COLORS.put(Biomes.STONY_PEAKS.location(), new Vector3f(0.337f, 0.341f, 0.345f));
        BOTTOM_COLORS.put(Biomes.STONY_PEAKS.location(), new Vector3f(0.62f, 0.62f, 0.62f));

        TOP_COLORS.put(Biomes.STONY_SHORE.location(), new Vector3f(0.451f, 0.451f, 0.451f));
        BOTTOM_COLORS.put(Biomes.STONY_SHORE.location(), new Vector3f(0.133f, 0.227f, 0.424f));

        TOP_COLORS.put(Biomes.SUNFLOWER_PLAINS.location(), new Vector3f(0.988f, 0.851f, 0.227f));
        BOTTOM_COLORS.put(Biomes.SUNFLOWER_PLAINS.location(), new Vector3f(0.353f, 0.447f, 0.224f));

        TOP_COLORS.put(Biomes.SWAMP.location(), new Vector3f(0.067f, 0.294f, 0.102f));
        BOTTOM_COLORS.put(Biomes.SWAMP.location(), new Vector3f(0.243f, 0.271f, 0.208f));

        TOP_COLORS.put(Biomes.TAIGA.location(), new Vector3f(0.114f, 0.075f, 0.027f));
        BOTTOM_COLORS.put(Biomes.TAIGA.location(), new Vector3f(0.247f, 0.337f, 0.239f));

        TOP_COLORS.put(Biomes.THE_END.location(), new Vector3f(0.937f, 0.961f, 0.718f));
        BOTTOM_COLORS.put(Biomes.THE_END.location(), new Vector3f(0f, 0f, 0f));

        TOP_COLORS.put(Biomes.THE_VOID.location(), new Vector3f(2f, 2f, 2f));
        BOTTOM_COLORS.put(Biomes.THE_VOID.location(), new Vector3f(2f, 2f, 2f));

        TOP_COLORS.put(Biomes.WARM_OCEAN.location(), new Vector3f(0.133f, 0.569f, 0.816f));
        BOTTOM_COLORS.put(Biomes.WARM_OCEAN.location(), new Vector3f(0.404f, 0.204f, 0.545f));

        TOP_COLORS.put(Biomes.WARPED_FOREST.location(), new Vector3f(0.086f, 0.396f, 0.31f));
        BOTTOM_COLORS.put(Biomes.WARPED_FOREST.location(), new Vector3f(0.396f, 0.196f, 0.122f));

        TOP_COLORS.put(Biomes.WINDSWEPT_FOREST.location(), new Vector3f(0.286f, 0.282f, 0.282f));
        BOTTOM_COLORS.put(Biomes.WINDSWEPT_FOREST.location(), new Vector3f(0.302f, 0.396f, 0.294f));

        TOP_COLORS.put(Biomes.WINDSWEPT_GRAVELLY_HILLS.location(), new Vector3f(0.522f, 0.506f, 0.502f));
        BOTTOM_COLORS.put(Biomes.WINDSWEPT_GRAVELLY_HILLS.location(), new Vector3f(0.161f, 0.161f, 0.153f));

        TOP_COLORS.put(Biomes.WINDSWEPT_HILLS.location(), new Vector3f(0.29f, 0.392f, 0.286f));
        BOTTOM_COLORS.put(Biomes.WINDSWEPT_HILLS.location(), new Vector3f(0.435f, 0.435f, 0.435f));

        TOP_COLORS.put(Biomes.WINDSWEPT_SAVANNA.location(), new Vector3f(0.137f, 0.137f, 0.027f));
        BOTTOM_COLORS.put(Biomes.WINDSWEPT_SAVANNA.location(), new Vector3f(0.302f, 0.302f, 0.3025f));

        TOP_COLORS.put(Biomes.WOODED_BADLANDS.location(), new Vector3f(0.58f, 0.384f, 0.267f));
        BOTTOM_COLORS.put(Biomes.WOODED_BADLANDS.location(), new Vector3f(0.161f, 0.129f, 0.078f));


    }
    public static Vector3f getTop(ResourceKey<Biome> biomeResourceKey) {
        return TOP_COLORS.getOrDefault(biomeResourceKey.location(), DEFAULT_TOP);
    }
        public static Vector3f getBottom(ResourceKey<Biome> biomeResourceKey) {
        return BOTTOM_COLORS.getOrDefault(biomeResourceKey.location(), DEFAULT_BOTTOM);
    }
}
