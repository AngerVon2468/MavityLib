package wiiu.mavity.mavity_lib.property;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import wiiu.mavity.mavity_lib.MavityLib;

public class PropertyInit {
    public static FabricItemSettings GT = new FabricItemSettings().maxCount(64);
    public static FabricItemSettings GTOI = new FabricItemSettings().maxDamage(0);
    public static void registerPropertyInit() {
        MavityLib.LOGGER.info(MavityLib.NAME + " has registered its properties.");
    }
}
