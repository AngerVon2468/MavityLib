package wiiu.mavity.mavity_lib;

import eu.midnightdust.lib.config.MidnightConfig;

import net.fabricmc.api.ModInitializer;

import wiiu.mavity.mavity_lib.block.BlockRegistry;
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
		MavityLib.LOGGER.info(MavityLib.NAME + " has registered its main class.");
		MavityLibMenuCredits.registerMavityLibMenuCredits();
		ItemRegistry.registerMavityLibItemRegistry();
		BlockRegistry.registerMavityLibBlocks();
		TagInit.registerTagInit();
		PropertyInit.registerPropertyInit();
		// Operating System Utils
		MavityLib.LOGGER.info(MavityLib.NAME + " has started up on " + System.getProperty("os.name"));
		if (OSInfo.get() == WINDOWS) {
			MavityLib.LOGGER.info("Please check that the logger message above this says Windows.");
		}
		if (OSInfo.get() == LINUX) {
			MavityLib.LOGGER.info("Please check that the logger message above this says Linux.");
		}
		if (OSInfo.get() == MAC) {
			MavityLib.LOGGER.info("Please check that the logger message above this says Mac.");
		}

		// Config
		MidnightConfig.init(MavityLib.MOD_ID, MavityLibConfig.class);
	}
}