package com.refinedmods.refinedstorage.curios;

import com.refinedmods.refinedstorage.common.api.support.slotreference.SlotReference;
import com.refinedmods.refinedstorage.common.api.support.slotreference.SlotReferenceFactory;

import java.util.Optional;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

record CuriosSlotReference(String identifier, int index) implements SlotReference {
    @Override
    public boolean isDisabledSlot(final int playerSlotIndex) {
        return false;
    }

    @Override
    public Optional<ItemStack> resolve(final Player player) {
        return CuriosApi.getCuriosInventory(player)
            .flatMap(curiosInventory -> curiosInventory.findCurio(identifier, index))
            .map(SlotResult::stack);
    }

    @Override
    public SlotReferenceFactory getFactory() {
        return CuriosSlotReferenceFactory.INSTANCE;
    }
}
