package com.nilo.testPlugin;

import com.nilo.testPlugin.commands.TestCommand;
import com.nilo.testPlugin.event.ChestGuiInventoryClickEvent;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ChestGuiInventoryClickEvent(), this);

        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            commands.registrar().register(TestCommand.getCommand());
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
