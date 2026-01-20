package com.biggggg5.bigsbiomemagicmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class StructurePodBlockEntity extends BlockEntity {

    private ResourceLocation structureLocation;

    public StructurePodBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.STRUCTUREPOD_BE.get(), pos, blockState);
    }

    public ResourceLocation setResource(ResourceLocation rl) {
        this.structureLocation = rl;
        setChanged();
        return rl;
    }

    public ResourceLocation getResource() {
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

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);
        if (structureLocation != null) {
            tag.putString("Structure", structureLocation.toString());
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);
        if (tag.contains("Structure", CompoundTag.TAG_STRING)) {
            structureLocation = ResourceLocation.parse(tag.getString("Structure"));
        }
    }

    @Override
    public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider lookupProvider) {
        super.handleUpdateTag(tag, lookupProvider);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag, pRegistries);
        return tag;
    }
}
