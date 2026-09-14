package com.nilo.testPlugin.gui.item;

import com.nilo.testPlugin.gui.ChestGui;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListPageItem implements PageItem {
    private ChestGui chestGui;
    private int start;
    private int width;
    private int height;
    private int backItemSlot;
    private int forwardItemSlot;
    private int itemsPerPage;

    private List<ItemStack> listItems;

    private final HashMap<Integer, List<ItemStack>> pages;
    private int pageIndex = 0;

    public ListPageItem(ChestGui chestGui, List<ItemStack> listItems, int start, int width, int height) {
        this.chestGui = chestGui;
        this.pages = new HashMap<>();
        this.listItems = listItems;
        this.start = start;
        this.width = width;
        this.height = height;
        this.backItemSlot = start + (height - 1) * 9;
        this.forwardItemSlot = (start + (height - 1) * 9) + (width - 1);
        this.itemsPerPage = width * (height - 1);

        List<ItemStack> items = new ArrayList<>();
        int createdPages = 0;
        int i = 0;
        for (ItemStack item : listItems) {
            items.add(item);
            i++;

            if (i >= itemsPerPage) {
                pages.put(createdPages, new ArrayList<>(items));
                createdPages++;

                items.clear();
                i = 0;
            }
        }
        if (!items.isEmpty()) {
            pages.put(createdPages, new ArrayList<>(items));
        }
    }

    private void setNavItems(Inventory inventory) {
        inventory.setItem(this.backItemSlot, new ItemStack(Material.ARROW));
        inventory.setItem(this.forwardItemSlot, new ItemStack(Material.ARROW));
    }

    @Override
    public void create(Inventory inventory) {
        if (width < 3 || height < 3) {
            return;
        }

        int lineStart = start;
        int index = lineStart;
        int lineBreaks = 0;

        for (ItemStack item : pages.get(pageIndex)) {
            if (index >= lineStart + width) {
                index += 9 - width;
                lineStart += 9;
                lineBreaks++;
            }

//            if (lineBreaks >= height - 1) {
//                break;
//            }

            inventory.setItem(index, item);
            index++;
        }
        this.setNavItems(inventory);
    }

    @Override
    public void execute(InventoryClickEvent event) {
        int slot = event.getSlot();

        if (slot == this.backItemSlot && this.pageIndex - 1 >= 0) {
            this.pageIndex--;
            this.chestGui.load();
        } else if (slot == this.forwardItemSlot && this.pageIndex + 1 < pages.size()) {
            this.pageIndex++;
            this.chestGui.load();
        }
    }

    @Override
    public ItemStack getItem() {
        return null;
    }

    @Override
    public int getIndex() {
        return start;
    }

    @Override
    public List<Integer> getSlots() {
        List<Integer> slots = new ArrayList<>();

        int lineStart = start;
        int index = lineStart;

        for (int i = 0; i < width *  (height - 1); i++) {
            if (index >= lineStart + width) {
                index += 9 - width;
                lineStart += 9;
            }

            slots.add(index);
            index++;
        }
        slots.add(backItemSlot);
        slots.add(forwardItemSlot);

        return slots;
    }
}
