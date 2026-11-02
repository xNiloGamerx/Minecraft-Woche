package com.nilo.bontoPlugin.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.nilo.bontoPlugin.Main;
import com.nilo.bontoPlugin.gui.KontoGui;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class KontoCommand {
    public static LiteralCommandNode<CommandSourceStack> get() {
        return Commands.literal("konto")
                .then(
                        Commands.literal("gui")
                                .executes(context -> {
                                    CommandSender sender = context.getSource().getSender();
                                    Entity executor = context.getSource().getExecutor();

                                    if (!(executor instanceof Player player)) {
                                        return Command.SINGLE_SUCCESS;
                                    }

                                    KontoGui kontoGui = new KontoGui(Main.getPlugin(Main.class));
                                    player.openInventory(kontoGui.getInventory());

                                    return Command.SINGLE_SUCCESS;
                                })
                )
                .build();
    }
}
