package wiiu.mavity.mavity_lib.tags;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import wiiu.mavity.mavity_lib.MavityLib;

public class TagInit {

    public static final TagKey<Item> ALL = TagKey.of(RegistryKeys.ITEM, new Identifier(MavityLib.MOD_ID, "all"));

    public static final TagKey<Item> ENCHANT_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(MavityLib.MOD_ID, "enchant_item"));

    public static final TagKey<Item> ENCHANT_ARMOUR = TagKey.of(RegistryKeys.ITEM, new Identifier(MavityLib.MOD_ID, "enchant_armour"));

    public static void registerTagInit() {
        MavityLib.LOGGER.info(MavityLib.NAME + " has registered its' item tags.");
    }
}