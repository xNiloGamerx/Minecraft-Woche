package com.nilo.testPlugin.gui;

import com.nilo.testPlugin.Main;
import com.nilo.testPlugin.gui.item.*;
import com.nilo.testPlugin.gui.page.Page;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class ChestGui implements InventoryHolder {
    private final Inventory inventory;
    private final HashMap<Integer, Page> pages;
    private int pageIndex = 0;

    List<ItemStack> items = List.of(
            new ItemStack(Material.DIAMOND),
            new ItemStack(Material.IRON_INGOT),
            new ItemStack(Material.GOLD_INGOT),
            new ItemStack(Material.EMERALD),
            new ItemStack(Material.COAL),
            new ItemStack(Material.STICK),
            new ItemStack(Material.APPLE),
            new ItemStack(Material.BREAD),
            new ItemStack(Material.CHEST),
            new ItemStack(Material.IRON_SWORD)
    );

    public ChestGui(Main plugin, Component title) {
        this.pages = new HashMap<>();
        this.pages.put(
                0,
                new Page(
                        Stream.concat(
                            Stream.<PageItem>of(
                                    new BasicPageItem(new ItemStack(Material.IRON_SWORD), 0, event -> Bukkit.broadcast(Component.text("Super "+ event.getWhoClicked().getName() + ", Clicked Iron Sword"))),
                                    new BasicPageItem(new ItemStack(Material.IRON_PICKAXE), 1, event -> Bukkit.broadcast(Component.text("Super "+ event.getWhoClicked().getName() + ", Clicked Iron Pickaxe"))),
                                    new BasicPageItem(new ItemStack(Material.IRON_AXE), 2, event -> Bukkit.broadcast(Component.text("Super "+ event.getWhoClicked().getName() + ", Clicked Iron Axe"))),
                                    new ListPageItem(this, items, 6, 3, 3)
                            ),
                            new NavPageItems(this).getNavItems().stream()
                        ).toList()
                )
        );
        this.pages.put(
                1,
                new Page(
                    Stream.concat(
                        Stream.<PageItem>of(
                            new PlayerListPageItem(this, new ArrayList<>(Bukkit.getOnlinePlayers()), 0, 9, 4)
                        ),
                        new NavPageItems(this).getNavItems().stream()
                    ).toList()
                )
        );

        this.inventory = plugin.getServer().createInventory(this, 9*4, title);
    }

    @Override
    public Inventory getInventory() {
        this.load();
        return inventory;
    }

    public void load() {
        this.clear();
        pages.get(pageIndex).create(inventory);
    }

    public void clicked(InventoryClickEvent event) {
        pages.get(pageIndex).clicked(event);
    }

    public void clear() {
        this.inventory.clear();
    }

    public void nextPage(Player player) {
        if (pageIndex + 1 >= pages.size()) return;
        pageIndex++;
        this.load();
    }

    public void previousPage(Player player) {
        if (pageIndex - 1 < 0) return;
        pageIndex--;
        this.load();
    }
}
