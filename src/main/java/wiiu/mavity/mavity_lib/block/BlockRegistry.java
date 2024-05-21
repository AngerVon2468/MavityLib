package wiiu.mavity.mavity_lib.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

import wiiu.mavity.mavity_lib.MavityLib;

/**
 * Registry class to be called on by other mods from me. <br>
 * Blocks should be registered like so: <br>
 * <br>
 * <strong>
 *     public static final Block WiiU = BlockRegistry.registerBlock("example_mod_id", "wiiu", <br>
 *     <p style="margin-left: 35px">
 *         new Block(FabricBlockSettings.create()));
 *     </p>
 * </strong> <br>
 * Replace "example_mod_id" with your modid, or use the modid you define in your main class <br>
 * (something like ExampleMod.MOD_ID).
 */
public class BlockRegistry {

    public static Block registerBlock(String modid, String name, Block block) {
        registerBlockItem(modid, name, block);
        return Registry.register(Registries.BLOCK, new Identifier(modid, name), block);
    }

    public static Item registerBlockItem(String modid, String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(modid, name),
                new BlockItem(block, new FabricItemSettings().maxCount(64)));
    }

    // Register items in other mods BlockInits using the registerBlock method from here.

    public static void registerBlockRegistry() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            MavityLib.LOGGER.info(MavityLib.NAME + " has registered its block registry.");
        }
    }
}