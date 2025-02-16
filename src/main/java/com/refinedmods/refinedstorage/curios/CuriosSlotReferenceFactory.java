package com.refinedmods.refinedstorage.curios;

import com.refinedmods.refinedstorage.common.api.support.slotreference.SlotReference;
import com.refinedmods.refinedstorage.common.api.support.slotreference.SlotReferenceFactory;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

class CuriosSlotReferenceFactory implements SlotReferenceFactory {
    static final SlotReferenceFactory INSTANCE = new CuriosSlotReferenceFactory();
    private static final StreamCodec<RegistryFriendlyByteBuf, CuriosSlotReference> STREAM_CODEC = StreamCodec.composite(
        ByteBufCodecs.STRING_UTF8, CuriosSlotReference::identifier,
        ByteBufCodecs.INT, CuriosSlotReference::index,
        CuriosSlotReference::new
    );

    private CuriosSlotReferenceFactory() {
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public StreamCodec<RegistryFriendlyByteBuf, SlotReference> getStreamCodec() {
        return (StreamCodec) STREAM_CODEC;
    }
}
