package com.nik.sample;

import com.nik.sample.commands.InvCommand;
import com.nik.sample.commands.hat.HatCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private Component prefix;
    private MiniMessage mm = MiniMessage.miniMessage();

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        prefix = mm.deserialize("<gradient:#1d7001:#258f01:#52c234>[Sample]</gradient>" + " ");

        PluginManager pluginManager = this.getServer().getPluginManager();

        InvCommand invCommand = new InvCommand();
        this.getCommand("inv").setExecutor(invCommand);
        pluginManager.registerEvents(invCommand, this);

        this.getCommand("hat").setExecutor(new HatCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }

    public MiniMessage getMiniMessage() {
        return mm;
    }

    public Component getPrefix() {
        return prefix;
    }
}
