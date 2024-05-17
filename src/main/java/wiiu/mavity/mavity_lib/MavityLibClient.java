package wiiu.mavity.mavity_lib;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class MavityLibClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment() == true) {
            MavityLib.LOGGER.info(MavityLib.NAME + " has registered its main client class.");
        }
    }
}