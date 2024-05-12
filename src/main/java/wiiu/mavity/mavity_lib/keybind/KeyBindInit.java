package wiiu.mavity.mavity_lib.keybind;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;

import org.lwjgl.glfw.GLFW;

import wiiu.mavity.mavity_lib.MavityLib;

public class KeyBindInit {

    // Categories (Translation keys)
    public static final String CATEGORY_MAVITY_LIB = "key.category.mavity_lib.mavity_lib";

    // Keybinds (Translation keys)
    public static final String DEBUG = "key.mavity_lib.debug";

    // Keybinds
    public static KeyBinding debugKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(debugKey.wasPressed()) {
                if (FabricLoader.getInstance().isDevelopmentEnvironment() == true) {
                    assert client.player != null;
                    client.player.sendMessage(Text.literal("Debug keybind pressed by " + client.player.getEntityName()));
                }
            }
        });
    }

    public static void registerKeyBindInit() {
        debugKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                DEBUG,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                CATEGORY_MAVITY_LIB
        ));
        registerKeyInputs();
        MavityLib.LOGGER.info(MavityLib.NAME + " has registered its keybinds.");
    }
}