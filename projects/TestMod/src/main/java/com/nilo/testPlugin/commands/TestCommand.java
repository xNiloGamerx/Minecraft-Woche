package com.nilo.testPlugin.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.nilo.testPlugin.Main;
import com.nilo.testPlugin.gui.ChestGui;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class TestCommand {
    public static LiteralCommandNode<CommandSourceStack> getCommand() {
        return Commands.literal("testcommand")
                .then(Commands.literal("test1")
                        .executes(ctx -> {
                            CommandSender sender = ctx.getSource().getSender();
                            Entity executor = ctx.getSource().getExecutor();

                            if (!(sender instanceof Player player) || sender != executor) {
                                return Command.SINGLE_SUCCESS;
                            }

                            ChestGui gui = new ChestGui(Main.getPlugin(Main.class), Component.text("ChestGui", NamedTextColor.DARK_RED));
                            player.openInventory(gui.getInventory());

                            return Command.SINGLE_SUCCESS;
                        })
                )
                .then(Commands.literal("test2")
                        .executes(ctx -> TestCommand.runTestLogic(ctx, "Test 2"))
                )
                .build();
    }

    public static int runTestLogic(CommandContext<CommandSourceStack> ctx, String testName) {
        CommandSender sender = ctx.getSource().getSender();
        Entity executor = ctx.getSource().getExecutor();

        if (!(executor instanceof Player player)) {
            sender.sendMessage(Component.text("Only players can execute this command!"));
            return Command.SINGLE_SUCCESS;
        }

        if (sender == executor) {
            player.sendMessage(Component.text("Du hast " + testName + " ausgeführt!", Style.style(TextColor.color(0, 255, 0))));
            return Command.SINGLE_SUCCESS;
        }

        player.sendMessage(Component.text("Für dich wurde " + testName + " ausgeführt!", Style.style(TextColor.color(0, 255, 0))));
        sender.sendRichMessage(Component.text("Du hast " + testName + " für <playername> ausgeführt!", Style.style(TextColor.color(0, 255, 0))).toString(), Placeholder.component("playername", player.name()));
        return Command.SINGLE_SUCCESS;
    }
}
