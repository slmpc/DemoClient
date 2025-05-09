package dev.slmpc.testclient.managers;

import dev.slmpc.testclient.managers.impl.ModuleManager;

public class Managers {

    public static ModuleManager MODULE;

    public static void init() {
        MODULE = (ModuleManager) new ModuleManager().init();
    }

}
