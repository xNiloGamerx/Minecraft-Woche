package com.nik.sample.lockchest.commands;

import com.nik.sample.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SaveConfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) return false;

        Main.getInstance().getLockChestManager().saveChests();
        Main.getInstance().getConfiguration().save();

        player.sendMessage(
                Main.getInstance().getPrefix()
                        .append(
                                Component.text("Saved config!")
                                        .color(Main.getInstance().getNormalTextColor())
                        ));

        return false;
    }
}
