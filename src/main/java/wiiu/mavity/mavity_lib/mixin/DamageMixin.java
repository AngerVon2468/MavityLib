package wiiu.mavity.mavity_lib.mixin;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.item.ItemStack;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import wiiu.mavity.mavity_lib.tags.TagInit;

@Mixin(DamageEnchantment.class)
public class DamageMixin {
	@ModifyReturnValue(method = "isAcceptableItem", at = @At(value = "RETURN"))
	private boolean override_accept(boolean original, ItemStack stack) {
		return original || stack.isIn(TagInit.ENCHANT_ITEM);
	}
}