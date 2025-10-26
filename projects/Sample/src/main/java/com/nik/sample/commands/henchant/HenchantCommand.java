package com.nik.sample.commands.henchant;

import com.nik.sample.Main;
import com.nik.sample.henchant.HenchantGui;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

public class HenchantCommand implements CommandExecutor {
    private MiniMessage mm = MiniMessage.miniMessage();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) return false;

        if (!(player.getGameMode().equals(GameMode.CREATIVE))) {
            player.sendMessage(mm.deserialize("[<gradient:#A02EF7:#6B00FF>Henchant</gradient>] <color:red>The Henchant Command can only be used in Creative Mode!</color>"));
            return false;
        }

        HenchantGui henchantGui = new HenchantGui(player);

        PluginManager pluginManager = Main.getPlugin(Main.class).getServer().getPluginManager();
        pluginManager.registerEvents(henchantGui, Main.getPlugin(Main.class));

        henchantGui.openInventory();

        return false;
    }
}
