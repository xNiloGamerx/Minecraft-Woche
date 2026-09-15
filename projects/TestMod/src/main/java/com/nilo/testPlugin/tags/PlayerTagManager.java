package com.nilo.testPlugin.tags;

import com.nilo.testPlugin.Main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PlayerTagManager {
    private static final HashMap<UUID, HashMap<String, Tag>> playerTags = new HashMap<UUID, HashMap<String, Tag>>();
    private static final FileConfiguration config = Main.getInstance().getConfig();

    public static void initialize() {
        load();
        reloadAllTags();
    }

    public static void addPlayer(Player player, List<Tag> tags) {
        HashMap<String, Tag> tagMap = new HashMap<String, Tag>();
        for (Tag tag : tags) {
            tagMap.put(tag.getId(), tag);
        }
        playerTags.put(player.getUniqueId(), tagMap);

        reloadTags(player);
    }

    public static void addTag(Player player, Tag tag) {
        if (!playerTags.containsKey(player.getUniqueId())) playerTags.put(player.getUniqueId(), new HashMap<>());

        HashMap<String, Tag> tagMap = playerTags.get(player.getUniqueId());
        tagMap.put(tag.getId(), tag);

        reloadTags(player);
    }

    public static void removeTag(Player player, Tag tag) {
        if (!playerTags.containsKey(player.getUniqueId())) return;

        HashMap<String, Tag> tagMap = playerTags.get(player.getUniqueId());
        tagMap.remove(tag.getId());

        reloadTags(player);
    }

    public static List<Tag> getTags(Player player) {
        return playerTags.get(player.getUniqueId()).values().stream().toList();
    }

    public static Tag getTag(Player player, String id) {
        return playerTags.get(player.getUniqueId()).get(id);
    }

    public static void reloadAllTags() {
        Bukkit.getOnlinePlayers().forEach(PlayerTagManager::reloadTags);
    }

    public static void reloadTags(Player player) {
        if (!playerTags.containsKey(player.getUniqueId())) return;

        TextComponent.Builder name = Component.text();
        for (Tag tag : PlayerTagManager.getTags(player)) {
            name.append(tag.getComponent());
        }
        name.appendSpace().append(player.name());

        player.playerListName(name.build());
        player.displayName(name.build());

        save();
    }

    public static void load() {
        ConfigurationSection section = config.getConfigurationSection("player-tags");

        if (section == null) {
            return;
        }

        playerTags.clear();

        for (String uuidString : section.getKeys(false)) {
            UUID uuid = UUID.fromString(uuidString);

            Map<String, Object> tags = section.getConfigurationSection(uuidString)
                    .getValues(false);

            HashMap<String, Tag> playerTagMap = new HashMap<>();

            for (Map.Entry<String, Object> entry : tags.entrySet()) {
                playerTagMap.put(entry.getKey(), (Tag) entry.getValue());
            }

            playerTags.put(uuid, playerTagMap);
        }
    }

    public static void save() {
        Map<String, Object> configMap = new HashMap<>();

        for (Map.Entry<UUID, HashMap<String, Tag>> entry : playerTags.entrySet()) {
            configMap.put(entry.getKey().toString(), entry.getValue());
        }

        config.set("player-tags", configMap);
    }
}
