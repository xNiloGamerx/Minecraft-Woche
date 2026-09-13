package com.nilo.testPlugin.gui.page;

import com.nilo.testPlugin.gui.item.PageItem;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.List;

public class Page {
    private final HashMap<Integer, PageItem> items = new HashMap<>();

    public Page(List<PageItem> items) {
        for (PageItem item : items) {
            this.items.put(item.getIndex(), item);
        }
    }

    public void create(Inventory inventory) {
        for (PageItem pageItem : items.values()) {
            pageItem.create(inventory);
        }
    }

    public void clicked(InventoryClickEvent event) {
        int slot = event.getSlot();

        for (PageItem pageItem : items.values()) {
            List<Integer> slots = pageItem.getSlots();

            if (slots.contains(slot)) {
                pageItem.execute(event);
                break;
            }
        }
    }
}
