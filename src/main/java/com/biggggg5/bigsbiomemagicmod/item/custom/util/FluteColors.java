package com.biggggg5.bigsbiomemagicmod.item.custom.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.DyeColor;

public record FluteColors(DyeColor color0, DyeColor color1, DyeColor color2, DyeColor color3) {

    public static final Codec<FluteColors> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            DyeColor.CODEC.fieldOf("color0").forGetter(FluteColors::color0),
            DyeColor.CODEC.fieldOf("color1").forGetter(FluteColors::color1),
            DyeColor.CODEC.fieldOf("color2").forGetter(FluteColors::color2),
            DyeColor.CODEC.fieldOf("color3").forGetter(FluteColors::color3)
    ).apply(inst, FluteColors::new));

    public static final StreamCodec<ByteBuf, FluteColors> STREAM_CODEC = StreamCodec.composite(
            DyeColor.STREAM_CODEC, FluteColors::color0,
            DyeColor.STREAM_CODEC, FluteColors::color1,
            DyeColor.STREAM_CODEC, FluteColors::color2,
            DyeColor.STREAM_CODEC, FluteColors::color3,
            FluteColors::new
    );
}
