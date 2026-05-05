package com.biggggg5.bigsbiomemagicmod.item;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import com.biggggg5.bigsbiomemagicmod.item.custom.*;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BigsBiomeMagicMod.MOD_ID);

    public static final DeferredItem <Item> BIOMEGOOP = ITEMS.register("biomegoop",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> BATLEATHER = ITEMS.register("batleather",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> GLASSORB = ITEMS.register("glassorb",
            () -> new GlassOrbItem(new Item.Properties()));
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
    public static final DeferredItem <Item> MONSTERTRACKDUST = ITEMS.register("monstertrackdust",
            () -> new MonsterTrackDustItem(new Item.Properties()));
    public static final DeferredItem <Item> PLANTFLUTE = ITEMS.register("plantflute",
            () -> new FluteItem(new Item.Properties(), true));
    public static final DeferredItem <Item> STURDYPLANTFLUTE = ITEMS.register("sturdyplantflute",
            () -> new FluteItem(new Item.Properties(), false));
    public static final DeferredItem <Item> ALTIMIRROR = ITEMS.register("altimirror",
            () -> new AltimirrorItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem <Item> BIOMECORE = ITEMS.register("biomecore",
            () -> new BiomeCoreItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem <BiomeGogglesItem> BIOMEGOGGLES = ITEMS.register("biomegoggles",
            () -> new BiomeGogglesItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem <Item> WHITEPLANTFLUTETUBE = ITEMS.register("whiteplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> WHITESTURDYPLANTFLUTETUBE = ITEMS.register("whitesturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> LIGHTGRAYPLANTFLUTETUBE = ITEMS.register("lightgrayplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> LIGHTGRAYSTURDYPLANTFLUTETUBE = ITEMS.register("lightgraysturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> GRAYPLANTFLUTETUBE = ITEMS.register("grayplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> GRAYSTURDYPLANTFLUTETUBE = ITEMS.register("graysturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> BLACKPLANTFLUTETUBE = ITEMS.register("blackplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> BLACKSTURDYPLANTFLUTETUBE = ITEMS.register("blacksturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> BROWNPLANTFLUTETUBE = ITEMS.register("brownplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> BROWNSTURDYPLANTFLUTETUBE = ITEMS.register("brownsturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> REDPLANTFLUTETUBE = ITEMS.register("redplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> REDSTURDYPLANTFLUTETUBE = ITEMS.register("redsturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> ORANGEPLANTFLUTETUBE = ITEMS.register("orangeplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> ORANGESTURDYPLANTFLUTETUBE = ITEMS.register("orangesturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> YELLOWPLANTFLUTETUBE = ITEMS.register("yellowplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> YELLOWSTURDYPLANTFLUTETUBE = ITEMS.register("yellowsturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> LIMEPLANTFLUTETUBE = ITEMS.register("limeplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> LIMESTURDYPLANTFLUTETUBE = ITEMS.register("limesturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> GREENPLANTFLUTETUBE = ITEMS.register("greenplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> GREENSTURDYPLANTFLUTETUBE = ITEMS.register("greensturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> CYANPLANTFLUTETUBE = ITEMS.register("cyanplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> CYANSTURDYPLANTFLUTETUBE = ITEMS.register("cyansturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> LIGHTBLUEPLANTFLUTETUBE = ITEMS.register("lightblueplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> LIGHTBLUESTURDYPLANTFLUTETUBE = ITEMS.register("lightbluesturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> BLUEPLANTFLUTETUBE = ITEMS.register("blueplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> BLUESTURDTPLANTFLUTETUBE = ITEMS.register("bluesturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> PURPLEPLANTFLUTETUBE = ITEMS.register("purpleplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> PURPLESTURDYPLANTFLUTETUBE = ITEMS.register("purplesturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> MAGENTAPLANTFLUTETUBE = ITEMS.register("magentaplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> MAGENTASTURDYPLANTFLUTETUBE = ITEMS.register("magentasturdyplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> PINKPLANTFLUTETUBE = ITEMS.register("pinkplantflutetube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem <Item> PINKSTURDYPLANTFLUTETUBE = ITEMS.register("pinksturdyplantflutetube",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
