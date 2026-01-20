package com.biggggg5.bigsbiomemagicmod.component;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.createDataComponents(BigsBiomeMagicMod.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ResourceLocation>> BIOMELOCATION = register("biomelocation",
            builder -> builder.persistent(ResourceLocation.CODEC));

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ResourceLocation>> BIOMECATALYST = register("biomecatalyst",
            builder -> builder.persistent(ResourceLocation.CODEC));

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ResourceLocation>> STRUCTURELOCATION = register("structurelocation",
            builder -> builder.persistent(ResourceLocation.CODEC));


    private  static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
                                                                                           UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
