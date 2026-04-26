package com.refinedmods.refinedstorage.curios;

import com.refinedmods.refinedstorage.common.api.support.slotreference.PlayerSlotReference;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

record CuriosPlayerSlotReference(String identifier, int index) implements PlayerSlotReference {
    public static final StreamCodec<RegistryFriendlyByteBuf, CuriosPlayerSlotReference> STREAM_CODEC =
        StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, CuriosPlayerSlotReference::identifier,
            ByteBufCodecs.INT, CuriosPlayerSlotReference::index,
            CuriosPlayerSlotReference::new
        );

    @Override
    public boolean isDisabled(final int playerSlotIndex) {
        return false;
    }

    @Override
    public ItemStack get(final Player player) {
        return CuriosApi.getCuriosInventory(player)
            .flatMap(curiosInventory -> curiosInventory.findCurio(identifier, index))
            .map(SlotResult::stack)
            .orElse(ItemStack.EMPTY);
    }

    @Override
    public void set(final Player player, final ItemStack stack) {
        CuriosApi.getCuriosInventory(player)
            .ifPresent(inventory -> inventory.setEquippedCurio(identifier, index, stack));
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, ? extends PlayerSlotReference> getStreamCodec() {
        return STREAM_CODEC;
    }
}
