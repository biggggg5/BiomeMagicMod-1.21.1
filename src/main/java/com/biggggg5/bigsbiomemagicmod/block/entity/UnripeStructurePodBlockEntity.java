package com.biggggg5.bigsbiomemagicmod.block.entity;

import com.biggggg5.bigsbiomemagicmod.block.ModBlocks;
import com.biggggg5.bigsbiomemagicmod.recipe.ModRecipes;
import com.biggggg5.bigsbiomemagicmod.recipe.UnripeStructurePodRecipe;
import com.biggggg5.bigsbiomemagicmod.recipe.UnripeStructurePodRecipeInput;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Optional;

public class UnripeStructurePodBlockEntity extends BlockEntity {
    public final ItemStackHandler inventory = new ItemStackHandler(2) {
        @Override
        protected int getStackLimit(int slot, @NotNull ItemStack stack) {
            return 16;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null && !level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
            return super.insertItem(slot, stack, simulate);
        }

    };

    public UnripeStructurePodBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.UNRIPESTRUCTUREPOD_BE.get(), pos, blockState);
    }



    public boolean tryCraft() {

        UnripeStructurePodRecipeInput recipeInput = new UnripeStructurePodRecipeInput(inventory);

        RecipeManager recipeManager = level.getRecipeManager();
        Optional<RecipeHolder<UnripeStructurePodRecipe>> recipeHolder =
                recipeManager.getRecipeFor(ModRecipes.UNRIPE_STRUCTURE_POD_TYPE.get(), recipeInput, level);

        if (recipeHolder.isPresent()) {
            UnripeStructurePodRecipe recipe = recipeHolder.get().value();

            inventory.setStackInSlot(0, ItemStack.EMPTY);
            inventory.setStackInSlot(1, ItemStack.EMPTY);

            ItemStack result = recipe.assemble(recipeInput, level.registryAccess());

            if (result.getItem() instanceof BlockItem blockItem) {
                Block newBlock = blockItem.getBlock();
                BlockState newState = newBlock.defaultBlockState();

                level.setBlock(worldPosition, newState, 3);
                newBlock.setPlacedBy(level, worldPosition, newState, null, result);

                if (newState.hasBlockEntity()) {
                    BlockEntity newBlockEntity = level.getBlockEntity(worldPosition);
                    if (newBlockEntity != null) {
                        newBlockEntity.setChanged();
                        level.sendBlockUpdated(worldPosition, newBlockEntity.getBlockState(), newBlockEntity.getBlockState(), 3);
                    }
                }
            }
            level.playSound(null, worldPosition, SoundEvents.CHORUS_FLOWER_GROW, SoundSource.BLOCKS, 1.0f, 1.0f);

            return true;
        }
        level.playSound(null, worldPosition, SoundEvents.CHORUS_FLOWER_DEATH, SoundSource.BLOCKS, 1.0f, 1.0f);
        BlockState particleState = ModBlocks.STRUCTUREPOD.get().defaultBlockState();
        level.setBlockAndUpdate(worldPosition, Blocks.AIR.defaultBlockState());

        double x = worldPosition.getX();
        double y = worldPosition.getY();
        double z = worldPosition.getZ();
        ((ServerLevel)level).sendParticles(new BlockParticleOption(ParticleTypes.FALLING_DUST, particleState),
                x+ 0.5, y+ 1, z+ 0.5, 20, .5, .5, .5, 0.5);

        return false;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", inventory.serializeNBT(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }
}
