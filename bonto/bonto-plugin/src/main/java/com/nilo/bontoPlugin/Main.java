package com.nilo.bontoPlugin;

import com.nilo.bontoPlugin.command.KontoCommand;
import com.nilo.bontoPlugin.konto.KontoManager;
import com.nilo.bontoPlugin.listener.KontoGuiListener;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        KontoManager.init();

        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new KontoGuiListener(), this);

        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            event.registrar().register(KontoCommand.get());
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
