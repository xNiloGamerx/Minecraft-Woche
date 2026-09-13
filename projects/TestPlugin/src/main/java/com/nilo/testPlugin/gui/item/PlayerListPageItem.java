package com.nilo.testPlugin.gui.item;

import com.nilo.testPlugin.gui.ChestGui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerListPageItem extends ListPageItem {
    public PlayerListPageItem(ChestGui chestGui, List<Player> players, int start, int width, int height) {
        List<ItemStack> playerHeads = new ArrayList<>();
        for (Player player : players) {
            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) head.getItemMeta();
            meta.setPlayerProfile(player.getPlayerProfile());
            head.setItemMeta(meta);
            playerHeads.add(head);
        }

        super(chestGui, playerHeads, start, width, height);
    }
}
