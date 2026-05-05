package com.biggggg5.bigsbiomemagicmod.item.custom;

import com.biggggg5.bigsbiomemagicmod.component.ModDataComponents;
import com.biggggg5.bigsbiomemagicmod.dataattachment.ModData;
import com.biggggg5.bigsbiomemagicmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Map;

public class FluteItem extends Item {
    private final boolean flimsy;
    public FluteItem(Properties properties, boolean flimsy) {
        super(properties);
        this.flimsy = flimsy;
    }

    private String getComponentKey(ItemStack stack) {
        return stack.getComponents().toString();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        if (!level.isClientSide){

            if(stack.has(ModDataComponents.SUMMONEDITEM)){
                String key = getComponentKey(stack);
                Map<String, Long> cooldowns = player.getData(ModData.FLUTE_COOLDOWNS);
                long currentDay = level.getDayTime() / 24000L;
                cooldowns.entrySet().removeIf(entry -> entry.getValue() < currentDay);

                if (cooldowns.getOrDefault(key, -1L) < currentDay) {

                    cooldowns.put(key, currentDay);

                    ResourceLocation summonedrl = stack.get(ModDataComponents.SUMMONEDITEM);
                    Item summoneditem = level.registryAccess().registryOrThrow(Registries.ITEM).get(summonedrl);
                    ItemStack summonedstack = new ItemStack(summoneditem);
                    Direction looking = player.getDirection();
                    Direction flightpath = looking.getClockWise();
                    Vec3 velocity = Vec3.atLowerCornerOf(flightpath.getNormal()).scale(0.3);
                    BlockPos summonplace = player.blockPosition().relative(looking, 3);
                    ItemEntity summonedentity = new ItemEntity(level, summonplace.getX()+.5, summonplace.getY()+2, summonplace.getZ()+.5, summonedstack);
                    BlockPos flightpos = summonplace.relative(flightpath.getCounterClockWise(), 3);

                    ((ServerLevel) level).sendParticles(ParticleTypes.POOF, flightpos.getX()+.5, flightpos.getY()+2, flightpos.getZ()+.5,
                        5, velocity.x, velocity.y, velocity.z, .2);

                    level.addFreshEntity(summonedentity);

                }
                else{
                    //tie this to lang file
                    player.sendSystemMessage(Component.literal("The spirits are tired. Try again tomorrow."));
                }
            }

        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                ModSounds.PLANTFLUTE_PLAY.get(), SoundSource.NEUTRAL, 1.5f, 1.0f);

        if (flimsy && !player.isCreative())
            stack.shrink(1);

        return InteractionResultHolder.success(stack);
        }
    return InteractionResultHolder.fail(stack);
    }
}
