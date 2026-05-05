package com.biggggg5.bigsbiomemagicmod.block.entity;

import com.biggggg5.bigsbiomemagicmod.dataattachment.ModData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StructurePodBlockEntity extends BlockEntity {

    private ResourceLocation structureLocation;

    public StructurePodBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.STRUCTUREPOD_BE.get(), pos, blockState);
    }

    public ResourceLocation setResource(ResourceLocation rl) {
        this.structureLocation = rl;
        setData(ModData.LOC, rl);
        level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
        setChanged();
        return rl;
    }

    public ResourceLocation getResource() {
        structureLocation = getData(ModData.LOC);
        setChanged();
        return structureLocation;
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
       structureParticles((ServerLevel) level);
    }

    private void structureParticles(ServerLevel level) {

        double x = this.getBlockPos().getX();
        double y = this.getBlockPos().getY();
        double z = this.getBlockPos().getZ();
        if (structureLocation != null){
            level.sendParticles(ParticleTypes.INSTANT_EFFECT, x+ 0.5, y+ 0.5, z+ 0.5, 1, 0.5f, 0.5f, 0.5f, 0.25f);
        }
    }
}
