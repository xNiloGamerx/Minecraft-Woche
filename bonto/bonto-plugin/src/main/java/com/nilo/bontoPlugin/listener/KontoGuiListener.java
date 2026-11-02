package com.nilo.bontoPlugin.listener;

import com.nilo.bontoPlugin.gui.KontoGui;
import com.nilo.bontoPlugin.konto.Konto;
import com.nilo.bontoPlugin.konto.KontoManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.awt.*;

public class KontoGuiListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inv = event.getInventory();

        if (!(inv.getHolder(false) instanceof KontoGui kontoGui)) {
            return;
        }

        ItemStack clicked = event.getCurrentItem();
        if (clicked == null) {
            return;
        }

        if (clicked.getType().equals(Material.DIAMOND)) {
            return;
        }

        event.setCancelled(true);

        if (clicked.getType().equals(Material.ARROW)) {
            kontoGui.home();
            return;
        } else if (clicked.getType().equals(Material.GREEN_TERRACOTTA)) {
            ItemStack item = kontoGui.getInventory().getItem(31);
            if (item == null) {
                kontoGui.home();
                return;
            }

            Konto currentKonto = kontoGui.getCurrentOpenKonto();
            if (currentKonto != null) {
                KontoManager.buchen(currentKonto, item.getAmount());
            }

            kontoGui.home();
        }

        if (clicked.lore() == null || clicked.lore().size() <= 0) {
            return;
        }

        String id = PlainTextComponentSerializer.plainText().serialize(clicked.lore().get(0));
        kontoGui.openKontoEdit(id);
    }
}
