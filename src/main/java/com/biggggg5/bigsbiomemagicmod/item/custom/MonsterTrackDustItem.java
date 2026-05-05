package com.biggggg5.bigsbiomemagicmod.item.custom;

import com.biggggg5.bigsbiomemagicmod.particle.ModParticles;
import com.google.common.base.Suppliers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LayerLightEventListener;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.Tags;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.function.Supplier;

public class MonsterTrackDustItem extends Item {
    public MonsterTrackDustItem(Properties properties) {
        super(properties);
    }

    //Spawn checking modified from LightOverlay By shedanial

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        CollisionContext collisionContext = CollisionContext.of(player);
        ItemStack itemStack = context.getItemInHand();
        LayerLightEventListener block = level.getLightEngine().getLayerListener(LightLayer.BLOCK);
        LayerLightEventListener sky = level.getLightEngine().getLayerListener(LightLayer.SKY);

        if (!level.isClientSide) {
            for (int x = -3; x <= 3; x++) {
                for (int z = -3; z <= 3; z++) {
                    double d0 = blockpos.offset(x, 0, z).getX();
                    double d1 = blockpos.offset(x, 0, z).getY();
                    double d2 = blockpos.offset(x, 0, z).getZ();

                    BlockPos lowerChecked = new BlockPos((int) d0, (int) d1, (int) d2);
                    BlockPos upperChecked = new BlockPos((int) d0, (int) d1+1, (int) d2);
                    BlockState upperState = level.getBlockState(upperChecked);
                    BlockState lowerState = level.getBlockState(lowerChecked);
                    VoxelShape upperCollisionShape = upperState.getCollisionShape(level, upperChecked, collisionContext);


                    ((ServerLevel) level).sendParticles(ParticleTypes.GLOW_SQUID_INK, d0 + 0.5, d1 + 1.0, d2 + 0.5, 1, 0, 0, 0, 0.1);
                    level.playSound(
                            null,
                            blockpos.getX(),
                            blockpos.getY(),
                            blockpos.getZ(),
                            SoundEvents.SAND_PLACE,
                            SoundSource.NEUTRAL,
                            0.5F,
                            ((float) (1 + level.getRandom().nextFloat() * 0.3 + 0.15))
                    );
                    if (checkedParticles(upperState, lowerState, upperCollisionShape, lowerChecked, upperChecked, level, block, sky) != null) {
                        ((ServerLevel) level).sendParticles(checkedParticles(upperState, lowerState, upperCollisionShape, lowerChecked, upperChecked, level, block, sky),
                                d0 + 0.5, d1 + 1.3, d2 + 0.5, 0, 0, 0, 0, 0.1);
                    }
                }
            }
        }
        if (!player.isCreative())
            itemStack.shrink(1);
        return InteractionResult.SUCCESS; }

    private static final Supplier<EntityType<Entity>> TESTING_ENTITY_TYPE = Suppliers.memoize(() -> {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);

            return (EntityType<Entity>) unsafe.allocateInstance(EntityType.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    });


    private SimpleParticleType checkedParticles(BlockState upperState, BlockState lowerState, VoxelShape upperCollisionShape, BlockPos lowerChecked, BlockPos upperChecked, Level level, LayerLightEventListener block, LayerLightEventListener sky) {
        if (!upperState.getFluidState().isEmpty())
            return null;
        if (Block.isFaceFull(upperCollisionShape, Direction.UP))
            return null;
        if (lowerState.isAir())
            return null;
        if (upperState.isSignalSource())
            return ParticleTypes.HEART;
        if (upperCollisionShape.max(Direction.Axis.Y) > 0)
            return ParticleTypes.HEART;
        if (upperState.is(BlockTags.PREVENT_MOB_SPAWNING_INSIDE))
            return ParticleTypes.HEART;
        if (!lowerState.isValidSpawn(level, lowerChecked, TESTING_ENTITY_TYPE.get()))
            return ParticleTypes.HEART;
        if (level.getBiome(lowerChecked).is(Tags.Biomes.IS_MUSHROOM))
            return ParticleTypes.HEART;

        int blockLightLevel = block.getLightValue(upperChecked);
        int skyLightLevel = sky.getLightValue(upperChecked);
        int spawnNum = level.dimensionType().monsterSpawnBlockLightLimit();

        if (blockLightLevel > spawnNum)
            return ParticleTypes.HEART;
        if (skyLightLevel > spawnNum)
            return ModParticles.BRIGHT_TRIAL_PARTICLES.get();
        if (blockLightLevel <= spawnNum)
            return ModParticles.BRIGHT_RAID_PARTICLES.get();

        return null;
    }

}
