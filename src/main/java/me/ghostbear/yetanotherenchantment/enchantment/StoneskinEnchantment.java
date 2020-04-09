package me.ghostbear.yetanotherenchantment.enchantment;

import me.ghostbear.yetanotherenchantment.Reference;
import me.ghostbear.yetanotherenchantment.init.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class StoneskinEnchantment extends Enchantment {

    public StoneskinEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.ARMOR, new EquipmentSlotType[] {EquipmentSlotType.FEET, EquipmentSlotType.LEGS, EquipmentSlotType.CHEST, EquipmentSlotType.HEAD});
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 200;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return 250;
    }

    public static boolean hasEnchantment(LivingEntity livingEntity) {
        boolean hasEnchantment = false;

        for (ItemStack itemStack : livingEntity.getArmorInventoryList()) {
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(itemStack);

            if (enchantments.containsKey(ModEnchantments.STONESKIN_ENCHANTMENT)) {
                hasEnchantment = true;
            }
        }

        return hasEnchantment;
    }

    public static void takeDurability(LivingEntity livingEntity) {
        for (ItemStack itemStack : livingEntity.getArmorInventoryList()) {
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(itemStack);

            if (enchantments.containsKey(ModEnchantments.STONESKIN_ENCHANTMENT)) {
                itemStack.setDamage(itemStack.getDamage() + 1);
            }
        }
    }

    @SubscribeEvent
    public static void onHurtEvent(LivingHurtEvent hurtEvent) {
        if (hasEnchantment(hurtEvent.getEntityLiving())) {
            DamageSource damageSource = hurtEvent.getSource();
            if (damageSource.isExplosion()) {
                hurtEvent.setAmount(hurtEvent.getAmount() * 0.1F);
            }
            if (!damageSource.isMagicDamage()) {
                hurtEvent.setAmount(0.0F);
                takeDurability(hurtEvent.getEntityLiving());
            }
        }
    }
}
