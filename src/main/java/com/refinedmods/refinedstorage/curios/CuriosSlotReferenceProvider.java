package com.refinedmods.refinedstorage.curios;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.refinedmods.refinedstorage2.platform.api.support.network.bounditem.SlotReference;
import com.refinedmods.refinedstorage2.platform.api.support.network.bounditem.SlotReferenceProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import top.theillusivec4.curios.api.CuriosApi;

class CuriosSlotReferenceProvider implements SlotReferenceProvider {
    @Override
    public List<SlotReference> find(final Player player, final Set<Item> validItems) {
        return CuriosApi.getCuriosInventory(player)
            .map(curiosInventory -> curiosInventory.findCurios(ModInitializer.ID))
            .orElse(Collections.emptyList())
            .stream()
            .filter(slotResult -> validItems.contains(slotResult.stack().getItem()))
            .map(slotResult -> (SlotReference) new CuriosSlotReference(
                slotResult.slotContext().identifier(),
                slotResult.slotContext().index()
            ))
            .toList();
    }
}
