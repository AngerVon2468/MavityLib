package wiiu.mavity.mavity_lib.item;

import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.item.Item;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

import wiiu.mavity.mavity_lib.MavityLib;

/**
 * Registry class to be called on by other mods from me. <br>
 * Items should be registered like so: <br>
 * <br>
 * <strong>
 *     public static final Item WiiU = ItemRegistry.registerItem("example_mod_id", "wiiu", <br>
 *     <p style="margin-left: 35px">
 *         new Item(PropertyInit.GTOIU));
 *     </p>
 * </strong> <br>
 * Replace "example_mod_id" with your modid, or use the modid you define in your main class <br>
 * (something like ExampleMod.MOD_ID).
 */
public class ItemRegistry {

    public static Item registerItem(String modid, String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(modid, name), item);
    }

    // Register items in other mods ItemInits using the registerItem method from here.

    public static void registerItemRegistry() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            MavityLib.LOGGER.info(MavityLib.NAME + " has registered its item registry.");
        }
    }
}