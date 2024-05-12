package wiiu.mavity.mavity_lib;

import net.fabricmc.api.DedicatedServerModInitializer;

public class MavityLibServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        MavityLib.LOGGER.info(MavityLib.NAME + "has registered its main server class.");
    }
}