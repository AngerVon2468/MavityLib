package wiiu.mavity.mavity_lib;

import net.fabricmc.fabric.api.datagen.v1.*;

import wiiu.mavity.mavity_lib.util.exception.AntiDataGenException;

public class MavityLibDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		throw new AntiDataGenException("Ew datagen!!");
	}
}