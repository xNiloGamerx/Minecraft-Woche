package com.nik.sample.commands.henchant;

import com.nik.sample.Main;
import com.nik.sample.henchant.HenchantGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

public class HenchantCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) return false;

        HenchantGui henchantGui = new HenchantGui(player);

        PluginManager pluginManager = Main.getPlugin(Main.class).getServer().getPluginManager();
        pluginManager.registerEvents(henchantGui, Main.getPlugin(Main.class));

        henchantGui.openInventory();

        return false;
    }
}
