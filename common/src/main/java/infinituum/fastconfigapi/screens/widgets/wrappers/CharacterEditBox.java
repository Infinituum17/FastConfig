package infinituum.fastconfigapi.screens.widgets.wrappers;

import infinituum.fastconfigapi.screens.widgets.type.GuardedEditBoxEditor;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;

public final class CharacterEditBox extends GuardedEditBoxEditor<Character> {
    public CharacterEditBox(Font font, int i, int j, int k, int l, Component component, Character initValue) {
        super(font, i, j, k, l, component, CharacterEditBox::isValid, CharacterEditBox::get);

        this.editBox.setValue(initValue.toString());
    }

    private static boolean isValid(String oldValue, String newValue) {
        return oldValue.isEmpty() && newValue.length() == 1;
    }

    public static Character get(String value) {
        if (value.isEmpty()) {
            return null;
        }

        return value.charAt(0);
    }
}