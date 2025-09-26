package com.nik.sample.lockchest.listener;

import com.nik.sample.Main;
import com.nik.sample.lockchest.LockChestManager;
import com.nik.sample.lockchest.Lockchest;
import com.nik.sample.utils.HashUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.bukkit.conversations.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class OpenChestListener implements Listener {
    private final Set<UUID> inConversation = new HashSet<>();

    @EventHandler(ignoreCancelled = true)
    public void onInventoryOpen(InventoryOpenEvent event) {
        Plugin plugin = Main.getPlugin(Main.class);
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getPlayer();

        if (!(inventory.getHolder() instanceof Chest chest)) return;

        Location chestLocation = chest.getLocation();
        LockChestManager lockChestManager = Main.getInstance().getLockChestManager();
        Lockchest lockchest = lockChestManager.getLockchest(chestLocation);

        if (lockchest != null && lockchest.isLocked()) {
            if (!(inConversation.contains(player.getUniqueId()))) {
                event.setCancelled(true);

                ConversationFactory factory = new ConversationFactory(plugin);
                Conversation convo = factory.withEscapeSequence("exit").withTimeout(10).thatExcludesNonPlayersWithMessage("")
                        .withFirstPrompt(new StringPrompt() {
                            @Override
                            public @NotNull String getPromptText(ConversationContext context) {
                                Bukkit.getScheduler().runTask(plugin, () -> {
                                    player.sendMessage(Main.getInstance().getPrefix()
                                            .append(
                                                    Component.text("Enter password: ")
                                                            .color(Main.getInstance().getNormalTextColor())
                                                            .append(
                                                                    Component.text("(Expires in 10 seconds)")
                                                                            .color(Main.getInstance().getCommentTextColor())
                                                            )));
                                });
                                return "";
                            }

                            @Override
                            public Prompt acceptInput(ConversationContext context, String passwordInput) {
                                String passwordHash = HashUtils.sha256Base64(passwordInput);
                                boolean unlocked = lockChestManager.isRightPassword(chestLocation, passwordHash);

                                if (unlocked) {
                                    inConversation.add(player.getUniqueId());

                                    Bukkit.getScheduler().runTask(plugin, () -> {
                                        player.openInventory(inventory);

                                        player.sendMessage(
                                                Main.getInstance().getPrefix()
                                                        .append(
                                                                Component.text("Unlocked Chest only for you and only this time!")
                                                                        .color(
                                                                                Main.getInstance().getSuccessColor()
                                                                        )));

                                        inConversation.remove(player.getUniqueId());
                                    });
                                } else {
                                    Bukkit.getScheduler().runTask(plugin, () -> {
                                        player.sendMessage(
                                                Main.getInstance().getPrefix()
                                                        .append(
                                                                Component.text("Wrong password!")
                                                                        .color(
                                                                                Main.getInstance().getErrorColor()
                                                                        )));

                                        event.setCancelled(true);
                                    });
                                }

                                return Prompt.END_OF_CONVERSATION;
                            }
                        })
                        .buildConversation(player);

                convo.begin();
            }
        }
    }

}
