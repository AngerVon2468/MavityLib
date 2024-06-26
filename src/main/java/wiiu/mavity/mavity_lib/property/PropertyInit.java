package wiiu.mavity.mavity_lib.property;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;

import wiiu.mavity.mavity_lib.MavityLib;

public class PropertyInit {

    public static FabricItemSettings GT = new FabricItemSettings().maxCount(64);

    public static FabricItemSettings GTOI = new FabricItemSettings().maxCount(1);

    public static FabricItemSettings GTOIU = new FabricItemSettings().maxDamage(0).maxCount(1);

    public static void registerPropertyInit() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            MavityLib.LOGGER.info(MavityLib.NAME + " has registered its properties.");
        }
    }
}