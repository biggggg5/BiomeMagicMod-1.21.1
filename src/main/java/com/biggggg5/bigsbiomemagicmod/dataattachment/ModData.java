package com.biggggg5.bigsbiomemagicmod.dataattachment;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentSync;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModData {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
            DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, BigsBiomeMagicMod.MOD_ID);


    public static final Supplier<AttachmentType<HashMap<String, Long>>> FLUTE_COOLDOWNS =
            ATTACHMENT_TYPES.register("flute_cooldowns",
                    () -> AttachmentType.builder(() -> new HashMap<String, Long>())
                            .serialize(Codec.unboundedMap(Codec.STRING, Codec.LONG)
                                    .xmap(HashMap::new, map -> map)
                                    .fieldOf("data")
                                    .codec()).copyOnDeath()
                            .build());

    //Written by MrMisc29
    public static final Supplier<AttachmentType<ResourceLocation>> LOC = ATTACHMENT_TYPES.register("loc",
            ()-> AttachmentType.builder(()-> ResourceLocation.fromNamespaceAndPath("modid", "")).serialize(ResourceLocation.CODEC).sync(ResourceLocation.STREAM_CODEC).build());

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }
}

