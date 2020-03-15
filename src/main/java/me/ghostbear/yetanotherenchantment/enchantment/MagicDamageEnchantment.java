package me.ghostbear.yetanotherenchantment.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MagicDamageEnchantment extends Enchantment {

    public MagicDamageEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentType.WEAPON, new EquipmentSlotType[] {EquipmentSlotType.MAINHAND});
    }

    @SubscribeEvent
    public static void onAttackEvent(LivingAttackEvent attackEvent) {
        DamageSource damageSource = attackEvent.getSource();

        damageSource.setMagicDamage();
    }
}
