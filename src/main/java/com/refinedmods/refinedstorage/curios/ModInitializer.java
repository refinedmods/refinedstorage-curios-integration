package com.refinedmods.refinedstorage.curios;

import com.refinedmods.refinedstorage.common.api.RefinedStorageApi;

import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(ModInitializer.ID)
public final class ModInitializer {
    public static final String ID = "refinedstorage_curios_integration";

    public ModInitializer(final IEventBus eventBus) {
        eventBus.addListener(ModInitializer::onCommonSetup);
    }

    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent e) {
        RefinedStorageApi.INSTANCE.getPlayerSlotReferenceFactories().register(
            Identifier.fromNamespaceAndPath(ID, "curios"),
            CuriosPlayerSlotReference.STREAM_CODEC
        );
        RefinedStorageApi.INSTANCE.addPlayerSlotReferenceProvider(new CuriosPlayerSlotReferenceProvider());
    }
}
