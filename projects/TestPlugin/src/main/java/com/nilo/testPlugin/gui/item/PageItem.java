package com.nilo.testPlugin.gui.item;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface PageItem {
    void create(Inventory inventory);
    void execute(InventoryClickEvent event);
    ItemStack getItem();
    int getIndex();
    List<Integer> getSlots();
}
