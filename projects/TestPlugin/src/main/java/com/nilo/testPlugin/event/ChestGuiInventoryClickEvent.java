package com.nilo.testPlugin.event;

import com.nilo.testPlugin.gui.ChestGui;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.swing.*;

public class ChestGuiInventoryClickEvent implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();

        if (!(inventory.getHolder(false) instanceof ChestGui chestGui) || !(event.getWhoClicked() instanceof Player) || event.getSlot() < 0) {
            return;
        }

        if (event.getClickedInventory() != null && event.getClickedInventory().getType() != InventoryType.CHEST) {
            if (event.getAction() == InventoryAction.COLLECT_TO_CURSOR || event.isShiftClick()) {
                event.setCancelled(true);
            }

            return;
        }

        event.setCancelled(true);

        chestGui.clicked(event);

//        ItemStack clicked = event.getCurrentItem();
//        if (clicked != null && clicked.getType() == Material.DIAMOND) {
//            player.sendRichMessage("Super <playername>, you clicked the <itemname>, closing inventory...", Placeholder.parsed("playername", player.getName()), Placeholder.parsed("itemname", clicked.getType().toString()));
//            player.closeInventory();
//        }
    }
}
