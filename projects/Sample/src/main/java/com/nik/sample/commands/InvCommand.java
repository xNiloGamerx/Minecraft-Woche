package com.nik.sample.commands;

import com.nik.sample.Main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.EventListener;
import java.util.Objects;

public class InvCommand implements CommandExecutor, EventListener, Listener {
    private Component chestInvTitle;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) return false;

        if (args.length != 1) {
            player.sendMessage(
                    Main.getInstance().getPrefix()
                            .append(
                                    Component.text(
                                                    "Bitte gebe einen Spielernamen an!"
                                            )
                                            .color(
                                                    TextColor.color(185, 212, 176
                                                    )
                                            )
                            )
            );
            return false;
        }

        Player targetPlayer = null;
        for (Player playerOnline : Bukkit.getOnlinePlayers()) {
            if (args[0].equals(playerOnline.getName())) {
                targetPlayer = playerOnline;
            }
        }

        if (targetPlayer == null) return false;

        Inventory targetPlayerInv = targetPlayer.getInventory();
        Inventory chestInv = Bukkit.createInventory(null, 9*6, Main.getInstance().getMiniMessage().deserialize("<gradient:#1d7001:#258f01:#52c234>" + targetPlayer.getName() +"</gradient>"));
        chestInvTitle = Main.getInstance().getMiniMessage().deserialize("<gradient:#1d7001:#258f01:#52c234>" + targetPlayer.getName() +"</gradient>");

        ItemStack[] hotbarItems = new ItemStack[9];
        ItemStack[] mainInventoryItems = new ItemStack[9 * 3];
        ItemStack[] armorItems = new ItemStack[4];
        ItemStack offhandItem = new ItemStack(Material.AIR);
        for (int i = 0; i < targetPlayerInv.getContents().length; i++) {
            if (i < 9) {
                hotbarItems[i] = targetPlayerInv.getContents()[i];
            }
            else if (i < 9*4) {
                mainInventoryItems[i - 9] = targetPlayerInv.getContents()[i];
            }
            else if (i < 9*4 + 4) {
                // Fetch armor in reverse
                armorItems[(9*4 + 3) - i] = targetPlayerInv.getContents()[i];
            }
            else if (i == 40) {
                offhandItem = targetPlayerInv.getContents()[i];
            }
        }

        for (int i = 0; i < chestInv.getSize(); i++) {
            if (i < 9 * 3) {
                chestInv.setItem(i, mainInventoryItems[i]);
            }
            else if (i < 9 * 4) {
                chestInv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
            }
            else if (i < 9 * 5) {
                chestInv.setItem(i, hotbarItems[i - 9*4]);
            }
            else if (i == 45) {
                chestInv.setItem(i, offhandItem);
            }
            else if (i > 49) {
                chestInv.setItem(i, armorItems[i - 50]);
            }
        }

        player.openInventory(chestInv);

        return false;
    }

    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {
        Component invTitle = event.getView().title();
        if (chestInvTitle != null) {
            if (chestInvTitle.equals(invTitle)) {
                event.setCancelled(true);
            }
        }
    }

}
