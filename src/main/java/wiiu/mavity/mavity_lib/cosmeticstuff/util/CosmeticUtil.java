package wiiu.mavity.mavity_lib.cosmeticstuff.util;

import dev.emi.trinkets.api.*;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.util.TriState;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;

import wiiu.mavity.mavity_lib.MavityLib;
import wiiu.mavity.mavity_lib.cosmeticstuff.client.model.*;
import wiiu.mavity.mavity_lib.cosmeticstuff.common.reg.TagsInit;

import java.util.*;

public class CosmeticUtil {
    public static ItemStack getCosmeticArmor(LivingEntity entity, EquipmentSlot slot) {
        Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(entity);
        if(component.isPresent()) {
            List<Pair<SlotReference, ItemStack>> list = component.get().getEquipped(stack -> stack.isIn(TagsInit.Items.COSMETICS));
            for(Pair<SlotReference, ItemStack> equipped : list) {
                SlotType slotType = equipped.getLeft().inventory().getSlotType();
                if(!slotType.getName().equals("necklace")) {
                    continue;
                }
                if(!slotType.getGroup().equalsIgnoreCase(slot.getName())) {
                    continue;
                }
                return equipped.getRight();
            }
        }
        return ItemStack.EMPTY;
    }

    public static final EntityModelLayer CLOTHING_MODEL_LAYER = new EntityModelLayer(MavityLib.id("clothing"), "main");

    public static final EntityModelLayer SLIM_CLOTHING_MODEL_LAYER = new EntityModelLayer(MavityLib.id("slim_clothing"), "main");

    public static void REGISTERMEEEEEEEEEEEEEEEE() {

        EntityModelLayerRegistry.registerModelLayer(CLOTHING_MODEL_LAYER, ClothingModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SLIM_CLOTHING_MODEL_LAYER, SlimClothingModel::getTexturedModelData);
    }

    public static void REGISTERMEINMAINNNNNN() {
        // Erm what the sigma
        EquipmentSlot slot = EquipmentSlot.fromTypeIndex(EquipmentSlot.Type.ARMOR, 2);
        TrinketsApi.registerTrinketPredicate(MavityLib.id(slot.getName()), ((itemStack, slotReference, livingEntity) -> {
            if (itemStack.isIn(TagsInit.Items.COSMETICS)){
                return TriState.TRUE;
            }
            return TriState.DEFAULT;
        }));
    }
}