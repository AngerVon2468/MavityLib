package wiiu.mavity.mavity_lib.property;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import wiiu.mavity.mavity_lib.MavityLib;

public class PropertyInit {
    public static final FabricItemSettings GT = new FabricItemSettings().maxCount(64);
    public static final FabricItemSettings GTOI = new FabricItemSettings().maxDamage(0);
    public static void registerPropertyInit() {
        MavityLib.LOGGER.info(MavityLib.MOD_ID + " has registered its' properties.");
    }
}
