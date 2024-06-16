package com.refinedmods.refinedstorage.curios;

import com.refinedmods.refinedstorage2.platform.api.PlatformApi;
import com.refinedmods.refinedstorage2.platform.common.util.IdentifierUtil;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(ModInitializer.ID)
public final class ModInitializer {
    public static final String ID = "refinedstorage_curios_integration";

    private static final Logger LOGGER = LoggerFactory.getLogger(ModInitializer.class);

    public ModInitializer(final IEventBus eventBus) {
        eventBus.addListener(ModInitializer::onCommonSetup);
    }

    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent e) {
        PlatformApi.INSTANCE.getSlotReferenceFactoryRegistry().register(
            new ResourceLocation(ID, "curios"),
            CuriosSlotReferenceFactory.INSTANCE
        );
        PlatformApi.INSTANCE.addSlotReferenceProvider(new CuriosSlotReferenceProvider());
        LOGGER.info(
            "Refined Storage - Curios Integration has loaded. RS2 ModId: {}",
            IdentifierUtil.MOD_ID
        );
    }
}
