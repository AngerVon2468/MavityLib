package wiiu.mavity.mavity_lib.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandInit {
    public static void wiiuCommand() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("wiiu")
                .executes(context -> {
                    if (FabricLoader.getInstance().isDevelopmentEnvironment() == true) {
                        context.getSource().sendFeedback(() -> Text.literal("(" + context.getSource().getName() + "): " + "WiiU :D"), false);
                        return 1;
                    }
                    return 1;
                })));
    }
}