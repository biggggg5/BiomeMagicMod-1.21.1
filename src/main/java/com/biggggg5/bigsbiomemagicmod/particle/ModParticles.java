package com.biggggg5.bigsbiomemagicmod.particle;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, BigsBiomeMagicMod.MOD_ID);

    public static final Supplier<SimpleParticleType> BRIGHT_RAID_PARTICLES =
            PARTICLE_TYPES.register("bright_raid_particles", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> BRIGHT_TRIAL_PARTICLES =
            PARTICLE_TYPES.register("bright_trial_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}