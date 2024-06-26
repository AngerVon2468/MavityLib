package wiiu.mavity.mavity_lib

import net.fabricmc.loader.api.FabricLoader

import wiiu.mavity.mavity_lib.MavityLib.*
import wiiu.mavity.mavity_lib.event.EventCallbacks

class MavityLibButInKotlin {

    companion object {

        @JvmStatic
        fun registerMavityLibButInKotlin() {
            EventCallbacks.registerEventCallbacks()
            if(FabricLoader.getInstance().isDevelopmentEnvironment) {
                LOGGER.info("$NAME has registered its main kotlin class.")
            }
        }
    }
}