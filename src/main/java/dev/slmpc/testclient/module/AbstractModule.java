package dev.slmpc.testclient.module;

import dev.slmpc.testclient.util.Wrapper;
import net.minecraftforge.common.MinecraftForge;

public abstract class AbstractModule extends Wrapper {

    public String       name;
    public Category     category;
    public int          defaultKeybind;
    public boolean      defaultEnable;

    private boolean     isEnabled = false;  // Default disabled

    protected AbstractModule(String name, Category category, int defaultKeybind, boolean defaultEnable) {
        this.name = name;
        this.category = category;
        this.defaultEnable = defaultEnable;
        this.defaultKeybind = defaultKeybind;
    }

    protected AbstractModule(String name, Category category) {
        this(name, category, 0, false);
    }

    public void toggle() {
        isEnabled = !isEnabled;
        if (isEnabled) {
            MinecraftForge.EVENT_BUS.register(this);
        } else {
            MinecraftForge.EVENT_BUS.unregister(this);
        }
    }

    public void enable() {
        if (isEnabled) return;
        toggle();
    }

    public void disable() {
        if (!isEnabled) return;
        toggle();
    }

}
