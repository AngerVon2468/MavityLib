package wiiu.mavity.mavity_lib;

import eu.midnightdust.lib.config.MidnightConfig;

import net.fabricmc.api.ModInitializer;

import wiiu.mavity.mavity_lib.block.BlockRegistry;
import wiiu.mavity.mavity_lib.config.MavityLibConfig;
import wiiu.mavity.mavity_lib.credits.MavityLibMenuCredits;
import wiiu.mavity.mavity_lib.item.ItemRegistry;
import wiiu.mavity.mavity_lib.property.PropertyInit;
import wiiu.mavity.mavity_lib.tags.TagInit;

import org.slf4j.*;

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

		// Config
		MidnightConfig.init(MavityLib.MOD_ID, MavityLibConfig.class);
	}
}