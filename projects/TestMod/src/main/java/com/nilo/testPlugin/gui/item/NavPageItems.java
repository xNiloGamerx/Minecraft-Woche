package com.nilo.testPlugin.gui.item;

import com.nilo.testPlugin.gui.ChestGui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class NavPageItems {
    private final ChestGui chestGui;
    private final List<BasicPageItem> navItems;

    public NavPageItems(ChestGui chestGui) {
        this.chestGui = chestGui;

        this.navItems = new ArrayList<>();
        navItems.add(
                new BasicPageItem(new ItemStack(Material.ARROW), 30, event -> chestGui.previousPage((Player) event.getWhoClicked()))
        );
        navItems.add(
                new BasicPageItem(new ItemStack(Material.RED_CANDLE), 31, event -> event.getWhoClicked().closeInventory())
        );
        navItems.add(
                new BasicPageItem(new ItemStack(Material.GOLDEN_CARROT), 32, event -> chestGui.nextPage((Player) event.getWhoClicked()))
        );
    }

    public List<BasicPageItem> getNavItems() {
        return navItems;
    }
}
