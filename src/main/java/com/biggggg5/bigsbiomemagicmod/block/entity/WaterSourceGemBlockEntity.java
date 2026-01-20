package com.biggggg5.bigsbiomemagicmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class WaterSourceGemBlockEntity extends BlockEntity {

    private final InfiniteWaterFluidHandler fluidHandler = new InfiniteWaterFluidHandler();

    public WaterSourceGemBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.WATERSOURCEGEM_BE.get(), pos, blockState);
    }

    public IFluidHandler getFluidHandler(Direction side) {
        return fluidHandler;
    }

    public static class InfiniteWaterFluidHandler implements IFluidHandler {

        @Override
        public int getTanks() {
            return 1;
        }

        @Override
        public @NotNull FluidStack getFluidInTank(int tank) {
            return new FluidStack(Fluids.WATER, Integer.MAX_VALUE);
        }

        @Override
        public int getTankCapacity(int tank) {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isFluidValid(int i, FluidStack fluidStack) {
            return fluidStack.is(Fluids.WATER);
        }

        @Override
        public int fill(@NotNull FluidStack resource, @NotNull FluidAction action) {
            if (resource.getFluid() == Fluids.WATER) {
                return resource.getAmount(); // void all inputted water, ignore anything else
            }
            return 0;
        }

        @Override
        public @NotNull FluidStack drain(FluidStack resource, @NotNull FluidAction action) {
            if (resource.getFluid() == Fluids.WATER) {
                return new FluidStack(Fluids.WATER, Math.min(resource.getAmount(), Integer.MAX_VALUE));
            }
            return FluidStack.EMPTY;
        }

        @Override
        public @NotNull FluidStack drain(int maxDrain, @NotNull FluidAction action) {
            return new FluidStack(Fluids.WATER, Math.min(maxDrain,Integer.MAX_VALUE));
        }
    }
}

