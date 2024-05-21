package wiiu.mavity.mavity_lib.event

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents
import net.fabricmc.fabric.api.event.lifecycle.v1.*
import net.fabricmc.loader.api.FabricLoader

import net.minecraft.client.gui.screen.TitleScreen

import wiiu.mavity.mavity_lib.MavityLib.*

class EventCallbacks {

    companion object {

        @JvmStatic
        fun clientTickEvent() {
            ClientTickEvents.END_CLIENT_TICK.register { client ->
                // WiiU
            }
        }

        @JvmStatic
        fun serverTickEvent() {
            ServerTickEvents.END_SERVER_TICK.register { server ->
                // WiiU
            }
        }

        @JvmStatic
        fun loadServerEvent() {
            ServerWorldEvents.LOAD.register { server, world ->
                // WiiU
            }
        }

        @JvmStatic
        fun stopSleepingEvent() {
            EntitySleepEvents.STOP_SLEEPING.register { entity, sleepingPos ->
                // WiiU
            }
        }

        @JvmStatic
        fun titleScreenLoadedEvent() {
            ScreenEvents.AFTER_INIT.register { client, screen, scaledWidth, scaledHeight ->
                if (screen is TitleScreen) {
                    /*client.getSoundManager().play()*/
                    LOGGER.info("Title screen lol")
                }
            }
        }

        @JvmStatic
        fun registerEventCallBacks() {
            clientTickEvent()
            serverTickEvent()
            loadServerEvent()
            stopSleepingEvent()
            titleScreenLoadedEvent()
            if (FabricLoader.getInstance().isDevelopmentEnvironment) {
                LOGGER.info("$NAME has registered its events. (WHAT!? ON FABRIC!?)")
            }
        }
    }
}