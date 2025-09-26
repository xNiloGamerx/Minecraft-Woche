package com.nik.sample;

import com.nik.sample.commands.InvCommand;
import com.nik.sample.commands.hat.HatCommand;
import com.nik.sample.lockchest.LockChestManager;
import com.nik.sample.lockchest.commands.LockCommand;
import com.nik.sample.lockchest.commands.UnlockCommand;
import com.nik.sample.lockchest.listener.BreakBlockListener;
import com.nik.sample.lockchest.listener.OpenChestListener;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private Component prefix;
    TextColor normalTextColor;
    TextColor commentTextColor;
    TextColor successColor;
    TextColor errorColor;
    private MiniMessage mm = MiniMessage.miniMessage();

    private LockChestManager lockChestManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        prefix = mm.deserialize("<gradient:#FF5F6D:#FFC371>[Sample]</gradient>" + " ");
        normalTextColor = TextColor.color(255, 245, 225);
        commentTextColor = TextColor.color(122, 90, 77);
        successColor = TextColor.color(107, 164, 94);
        errorColor = TextColor.color(224, 78, 57);

        PluginManager pluginManager = this.getServer().getPluginManager();

        InvCommand invCommand = new InvCommand();
        this.getCommand("inv").setExecutor(invCommand);
        pluginManager.registerEvents(invCommand, this);

        // Hat
        this.getCommand("hat").setExecutor(new HatCommand());

        // Lock Chest
        lockChestManager = new LockChestManager();
        this.getCommand("lock").setExecutor(new LockCommand());
        this.getCommand("unlock").setExecutor(new UnlockCommand());
        pluginManager.registerEvents(new OpenChestListener(), this);
        pluginManager.registerEvents(new BreakBlockListener(), this);
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

    public TextColor getNormalTextColor() {
        return normalTextColor;
    }

    public TextColor getCommentTextColor() {
        return commentTextColor;
    }

    public TextColor getSuccessColor() {
        return successColor;
    }

    public TextColor getErrorColor() {
        return errorColor;
    }

    public LockChestManager getLockChestManager() {
        return lockChestManager;
    }
}
