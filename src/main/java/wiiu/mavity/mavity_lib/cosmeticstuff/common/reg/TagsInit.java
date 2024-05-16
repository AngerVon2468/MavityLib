package wiiu.mavity.mavity_lib.cosmeticstuff.common.reg;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import wiiu.mavity.mavity_lib.MavityLib;

public class TagsInit {
    public static class Items {
        public static final TagKey<Item> COSMETICS = createTag("cosmetics");
        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, MavityLib.id(name));
        }
    }
}