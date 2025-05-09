package dev.slmpc.testclient.module.impl.render;

import dev.slmpc.testclient.module.AbstractModule;
import dev.slmpc.testclient.module.Category;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

public class RenderTest extends AbstractModule {

    private static RenderTest INSTANCE = null;

    public static RenderTest getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RenderTest();
        }
        return INSTANCE;
    }

    @SubscribeEvent
    public void onRender2D(RenderGuiOverlayEvent event) {
        GuiGraphics guiGraphics = event.getGuiGraphics();
        guiGraphics.pose().pushPose();
        guiGraphics.pose().scale(2.0f, 2.0f, 1.0f);

        guiGraphics.drawString(mc.font, "RenderTest", 10,
                10, 0xFFFFFFFF, true);

        guiGraphics.pose().popPose();
    }

    private RenderTest() {
        super("RenderTest", Category.RENDER, GLFW.GLFW_KEY_U, true);
    }

}
