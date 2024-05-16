package wiiu.mavity.mavity_lib.cosmeticstuff.common.item;

import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.*;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.*;
import net.minecraft.item.ItemStack;

import java.util.UUID;

public class ClothingItem extends TrinketItem {
    public final String texture;
    public ClothingItem(Settings settings, String texture) {
        super(settings);
        this.texture = texture;
    }

    public String getClothTexture() {
        return this.texture;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);

        modifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uuid, "cosmeticanew:generic_armor", 1.0, EntityAttributeModifier.Operation.ADDITION));
        return modifiers;
    }
}