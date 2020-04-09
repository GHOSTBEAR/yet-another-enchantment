package me.ghostbear.yetanotherenchantment.enchantment;

import me.ghostbear.yetanotherenchantment.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class MagicDamageEnchantment extends Enchantment {

    public MagicDamageEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentType.WEAPON, new EquipmentSlotType[] {EquipmentSlotType.MAINHAND});
    }

    @SubscribeEvent
    public static void onMagicAttackEvent(LivingDamageEvent damageEvent) {
        DamageSource damageSource = damageEvent.getSource();
        damageEvent.setAmount(damageEvent.getAmount() + 1.1f);
        damageSource.setMagicDamage();
    }
}
