package dev.slmpc.testclient.manager;

import dev.slmpc.testclient.manager.impl.ModuleManager;

public class Managers {

    public static ModuleManager MODULE;

    public static void init() {
        MODULE = (ModuleManager) new ModuleManager().init();
    }

}
