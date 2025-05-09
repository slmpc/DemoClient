package dev.slmpc.testclient.manager.impl;

import dev.slmpc.testclient.manager.AbstractManager;
import dev.slmpc.testclient.module.AbstractModule;
import dev.slmpc.testclient.module.impl.render.RenderTest;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;

public class ModuleManager extends AbstractManager {

    public ArrayList<AbstractModule> modules = new ArrayList<>();

    @Override
    public AbstractManager init() {
        initModules();

        MinecraftForge.EVENT_BUS.register(this);
        return this;
    }

    private void initModules() {
        // Render
        registerModule(RenderTest.getInstance());
    }

    private void registerModule(AbstractModule module) {
        modules.add(module);
        if (module.defaultEnable) {
            module.enable();
        }
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.Key event) {
        modules.forEach((module) -> {
            if (event.getAction() != GLFW.GLFW_PRESS) return;
            if (module.defaultKeybind == 0) return;

            if (module.defaultKeybind == event.getKey()) {
                module.toggle();
            }
        });
    }

}
