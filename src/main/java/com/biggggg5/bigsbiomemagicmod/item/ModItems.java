package com.biggggg5.bigsbiomemagicmod.item;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import com.biggggg5.bigsbiomemagicmod.item.custom.BiomeCoreItem;
import com.biggggg5.bigsbiomemagicmod.item.custom.BiomeGogglesItem;
import com.biggggg5.bigsbiomemagicmod.item.custom.StructureSeedItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BigsBiomeMagicMod.MOD_ID);

    public static final DeferredItem <Item> BIOMEGOOP = ITEMS.register("biomegoop",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> GLASSORB = ITEMS.register("glassorb",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> COPPERSTAFFOFSECRETPOWER = ITEMS.register("copperstaffofsecretpower",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> GOLDSTAFFOFSECRETPOWER = ITEMS.register("goldstaffofsecretpower",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> IRONSTAFFOFSECRETPOWER = ITEMS.register("ironstaffofsecretpower",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> NETHERITESTAFFOFSECRETPOWER = ITEMS.register("netheritestaffofsecretpower",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> STAFFOFSECRETPOWER = ITEMS.register("staffofsecretpower",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> STRUCTURESEEDS = ITEMS.register("structureseeds",
            () -> new StructureSeedItem(new Item.Properties()));
    public static final DeferredItem <Item> UNATTUNEDBIOMECORE = ITEMS.register("unattunedbiomecore",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> BIOMECORE = ITEMS.register("biomecore",
            () -> new BiomeCoreItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem <BiomeGogglesItem> BIOMEGOGGLES = ITEMS.register("biomegoggles",
            () -> new BiomeGogglesItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
