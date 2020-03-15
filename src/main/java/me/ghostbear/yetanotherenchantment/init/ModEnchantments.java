package me.ghostbear.yetanotherenchantment.init;

import me.ghostbear.yetanotherenchantment.Reference;
import me.ghostbear.yetanotherenchantment.enchantment.VampireEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModEnchantments {

    private static final List<Enchantment> ENCHANTMENTS = new ArrayList<>();

    public static final Enchantment VAMPIRE_ENCHANTMENT = register(new ResourceLocation(Reference.MOD_ID, "vampire_enchantment"), new VampireEnchantment());

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
