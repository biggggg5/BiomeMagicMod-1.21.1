package com.biggggg5.bigsbiomemagicmod.event;

import com.biggggg5.bigsbiomemagicmod.BigsBiomeMagicMod;
import com.biggggg5.bigsbiomemagicmod.block.entity.ModBlockEntities;
import com.biggggg5.bigsbiomemagicmod.block.entity.WaterSourceGemBlockEntity;
import com.biggggg5.bigsbiomemagicmod.dataattachment.ModData;
import com.biggggg5.bigsbiomemagicmod.entity.ModEntities;
import com.biggggg5.bigsbiomemagicmod.item.ModItems;
import com.biggggg5.bigsbiomemagicmod.potion.ModPotions;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber(modid = BigsBiomeMagicMod.MOD_ID)
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


    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        EntityRenderers.register(ModEntities.GLASSORB.get(), ThrownItemRenderer::new);

        event.enqueueWork(() -> {
            ItemProperties.register(ModItems.ALTIMIRROR.get(),
                    ResourceLocation.fromNamespaceAndPath(BigsBiomeMagicMod.MOD_ID, "open"),
                    (stack, level, entity, seed) -> {
                        if (entity == null) return 0.0f;
                        return (entity.getMainHandItem() == stack || entity.getOffhandItem() == stack)
                                ? 1.0f : 0.0f;
                    }
            );
        });

    }

    @SubscribeEvent
    public static void livingFall(LivingDamageEvent.Pre event) {
        if(event.getEntity() instanceof Player player) {
            if(!player.isCreative() && event.getSource().is(DamageTypes.FALL) &&(player.getMainHandItem().getItem() == ModItems.ALTIMIRROR.get() || player.getOffhandItem().getItem() == ModItems.ALTIMIRROR.get() )) {
                event.setNewDamage(0);
                player.playSound(SoundEvents.GLASS_BREAK, 2.0f, 1f);
                if (player.getMainHandItem().getItem() == ModItems.ALTIMIRROR.get()) {
                    player.getMainHandItem().shrink(1);}
                else if (player.getOffhandItem().getItem() == ModItems.ALTIMIRROR.get()) {
                        player.getOffhandItem().shrink(1);
                    }
                }
            }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        event.getEntity().setData(
                ModData.FLUTE_COOLDOWNS,
                event.getOriginal().getData(ModData.FLUTE_COOLDOWNS));
    }

}
