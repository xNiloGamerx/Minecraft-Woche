package com.nilo.testPlugin.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.nilo.testPlugin.commands.arguments.TagArgument;
import com.nilo.testPlugin.tags.PlayerTagManager;
import com.nilo.testPlugin.tags.Tag;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class TagCommand {
    public static LiteralCommandNode<CommandSourceStack> getCommand() {
        return Commands.literal("ntag")
                .then(
                    Commands.literal("add")
                        .then(
                                Commands.argument("tagId", new TagArgument())
                                        .executes(ctx -> {
                                            CommandSender sender = ctx.getSource().getSender();
                                            Entity executor = ctx.getSource().getExecutor();
                                            if (!(sender instanceof Player player) || !(executor instanceof Player)) return Command.SINGLE_SUCCESS;

                                            Tag tag = ctx.getArgument("tagId", Tag.class);
                                            PlayerTagManager.addTag(player, tag);

                                            if (sender == executor) {
                                                player.sendMessage(
                                                        Component.text("Tag '").color(TextColor.color(0, 255, 0))
                                                                .append(tag.getComponent().color(TextColor.color(255, 255, 255)))
                                                                .append(Component.text("' added successfully!").color(TextColor.color(0, 255, 0)))
                                                );
                                                return Command.SINGLE_SUCCESS;
                                            }

                                            sender.sendMessage(
                                                    Component.text("Added Tag '").color(TextColor.color(0, 255, 0))
                                                            .append(tag.getComponent().color(TextColor.color(255, 255, 255)))
                                                            .append(Component.text("' for " + executor.getName() + " successfully!").color(TextColor.color(0, 255, 0)))
                                            );
                                            executor.sendMessage(
                                                    Component.text("Tag '").color(TextColor.color(0, 255, 0))
                                                            .append(tag.getComponent().color(TextColor.color(255, 255, 255)))
                                                            .append(Component.text("' added successfully!").color(TextColor.color(0, 255, 0)))
                                            );

                                            return Command.SINGLE_SUCCESS;
                                        })
                        )
                )
                .then(Commands.literal("remove")
                        .then(
                                Commands.argument("tagId", new TagArgument())
                                        .executes(ctx -> {
                                            CommandSender sender = ctx.getSource().getSender();
                                            Entity executor = ctx.getSource().getExecutor();
                                            if (!(sender instanceof Player player) || !(executor instanceof Player)) return Command.SINGLE_SUCCESS;

                                            Tag tag = ctx.getArgument("tagId", Tag.class);
                                            PlayerTagManager.removeTag(player, tag);

                                            if (sender == executor) {
                                                player.sendMessage(
                                                        Component.text("Tag '").color(TextColor.color(0, 255, 0))
                                                                .append(tag.getComponent().color(TextColor.color(255, 255, 255)))
                                                                .append(Component.text("' removed successfully!").color(TextColor.color(0, 255, 0)))
                                                );
                                                return Command.SINGLE_SUCCESS;
                                            }

                                            sender.sendMessage(
                                                    Component.text("Removed Tag '").color(TextColor.color(0, 255, 0))
                                                            .append(tag.getComponent().color(TextColor.color(255, 255, 255)))
                                                            .append(Component.text("' for " + executor.getName() + " successfully!").color(TextColor.color(0, 255, 0)))
                                            );
                                            executor.sendMessage(
                                                    Component.text("Tag '").color(TextColor.color(0, 255, 0))
                                                            .append(tag.getComponent().color(TextColor.color(255, 255, 255)))
                                                            .append(Component.text("' removed successfully!").color(TextColor.color(0, 255, 0)))
                                            );

                                            return Command.SINGLE_SUCCESS;
                                        })
                        )
                )
                .build();
    }
}
