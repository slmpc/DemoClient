package dev.slmpc.testclient;

import com.mojang.logging.LogUtils;
import dev.slmpc.testclient.managers.Managers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Client.MODID)
public class Client
{
    public static final String MODID = "test_client";

    private static final Logger LOGGER = LogUtils.getLogger();

    public static IEventBus EVENT_BUS;

    public Client(FMLJavaModLoadingContext context)
    {
        EVENT_BUS = context.getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            Managers.init();

            LOGGER.info("Test Client has been loaded!");
        }
    }
}
