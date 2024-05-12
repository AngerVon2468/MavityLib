package wiiu.mavity.mavity_lib.util;

import org.jetbrains.annotations.Nullable;

import java.util.Locale;

/**
 * Totally didn't steal this from Mojang.
 */
public enum OSInfo {
    LINUX("linux"),
    WINDOWS("windows"),
    MAC("mac"),
    UNSUPPORTED(null),
    ;

    @Nullable
    private final String detectWith;

    OSInfo(@Nullable final String detectWith) {
        this.detectWith = detectWith;
    }

    public static OSInfo get() {
        final String test = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        for (OSInfo value : values()) {
            if (value.detectWith == null) {
                continue;
            }

            if (test.contains(value.detectWith)) {
                return value;
            }
        }
        return UNSUPPORTED;
    }
}