package me.ghostbear.yetanotherenchantment.enchantment;

import me.ghostbear.yetanotherenchantment.Reference;
import me.ghostbear.yetanotherenchantment.init.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class DarkvisionEnchantment extends Enchantment {

    public DarkvisionEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.ARMOR_HEAD, new EquipmentSlotType[]{EquipmentSlotType.HEAD});
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 30;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return 60;
    }

    @SubscribeEvent
    public static void onWearing(LivingEquipmentChangeEvent equipmentChangeEvent) {
        ItemStack from = equipmentChangeEvent.getFrom();
        ItemStack to = equipmentChangeEvent.getTo();

        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(from);

        if (enchantments.containsKey(ModEnchantments.DARKVISION_ENCHANTMENT)) {
            equipmentChangeEvent.getEntityLiving().removePotionEffect(Effects.NIGHT_VISION);
        }

        enchantments = EnchantmentHelper.getEnchantments(to);

        if (enchantments.containsKey(ModEnchantments.DARKVISION_ENCHANTMENT)) {
            equipmentChangeEvent.getEntityLiving().addPotionEffect(new EffectInstance(Effects.NIGHT_VISION,32767));
        }
    }
}
