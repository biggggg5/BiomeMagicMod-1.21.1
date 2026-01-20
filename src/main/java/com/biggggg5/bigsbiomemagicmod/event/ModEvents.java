package com.biggggg5.bigsbiomemagicmod.event;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import com.biggggg5.bigsbiomemagicmod.block.entity.ModBlockEntities;
import com.biggggg5.bigsbiomemagicmod.block.entity.WaterSourceGemBlockEntity;
import com.biggggg5.bigsbiomemagicmod.item.ModItems;
import com.biggggg5.bigsbiomemagicmod.potion.ModPotions;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = BigsBiomeMagicMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, ModItems.BIOMEGOOP.get(), ModPotions.BIOME_VISION_POTION);
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, ModBlockEntities.WATERSOURCEGEM_BE.get(), WaterSourceGemBlockEntity::getFluidHandler);
    }
}
