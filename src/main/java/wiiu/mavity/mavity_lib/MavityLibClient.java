package wiiu.mavity.mavity_lib;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import wiiu.mavity.mavity_lib.event.EventCallbacks;
import wiiu.mavity.mavity_lib.keybind.KeyBindInit;

public class MavityLibClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            MavityLib.LOGGER.info(MavityLib.NAME + " has registered its main client class.");
        }
        KeyBindInit.registerKeyBindInit();
        EventCallbacks.registerEventCallbacksClient();
    }
}