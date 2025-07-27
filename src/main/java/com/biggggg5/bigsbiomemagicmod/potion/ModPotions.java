package com.biggggg5.bigsbiomemagicmod.potion;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import com.biggggg5.bigsbiomemagicmod.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, BigsBiomeMagicMod.MOD_ID);

    public static final Holder<Potion> BIOME_VISION_POTION = POTIONS.register("biome_vision_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.BIOME_VISION_EFFECT, 12000, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
