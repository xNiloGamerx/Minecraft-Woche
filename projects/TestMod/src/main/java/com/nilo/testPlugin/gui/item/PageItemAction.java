package com.nilo.testPlugin.gui.item;

import org.bukkit.event.inventory.InventoryClickEvent;

@FunctionalInterface
public interface PageItemAction {
    void execute(InventoryClickEvent event);
}
