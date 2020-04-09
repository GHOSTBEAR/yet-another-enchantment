package me.ghostbear.yetanotherenchantment.enchantment;

import me.ghostbear.yetanotherenchantment.Reference;
import me.ghostbear.yetanotherenchantment.init.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class LifedrainEnchantment extends Enchantment {

    public LifedrainEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.WEAPON, new EquipmentSlotType[] {EquipmentSlotType.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 90;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return 190;
    }

    @SubscribeEvent
    public static void onAttackEvent(LivingAttackEvent attackEvent) {
        DamageSource damageSource = attackEvent.getSource();

        if (damageSource.getTrueSource() instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) damageSource.getTrueSource();

            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(playerEntity.getHeldItemMainhand());

            if (enchantments.containsKey(ModEnchantments.LIFEDRAIN_ENCHANTMENT)) {
                int level = enchantments.get(ModEnchantments.LIFEDRAIN_ENCHANTMENT);

                playerEntity.heal(0.5f * level + attackEvent.getAmount() * 0.289f);
            }
        }
    }
}
