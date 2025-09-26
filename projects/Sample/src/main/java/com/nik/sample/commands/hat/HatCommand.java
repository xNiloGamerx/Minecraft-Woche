package com.nik.sample.commands.hat;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class HatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) return false;

        // get the current item in the players main hand
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();
        // get current item on head so player doesn't lose the item
        ItemStack currentHat = player.getInventory().getItem(EquipmentSlot.HEAD);

        // set mainhand item on the head slot
        player.getInventory().setItem(EquipmentSlot.HEAD, mainHandItem);
        // set old head item to the mainhand
        player.getInventory().setItem(EquipmentSlot.HAND, currentHat);

        // play equip sound
        player.playSound(
                player.getLocation(),
                Sound.ITEM_ARMOR_EQUIP_GENERIC,
                1.0f,
                1.0f
        );

        return false;
    }
}
