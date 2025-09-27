package com.nik.sample.lockchest.commands;

import com.nik.sample.Main;
import com.nik.sample.lockchest.LockChestManager;
import com.nik.sample.utils.HashUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LockCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) return false;

        if (args.length != 1) {
            player.sendMessage(
                    Main.getInstance().getPrefix()
                            .append(
                                    Component.text("You need to specify a password!")
                                            .color(
                                                    Main.getInstance().getErrorColor()
                                            )));
            return false;
        }

        LockChestManager lockChestManager = Main.getInstance().getLockChestManager();

        Block playerTargetBlock = player.getTargetBlockExact(5);
        if (playerTargetBlock == null) return false;

        Location location = playerTargetBlock.getLocation();
        if (lockChestManager.isChestLocked(location)) {
            player.sendMessage(
                    Main.getInstance().getPrefix()
                            .append(
                                    Component.text("Chest is already locked!")
                                            .color(
                                                    Main.getInstance().getErrorColor()
                                            )));
            return false;
        }

        String passwordHash = HashUtils.sha256Base64(args[0]);

        lockChestManager.addLockChest(location, passwordHash, player.getUniqueId());

        player.sendMessage(
                Main.getInstance().getPrefix()
                        .append(
                                Component.text("Locked Chest!")
                                        .color(
                                                Main.getInstance().getSuccessColor()
                                        )));

        return false;
    }
}
