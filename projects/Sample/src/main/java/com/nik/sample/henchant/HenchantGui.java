package com.nik.sample.henchant;

import com.nik.sample.Main;
import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Tag;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class HenchantGui implements Listener {
    private Player player;
    private final MiniMessage miniMessage;
    private final Inventory inventory;

    public HenchantGui(Player player) {
        this.player = player;
        miniMessage = MiniMessage.miniMessage();
        inventory = Bukkit.createInventory(null, 6 * 9, miniMessage.deserialize("<gradient:#A02EF7:#6B00FF>Henchant | Enhance enchanting</gradient>"));
        setupInventory();
    }

    public int toChestIndex(int x, int y) {
        return x + y * 9;
    }

    private void setupInventory() {
        setStatusCircleDefault();

        for (int y = 0; y < inventory.getSize() / 9; y++) {
            inventory.setItem(toChestIndex(3, y), new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
        }
    }

    public void openInventory() {
        player.openInventory(inventory);
    }

    public void setStatusCircle(ItemStack itemStack) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (x == 1 && y == 1) continue;
                inventory.setItem(toChestIndex(x, y), itemStack);
            }
        }
    }

    public void setStatusCircleSuccess() {
        setStatusCircle(new ItemStack(Material.LIME_STAINED_GLASS_PANE));
    }

    public void setStatusCircleDefault() {
        setStatusCircle(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
    }

    public void setStatusCircleEnchant() {
        setStatusCircle(new ItemStack(Material.PURPLE_STAINED_GLASS_PANE));
    }

    public void setStatusCircleDisenchant() {
        setStatusCircle(new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
    }

    public static boolean isToolOrWeapon(ItemStack item) {
        if (item == null || item.getType().isAir()) return false;
        Material mat = item.getType();

        return Tag.ITEMS_SWORDS.isTagged(mat)
                || Tag.ITEMS_AXES.isTagged(mat)
                || Tag.ITEMS_PICKAXES.isTagged(mat)
                || Tag.ITEMS_SHOVELS.isTagged(mat)
                || Tag.ITEMS_HOES.isTagged(mat)
                || Tag.ITEMS_ENCHANTABLE_TRIDENT.isTagged(mat)
                || Tag.ITEMS_ENCHANTABLE_BOW.isTagged(mat)
                || Tag.ITEMS_ENCHANTABLE_CROSSBOW.isTagged(mat);
    }

    public List<Enchantment> getPossibleEnchantments(ItemStack item) {
        List<Enchantment> possibleEnchantments = new ArrayList<>();
        for (Enchantment enchantment : RegistryAccess.registryAccess().getRegistry(RegistryKey.ENCHANTMENT)) {
            if (enchantment.canEnchantItem(item)) {
                possibleEnchantments.add(enchantment);
            }
        }
        return possibleEnchantments;
    }

    public void fillEnchantments(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();

        List<Enchantment> possibleEnchantments = getPossibleEnchantments(item);

        int x = 4;
        int y = 0;
        for (Enchantment possibleEnchantment : possibleEnchantments) {
            if (y >= inventory.getSize() / 9) break;

            ItemStack listItem;
            if (itemMeta.hasEnchant(possibleEnchantment)) {
                listItem = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta listItemMeta = listItem.getItemMeta();
                listItemMeta.displayName(Component.text("Already used enchantment!")
                        .color(TextColor.color(255, 0, 0))
                        .decorate(TextDecoration.BOLD)
                );
                listItemMeta.addEnchant(possibleEnchantment, possibleEnchantment.getMaxLevel(), false);
                listItem.setItemMeta(listItemMeta);
            }
            else {
                listItem = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta enchantedBookMeta = listItem.getItemMeta();
                enchantedBookMeta.addEnchant(possibleEnchantment, possibleEnchantment.getMaxLevel(), false);
                listItem.setItemMeta(enchantedBookMeta);
            }

            inventory.setItem(toChestIndex(x, y), listItem);

            x++;
            if (x >= 9) {
                y++;
                x = 4;
            }
        }
    }

    public void clearEnchantments() {
        for (int y = 0; y < inventory.getSize() / 9; y++) {
            for (int x = 4; x < 9; x++) {
                inventory.setItem(toChestIndex(x, y), new ItemStack(Material.AIR));
            }
        }
    }

    private void setEnchantment(ItemStack item, ItemStack clickedBook) {
        ItemMeta clickedBookMeta = clickedBook.getItemMeta();
        for (Enchantment enchantment : clickedBookMeta.getEnchants().keySet()) {
            ItemMeta itemMeta = item.getItemMeta();

            if (itemMeta.hasEnchant(enchantment)) {
                itemMeta.removeEnchant(enchantment);
                item.setItemMeta(itemMeta);
                player.playSound(player.getLocation(), Sound.BLOCK_GRINDSTONE_USE, 1.0f, 1.0f);
                setStatusCircleDisenchant();
            } else {
                itemMeta.addEnchant(enchantment, enchantment.getMaxLevel(), false);
                item.setItemMeta(itemMeta);
                player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1.0f, 1.0f);
                setStatusCircleEnchant();
            }
            fillEnchantments(item);

            Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), this::setStatusCircleSuccess, 30);

            inventory.setItem(toChestIndex(1, 1), item);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        if (event.getClick().isShiftClick()) {
            event.setCancelled(true);
            return;
        }
        if (event.getRawSlot() >= event.getInventory().getSize()) return;
        if (!(event.getInventory().equals(inventory))) return;

        if (
                isToolOrWeapon(event.getCurrentItem()) &&
                        event.getCursor().getType().equals(Material.AIR)||
                        event.getCurrentItem() == null &&
                                isToolOrWeapon(event.getCursor()) && event.getRawSlot() == toChestIndex(1, 1))
        {
            if (event.getCurrentItem() != null) {
                clearEnchantments();
                setStatusCircleDefault();
            } else {
                fillEnchantments(event.getCursor());
                setStatusCircleSuccess();
            }
        }
        else {
            if (event.getCursor().getType().equals(Material.AIR) &&
                    event.getCurrentItem() != null &&
                    (
                            event.getCurrentItem().getType().equals(Material.ENCHANTED_BOOK) ||
                                    (
                                            event.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE) &&
                                                    event.getCurrentItem().hasItemMeta() &&
                                                    event.getCurrentItem().getItemMeta().hasDisplayName() &&
                                                    event.getCurrentItem().getItemMeta().displayName().equals(Component.text("Already used enchantment!")
                                                            .color(TextColor.color(255, 0, 0))
                                                            .decorate(TextDecoration.BOLD))
                                    )
                    )
            ) {
                setEnchantment(event.getInventory().getItem(toChestIndex(1, 1)), event.getCurrentItem());
            }
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (!(event.getInventory().equals(inventory))) return;

        if (event.getInventory().getItem(toChestIndex(1, 1)) != null && !(event.getInventory().getItem(toChestIndex(1, 1)).getType().equals(Material.AIR))) {
            player.getInventory().addItem(event.getInventory().getItem(toChestIndex(1, 1)));
        }
    }

}
