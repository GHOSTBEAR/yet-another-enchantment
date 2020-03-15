package com.example.examplemod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ExampleItem extends Item {

    public ExampleItem(Properties properties) {
        super(properties);
        this.setRegistryName("example_item");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        // Here you can add logic if the player right click with the item
        // Example if it is a food item or a item that you can place
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
