package com.biggggg5.bigsbiomemagicmod.block.entity;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import com.biggggg5.bigsbiomemagicmod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, BigsBiomeMagicMod.MOD_ID);

    public static final Supplier<BlockEntityType<BiomeChannelerBlockEntity>> BIOMECHANNELER_BE =
            BLOCK_ENTITIES.register("biomechanneler_be", () -> BlockEntityType.Builder.of(BiomeChannelerBlockEntity::new, ModBlocks.BIOMECHANNELER.get()).build(null));
    public static final Supplier<BlockEntityType<StructurePodBlockEntity>> STRUCTUREPOD_BE =
            BLOCK_ENTITIES.register("structurepod_be", () -> BlockEntityType.Builder.of(StructurePodBlockEntity::new, ModBlocks.STRUCTUREPOD.get()).build(null));
    public static final Supplier<BlockEntityType<UnripeStructurePodBlockEntity>> UNRIPESTRUCTUREPOD_BE =
            BLOCK_ENTITIES.register("unripestructurepod_be", () -> BlockEntityType.Builder.of(UnripeStructurePodBlockEntity::new, ModBlocks.UNRIPESTRUCTUREPOD.get()).build(null));
    public static final Supplier<BlockEntityType<WaterSourceGemBlockEntity>> WATERSOURCEGEM_BE =
            BLOCK_ENTITIES.register("watersourcegem_be", () -> BlockEntityType.Builder.of(WaterSourceGemBlockEntity::new, ModBlocks.WATERSOURCEGEM.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
