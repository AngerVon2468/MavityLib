package wiiu.mavity.mavity_lib;

import net.fabricmc.api.ClientModInitializer;

import wiiu.mavity.mavity_lib.cosmeticstuff.util.CosmeticUtil;

public class MavityLibClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MavityLib.LOGGER.info(MavityLib.NAME + " has registered its main client class.");
        CosmeticUtil.REGISTERMEEEEEEEEEEEEEEEE();
    }
}