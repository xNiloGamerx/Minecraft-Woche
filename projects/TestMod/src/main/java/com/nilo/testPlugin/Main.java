package com.nilo.testPlugin;

import com.nilo.testPlugin.commands.FontCommand;
import com.nilo.testPlugin.commands.TagCommand;
import com.nilo.testPlugin.commands.TestCommand;
import com.nilo.testPlugin.event.ChestGuiInventoryClickEvent;
import com.nilo.testPlugin.tags.TagManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        TagManager.initializeTags();

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ChestGuiInventoryClickEvent(), this);

        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            commands.registrar().register(TestCommand.getCommand());
            commands.registrar().register(FontCommand.getCommand());
            commands.registrar().register(TagCommand.getCommand());
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
