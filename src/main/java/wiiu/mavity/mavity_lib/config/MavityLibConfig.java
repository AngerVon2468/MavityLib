package wiiu.mavity.mavity_lib.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class MavityLibConfig extends MidnightConfig {

    @Comment(category = "settings", centered = true) public static Comment comment_1;

    @Entry(category = "settings") public static boolean showTooltips = true;

    @Entry(category = "settings") public static WiiU wiiu = WiiU.WiiU;
    public enum WiiU {
        WiiU,
        UWii;
    }

    @Entry(category = "settings") public static String trollMavity = "words";
}