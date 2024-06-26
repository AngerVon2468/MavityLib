package wiiu.mavity.mavity_lib;

import eu.midnightdust.lib.config.MidnightConfig;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import wiiu.mavity.mavity_lib.block.BlockRegistry;
import wiiu.mavity.mavity_lib.command.CommandInit;
import wiiu.mavity.mavity_lib.config.MavityLibConfig;
import wiiu.mavity.mavity_lib.credits.MavityLibMenuCredits;
import wiiu.mavity.mavity_lib.item.ItemRegistry;
import wiiu.mavity.mavity_lib.property.PropertyInit;
import wiiu.mavity.mavity_lib.tags.TagInit;
import wiiu.mavity.mavity_lib.util.OSInfo;

import org.slf4j.*;

import static wiiu.mavity.mavity_lib.util.OSInfo.*;

public class MavityLib implements ModInitializer {

	public static final String MOD_ID = "mavity_lib";

	public static final String NAME = "Mavity Lib";

    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {

		// Initializing classes
		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			MavityLib.LOGGER.info(MavityLib.NAME + " has registered its main class.");
		}
		MavityLibMenuCredits.registerMavityLibMenuCredits();
		ItemRegistry.registerItemRegistry();
		BlockRegistry.registerBlockRegistry();
		TagInit.registerTagInit();
		PropertyInit.registerPropertyInit();

		// Commands
		CommandInit.wiiuCommand();
		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			MavityLib.LOGGER.info(MavityLib.NAME + " has registered its commands.");
		}

		// Operating System Utils
		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			MavityLib.LOGGER.info(MavityLib.NAME + " has started up on " + System.getProperty("os.name"));
		}
		if (OSInfo.get() == WINDOWS && FabricLoader.getInstance().isDevelopmentEnvironment()) {
			MavityLib.LOGGER.info("Please check that the logger message above this says Windows.");
		}
		if (OSInfo.get() == LINUX && FabricLoader.getInstance().isDevelopmentEnvironment()) {
			MavityLib.LOGGER.info("Please check that the logger message above this says Linux.");
		}
		if (OSInfo.get() == MAC && FabricLoader.getInstance().isDevelopmentEnvironment()) {
			MavityLib.LOGGER.info("Please check that the logger message above this says Mac.");
		}

		// Anti-Optifine Utils.
		if (FabricLoader.getInstance().isModLoaded("optifabric")) {
			throw new RuntimeException("Optifabric is bad. Please use alternatives, such as Embeddium for performance, and Iris for shaders.");
		}
		if (FabricLoader.getInstance().isModLoaded("optifine")) {
			throw new RuntimeException("Optifine is bad. Please use alternatives, such as Embeddium for performance, and Iris for shaders.");
		}

		// Development Environment Utils
		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			MavityLib.LOGGER.info(MavityLib.NAME + " has started up in a development environment.");
		} else if (!FabricLoader.getInstance().isDevelopmentEnvironment()) {
			MavityLib.LOGGER.info(MavityLib.NAME + " has started up in a non-development environment.");
		}

		// Config
		MidnightConfig.init(MavityLib.MOD_ID, MavityLibConfig.class);

		// Kotlin
		MavityLibButInKotlin.registerMavityLibButInKotlin();
	}
}