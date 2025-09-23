package com.nik.sample;

import com.nik.sample.commands.InvCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sample extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("inv").setExecutor(new InvCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
