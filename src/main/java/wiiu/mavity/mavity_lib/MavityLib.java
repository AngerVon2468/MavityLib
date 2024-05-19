package wiiu.mavity.mavity_lib;

import eu.midnightdust.lib.config.MidnightConfig;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.client.MinecraftClient;

import wiiu.mavity.mavity_lib.block.BlockRegistry;
import wiiu.mavity.mavity_lib.command.CommandInit;
import wiiu.mavity.mavity_lib.config.MavityLibConfig;
import wiiu.mavity.mavity_lib.credits.MavityLibMenuCredits;
import wiiu.mavity.mavity_lib.item.ItemRegistry;
import wiiu.mavity.mavity_lib.keybind.KeyBindInit;
import wiiu.mavity.mavity_lib.property.PropertyInit;
import wiiu.mavity.mavity_lib.tags.TagInit;
import wiiu.mavity.mavity_lib.util.OSInfo;
import wiiu.mavity.mavity_lib.util.event.MavityEvents;

import org.slf4j.*;

import static wiiu.mavity.mavity_lib.util.OSInfo.*;

public class MavityLib implements ModInitializer {

	public static final String MOD_ID = "mavity_lib";

	public static final String NAME = "Mavity Lib";

    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	public static final String NOTE = "Main Menu Credits translations are removed from Mavity Lib so mods that use it can override them without lang file issues.";

	@Override
	public void onInitialize() {

		// Initializing classes
		if (FabricLoader.getInstance().isDevelopmentEnvironment() == true) {
			MavityLib.LOGGER.info(MavityLib.NAME + " has registered its main class.");
		}
		MavityLibMenuCredits.registerMavityLibMenuCredits();
		ItemRegistry.registerItemRegistry();
		BlockRegistry.registerBlockRegistry();
		TagInit.registerTagInit();
		PropertyInit.registerPropertyInit();
		KeyBindInit.registerKeyBindInit();
		MavityEvents.registerMavityEvents();

		// Commands
		CommandInit.wiiuCommand();
		if (FabricLoader.getInstance().isDevelopmentEnvironment() == true) {
			MavityLib.LOGGER.info(MavityLib.NAME + " has registered its commands.");
		}

		// Operating System Utils
		if (FabricLoader.getInstance().isDevelopmentEnvironment() == true) {
			MavityLib.LOGGER.info(MavityLib.NAME + " has started up on " + System.getProperty("os.name"));
		}
		if (OSInfo.get() == WINDOWS && FabricLoader.getInstance().isDevelopmentEnvironment() == true) {
			MavityLib.LOGGER.info("Please check that the logger message above this says Windows.");
		}
		if (OSInfo.get() == LINUX && FabricLoader.getInstance().isDevelopmentEnvironment() == true) {
			MavityLib.LOGGER.info("Please check that the logger message above this says Linux.");
		}
		if (OSInfo.get() == MAC && FabricLoader.getInstance().isDevelopmentEnvironment() == true) {
			MavityLib.LOGGER.info("Please check that the logger message above this says Mac.");
		}

		// Anti-Optifine Utils.
		if (FabricLoader.getInstance().isModLoaded("optifabric")) {
			MinecraftClient.getInstance().close();
		}
		if (FabricLoader.getInstance().isModLoaded("optifine")) {
			MinecraftClient.getInstance().close();
		}

		// Development Environment Utils
		if (FabricLoader.getInstance().isDevelopmentEnvironment() == true) {
			MavityLib.LOGGER.info(MavityLib.NAME + " has started up in a development environment.");
		} else if (FabricLoader.getInstance().isDevelopmentEnvironment() == false) {
			MavityLib.LOGGER.info(MavityLib.NAME + " has started up in a non-development environment.");
		}

		// Config
		MidnightConfig.init(MavityLib.MOD_ID, MavityLibConfig.class);
	}
}