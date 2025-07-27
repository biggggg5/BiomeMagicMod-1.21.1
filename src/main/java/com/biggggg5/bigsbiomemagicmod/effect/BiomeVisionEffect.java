package com.biggggg5.bigsbiomemagicmod.effect;

import com.biggggg5.bigsbiomemagicmod.effect.util.BiomeParticleColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustColorTransitionOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import org.joml.Vector3f;

public class BiomeVisionEffect extends MobEffect {
    protected BiomeVisionEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {

        Level level = livingEntity.level();
        BlockPos entityPos = livingEntity.blockPosition();
        Biome currentBiome = level.getBiome(entityPos).value();

        BlockPos.betweenClosedStream(entityPos.offset(-10, -10, -10), entityPos.offset(10, 10, 10))
                .filter(pos -> pos.closerThan(entityPos, 10.5))
                .filter(pos -> level.getBlockState(pos).isAir())
                .forEach(pos -> {
                    Biome biomeAtPos = level.getBiome(pos).value();

                    ResourceKey<Biome> otherBiomeKey = getBiomeKey(level, pos);


                    Vector3f startColor = BiomeParticleColors.getTop(otherBiomeKey);
                    Vector3f endColor = BiomeParticleColors.getBottom(otherBiomeKey);


                    ParticleOptions biomeParticle = new DustColorTransitionOptions(startColor, endColor, 1.0f);

                    if (!biomeAtPos.equals(currentBiome)) {
                        double x = pos.getX() + 0.5;
                        double y = pos.getY() + 0.5;
                        double z = pos.getZ() + 0.5;

                        level.addParticle(biomeParticle, x, y, z, 0, 0, 0);
                    }
                });


        return true;
    }

    private static ResourceKey<Biome> getBiomeKey(Level level, BlockPos pos) {

        return level.registryAccess()
                .registryOrThrow(Registries.BIOME)
                .getResourceKey(level.getBiome(pos).value())
                .orElse(null);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }}
