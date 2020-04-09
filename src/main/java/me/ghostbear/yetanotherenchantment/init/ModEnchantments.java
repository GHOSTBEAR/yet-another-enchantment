package me.ghostbear.yetanotherenchantment.init;

import me.ghostbear.yetanotherenchantment.Reference;
import me.ghostbear.yetanotherenchantment.enchantment.DarkvisionEnchantment;
import me.ghostbear.yetanotherenchantment.enchantment.MagicDamageEnchantment;
import me.ghostbear.yetanotherenchantment.enchantment.StoneskinEnchantment;
import me.ghostbear.yetanotherenchantment.enchantment.LifedrainEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ArrayList;
import java.util.List;

@ObjectHolder(Reference.MOD_ID)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEnchantments {

    private static final List<Enchantment> ENCHANTMENTS = new ArrayList<>();

    public static final Enchantment DARKVISION_ENCHANTMENT = register(new ResourceLocation(Reference.MOD_ID, "darkvision_enchantment"), new DarkvisionEnchantment());
    public static final Enchantment LIFEDRAIN_ENCHANTMENT = register(new ResourceLocation(Reference.MOD_ID, "lifedrain_enchantment"), new LifedrainEnchantment());
    public static final Enchantment STONESKIN_ENCHANTMENT = register(new ResourceLocation(Reference.MOD_ID, "stoneskin_enchantment"), new StoneskinEnchantment());
    public static final Enchantment MAGIC_DAMAGE_ENCHANTMENT = register(new ResourceLocation(Reference.MOD_ID, "magic_damage_enchantment"), new MagicDamageEnchantment());

    public static Enchantment register(ResourceLocation key, Enchantment enchantment) {
        enchantment.setRegistryName(key);
        ENCHANTMENTS.add(enchantment);
        return enchantment;
    }

    @SubscribeEvent
    public static void onEnchantmentRegistry(RegistryEvent.Register<Enchantment> enchantmentRegistryEvent) {
        ENCHANTMENTS.forEach(enchantmentRegistryEvent.getRegistry()::register);
        ENCHANTMENTS.clear();
    }
}
