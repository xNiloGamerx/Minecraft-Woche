package com.nilo.testPlugin.tags;

import org.bukkit.entity.Player;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PlayerTagManager {
    private static final HashMap<UUID, HashMap<String, Tag>> playerTags = new HashMap<UUID, HashMap<String, Tag>>();

    public void addPlayer(Player player, List<Tag> tags) {
        HashMap<String, Tag> tagMap = new HashMap<String, Tag>();
        for (Tag tag : tags) {
            tagMap.put(tag.getId(), tag);
        }
        playerTags.put(player.getUniqueId(), tagMap);
    }

    public static List<Tag> getTags(Player player) {
        return playerTags.get(player.getUniqueId()).values().stream().toList();
    }

    public static Tag getTag(Player player, String id) {
        return playerTags.get(player.getUniqueId()).get(id);
    }
}
