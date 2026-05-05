package com.biggggg5.bigsbiomemagicmod.entity;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import com.biggggg5.bigsbiomemagicmod.entity.custom.GlassOrbProjectileEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, BigsBiomeMagicMod.MOD_ID);


    public static final Supplier<EntityType<GlassOrbProjectileEntity>> GLASSORB =
            ENTITY_TYPES.register("glassorb", () -> EntityType.Builder.<GlassOrbProjectileEntity>of(GlassOrbProjectileEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f)
                            .clientTrackingRange(4).updateInterval(10).build("glassorb"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}