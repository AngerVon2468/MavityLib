package wiiu.mavity.mavity_lib.util.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.*;

import wiiu.mavity.mavity_lib.MavityLib;

public class MavityEvents {

    public static void clientTickEvent() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // WiiU
        });
    }

    public static void serverTickEvent() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            // WiiU
        });
    }

    public static void loadServerEvent() {
        ServerWorldEvents.LOAD.register((server, world) -> {
            // WiiU
        });
    }

    public static void stopSleepingEvent() {
        EntitySleepEvents.STOP_SLEEPING.register((entity, sleepingPos) -> {
            // I could use this in a nightmare mod!!
        });
    }

    public static void registerMavityEvents() {
        clientTickEvent();
        serverTickEvent();
        loadServerEvent();
        stopSleepingEvent();
        MavityLib.LOGGER.info(MavityLib.NAME + " has registered its events. (WHAT!? ON FABRIC!?)");
    }
}