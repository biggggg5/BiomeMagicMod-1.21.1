package com.biggggg5.bigsbiomemagicmod.item;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import com.biggggg5.bigsbiomemagicmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BigsBiomeMagicMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BIOME_MAGIC_ITEMS = CREATIVE_MODE_TAB.register("biome_magic_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BIOMEGOOP.get()))
                    .title(Component.translatable("creativetab.bigsbiomemagicmod.biome_magic_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BIOMEGOOP);
                        output.accept(ModItems.BIOMEGOGGLES);
                        output.accept(ModItems.GLASSORB);
                        output.accept(ModItems.UNATTUNEDBIOMECORE);
                        output.accept(ModItems.ENHANCEDBIOMECORE);
                        output.accept(ModItems.STRUCTURESEEDS);
                        output.accept(ModItems.STAFFOFSECRETPOWER);
                        output.accept(ModItems.COPPERSTAFFOFSECRETPOWER);
                        output.accept(ModItems.IRONSTAFFOFSECRETPOWER);
                        output.accept(ModItems.GOLDSTAFFOFSECRETPOWER);
                        output.accept(ModItems.NETHERITESTAFFOFSECRETPOWER);
                        output.accept(ModBlocks.WATERSOURCEGEM);
                        output.accept(ModBlocks.STRUCTUREPOD);
                        output.accept(ModBlocks.BIOMECHANNELER);

                    })


                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
