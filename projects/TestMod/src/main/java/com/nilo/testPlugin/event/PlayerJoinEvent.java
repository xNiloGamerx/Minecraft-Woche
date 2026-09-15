package com.nilo.testPlugin.event;

import com.nilo.testPlugin.tags.PlayerTagManager;
import com.nilo.testPlugin.tags.Tag;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import net.kyori.adventure.text.TextComponent;

public class PlayerJoinEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();
        TextComponent.Builder name = Component.text();
        for (Tag tag : PlayerTagManager.getTags(player)) {
            name.append(tag.getComponent());
        }
        name.appendSpace().append(player.name());

        player.playerListName(name.build());
    }
}
