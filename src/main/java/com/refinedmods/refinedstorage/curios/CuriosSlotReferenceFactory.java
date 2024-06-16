package com.refinedmods.refinedstorage.curios;

import com.refinedmods.refinedstorage2.platform.api.support.network.bounditem.SlotReference;
import com.refinedmods.refinedstorage2.platform.api.support.network.bounditem.SlotReferenceFactory;
import net.minecraft.network.FriendlyByteBuf;

class CuriosSlotReferenceFactory implements SlotReferenceFactory {
    static final SlotReferenceFactory INSTANCE = new CuriosSlotReferenceFactory();

    private CuriosSlotReferenceFactory() {
    }

    @Override
    public SlotReference create(final FriendlyByteBuf buf) {
        return new CuriosSlotReference(buf.readUtf(), buf.readInt());
    }
}
