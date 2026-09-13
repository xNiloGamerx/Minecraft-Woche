package com.nilo.testPlugin.gui.item;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class BasicPageItem implements PageItem {
    private final ItemStack item;
    private final int index;
    private final PageItemAction action;

    public BasicPageItem(ItemStack item, int index, PageItemAction action) {
        this.item = item;
        this.index = index;
        this.action = action;
    }

    @Override
    public void create(Inventory inventory) {
        inventory.setItem(this.index, this.item);
    }

    @Override
    public void execute(InventoryClickEvent event) {
        this.action.execute(event);
    }

    @Override
    public ItemStack getItem() {
        return this.item;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public List<Integer> getSlots() {
        return new ArrayList<>(List.of(this.index));
    }
}
