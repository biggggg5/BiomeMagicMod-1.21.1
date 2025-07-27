package com.biggggg5.bigsbiomemagicmod.effect;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, BigsBiomeMagicMod.MOD_ID);

    public static final Holder<MobEffect> BIOME_VISION_EFFECT = MOB_EFFECTS.register("biome_vision",
            () -> new BiomeVisionEffect(MobEffectCategory.BENEFICIAL, 0x36ebab));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
