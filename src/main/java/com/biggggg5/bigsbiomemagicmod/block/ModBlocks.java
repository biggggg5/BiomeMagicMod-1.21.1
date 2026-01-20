package com.biggggg5.bigsbiomemagicmod.block;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import com.biggggg5.bigsbiomemagicmod.block.custom.BiomeChannelerBlock;
import com.biggggg5.bigsbiomemagicmod.block.custom.StructurePodBlock;
import com.biggggg5.bigsbiomemagicmod.block.custom.UnripeStructurePodBlock;
import com.biggggg5.bigsbiomemagicmod.block.custom.WaterSourceGemBlock;
import com.biggggg5.bigsbiomemagicmod.item.ModItems;
import com.biggggg5.bigsbiomemagicmod.item.custom.StructurePodItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Objects;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(BigsBiomeMagicMod.MOD_ID);

    public static final DeferredBlock<Block> WATERSOURCEGEM = registerBlock("watersourcegem",
            () -> new WaterSourceGemBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> STRUCTUREPOD = registerBlock("structurepod",
            () -> new StructurePodBlock(BlockBehaviour.Properties.of()
                    .strength(3f).noLootTable().sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> UNRIPESTRUCTUREPOD = registerBlock("unripestructurepod",
            () -> new UnripeStructurePodBlock(BlockBehaviour.Properties.of().noOcclusion()
                    .strength(3f).noLootTable().sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BIOMECHANNELER = registerBlock("biomechanneler",
            () -> new BiomeChannelerBlock(BlockBehaviour.Properties.of().noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        if (Objects.equals(name, "structurepod")) {
            ModItems.ITEMS.register(name, () -> new StructurePodItem(block.get(), new Item.Properties()));

        } else ModItems.ITEMS.register(name, () ->new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
