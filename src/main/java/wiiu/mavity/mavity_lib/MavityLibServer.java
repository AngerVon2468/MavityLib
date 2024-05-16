package wiiu.mavity.mavity_lib;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class MavityLibServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment() == true) {
            MavityLib.LOGGER.info(MavityLib.NAME + " has registered its main server class.");
        }
    }
}