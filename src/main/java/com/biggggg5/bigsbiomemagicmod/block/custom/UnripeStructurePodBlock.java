package com.biggggg5.bigsbiomemagicmod.block.custom;

import com.biggggg5.bigsbiomemagicmod.block.entity.UnripeStructurePodBlockEntity;
import com.biggggg5.bigsbiomemagicmod.item.ModItems;
import com.biggggg5.bigsbiomemagicmod.recipe.ModRecipes;
import com.biggggg5.bigsbiomemagicmod.recipe.UnripeStructurePodRecipe;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ParticleUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UnripeStructurePodBlock extends BaseEntityBlock {
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 4);
    public static final MapCodec<UnripeStructurePodBlock> CODEC = simpleCodec(UnripeStructurePodBlock::new);

    public UnripeStructurePodBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(STAGE, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        float hardness;
        if (state.getValue(STAGE) == 0) {
            hardness = 0.0f;
        } else {
            hardness = 10f;
        }

        return player.getDigSpeed(state, pos) / hardness / 30.f;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(STAGE)) {
            case 0 -> Block.box(6, 0, 6, 10, 4, 10);
            case 1 -> Block.box(5, 0, 5, 11, 6, 11);
            case 2 -> Block.box(3, 0, 3, 13, 10, 13);
            case 3 -> Block.box(2, 0, 2, 14, 12, 14);
            case 4 -> Block.box(1, 0, 1, 15, 14, 15);
            default -> Shapes.block();
        };
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new UnripeStructurePodBlockEntity(blockPos, blockState);
    }

    @Override
    public void onBlockStateChange(LevelReader level, BlockPos pos, BlockState oldState, BlockState newState) {
        if (newState.getValue(STAGE) == 4) {
            if (level instanceof Level actualLevel && !actualLevel.isClientSide) {
                if (actualLevel.getBlockEntity(pos) instanceof UnripeStructurePodBlockEntity be) {
                    be.tryCraft();
                }
            }
        }
        super.onBlockStateChange(level, pos, oldState, newState);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (level.getBlockEntity(pos) instanceof UnripeStructurePodBlockEntity unripeStructurePodBlockEntity)
            if (unripeStructurePodBlockEntity.inventory.getStackInSlot(0).isEmpty()) {
                ItemStack seeds = new ItemStack(ModItems.STRUCTURESEEDS.get());
                ItemEntity seedEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.1, pos.getZ() + 0.5, seeds);
                if (!player.isCreative())
                    level.addFreshEntity(seedEntity);
            }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }


    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (level.getBlockEntity(pos) instanceof UnripeStructurePodBlockEntity unripeStructurePodBlockEntity) {

            ItemStack slot1Item = unripeStructurePodBlockEntity.inventory.getStackInSlot(0);
            ItemStack slot2Item = unripeStructurePodBlockEntity.inventory.getStackInSlot(1);


        if (slot1Item.getCount() < 16 && (slot1Item.isEmpty() || ItemStack.isSameItemSameComponents(slot1Item, stack))
                    && !stack.isEmpty() && isIngredientValid(0, stack, level)){
            unripeStructurePodBlockEntity.inventory.insertItem(0, stack.split(1), false);
                level.playSound(player, pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 2f);
                ParticleUtils.spawnParticleInBlock(level, pos, 6, ParticleTypes.HAPPY_VILLAGER);
                switch (unripeStructurePodBlockEntity.inventory.getStackInSlot(0).getCount()) {
                    case 1:
                        level.setBlockAndUpdate(pos, state.setValue(STAGE, 1));
                        break;
                    case 16:
                        level.setBlockAndUpdate(pos, state.setValue(STAGE, 2));
                        break;
                }

            } else if (slot1Item.getCount() == 16 && slot2Item.getCount() < 16 && (slot2Item.isEmpty() || ItemStack.isSameItemSameComponents(slot2Item, stack))
                    && !stack.isEmpty() && isIngredientValid(1, stack, level)){
                unripeStructurePodBlockEntity.inventory.insertItem(1, stack.split(1), false);
                level.playSound(player, pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 2f);
                ParticleUtils.spawnParticleInBlock(level, pos, 6, ParticleTypes.HAPPY_VILLAGER);
                switch (unripeStructurePodBlockEntity.inventory.getStackInSlot(1).getCount()) {
                    case 1:
                        level.setBlockAndUpdate(pos, state.setValue(STAGE, 3));
                        break;
                    case 16:
                        level.setBlockAndUpdate(pos, state.setValue(STAGE, 4));
                        break;
                }
            }
        }



            return ItemInteractionResult.SUCCESS;
    }

    private boolean isIngredientValid(int slot, ItemStack stack, Level level) {
        if (level == null) return true;

        RecipeManager recipeManager = level.getRecipeManager();
        List<RecipeHolder<UnripeStructurePodRecipe>> recipes = recipeManager.getAllRecipesFor(ModRecipes.UNRIPE_STRUCTURE_POD_TYPE.get());

        for (RecipeHolder<UnripeStructurePodRecipe> recipeHolder : recipes) {
            UnripeStructurePodRecipe recipe = recipeHolder.value();
            if (recipe.ingredient1().test(stack) || recipe.ingredient2().test(stack)) {
                return true;
            }
        }
        return false;
    }

}



