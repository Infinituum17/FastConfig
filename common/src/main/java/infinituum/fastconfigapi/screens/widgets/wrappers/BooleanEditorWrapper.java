package infinituum.fastconfigapi.screens.widgets.wrappers;

import infinituum.fastconfigapi.screens.utils.InputWidgetWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.network.chat.Component;

public final class BooleanEditorWrapper extends InputWidgetWrapper<Boolean> {
    private final CycleButton<Boolean> button;

    public BooleanEditorWrapper(Font font, int i, int j, int k, int l, Component component, Boolean initValue) {
        this.button = CycleButton.<Boolean>builder(value -> Component.literal(value ? "True" : "False"))
                .withInitialValue(initValue)
                .displayOnlyValue()
                .withValues(true, false)
                .create(i, j, k, l, component);
    }

    @Override
    public boolean keyPressed(int i, int j, int k) {
        return this.button.keyPressed(i, j, k);
    }

    @Override
    public boolean keyReleased(int i, int j, int k) {
        return this.button.keyReleased(i, j, k);
    }

    @Override
    public boolean charTyped(char c, int i) {
        return this.button.charTyped(c, i);
    }

    @Override
    public void setFocused(boolean bl) {
        this.button.setFocused(bl);
    }

    @Override
    public boolean isVisible() {
        return this.button.visible;
    }

    @Override
    public void setVisible(boolean b) {
        this.button.visible = b;
    }

    @Override
    public void setPosition(int i, int j) {
        this.button.setPosition(i, j);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        this.button.render(guiGraphics, i, j, f);
    }

    @Override
    public Boolean get() {
        return this.button.getValue();
    }

    @Override
    public void onClick(double d, double e) {
        this.button.playDownSound(Minecraft.getInstance().getSoundManager());
        this.button.onClick(d, e);
    }

    @Override
    public int requiredHeight() {
        int buttonHeight = this.button.getHeight();
        int borderSize = 2;

        return borderSize + buttonHeight;
    }
}
