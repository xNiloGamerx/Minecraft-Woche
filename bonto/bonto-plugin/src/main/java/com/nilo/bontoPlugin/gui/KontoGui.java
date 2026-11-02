package com.nilo.bontoPlugin.gui;

import com.nilo.bontoPlugin.Main;
import com.nilo.bontoPlugin.konto.Konto;
import com.nilo.bontoPlugin.konto.KontoManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class KontoGui implements InventoryHolder {
    private final Inventory inventory;
    private Konto currentOpenKonto = null;

    public KontoGui(Main plugin) {
        this.inventory = plugin.getServer().createInventory(this, 6 * 9, Component.text("Kontos"));

        load();
    }

    public void home() {
        load();
    }

    private void load() {
        this.inventory.clear();

        Collection<Konto> kontos = KontoManager.getAll();

        for (int i = 0; i < kontos.size(); i++) {
            Konto konto = (Konto) kontos.toArray()[i];
            this.inventory.setItem(i, KontoManager.getKontoItem(konto));
        }
    }

    public void openKontoEdit(String id) {
        this.inventory.clear();

        Konto konto = KontoManager.get(id);
        currentOpenKonto = konto;
        this.inventory.setItem(4, KontoManager.getKontoItem(konto));
        this.inventory.setItem(45, new ItemStack(Material.ARROW));

        ItemStack highlightItem = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        for (int i = 21; i < 24; i++) {
            this.inventory.setItem(i, highlightItem);
            this.inventory.setItem(i + 9, highlightItem);
            this.inventory.setItem(i + 9 * 2, highlightItem);
        }
        this.inventory.setItem(31, null);

        this.inventory.setItem(49, new ItemStack(Material.GREEN_TERRACOTTA));
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public Konto getCurrentOpenKonto() {
        return currentOpenKonto;
    }
}
