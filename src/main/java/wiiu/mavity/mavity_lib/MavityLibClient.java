package wiiu.mavity.mavity_lib;

import net.fabricmc.api.ClientModInitializer;

public class MavityLibClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MavityLib.LOGGER.info(MavityLib.NAME + "has registered its main client class.");
    }
}