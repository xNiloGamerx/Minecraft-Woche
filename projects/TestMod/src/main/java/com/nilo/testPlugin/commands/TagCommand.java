package com.nilo.testPlugin.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.nilo.testPlugin.tags.TagManager;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;

public class TagCommand {
    public static LiteralCommandNode<CommandSourceStack> getCommand() {
        return Commands.literal("tag")
                .then(Commands.literal("add"))
                .then(
                        Commands.argument("tagId", StringArgumentType.word())
                                .suggests((ctx, builder) -> {
                                    TagManager.getTags()
                                            .forEach((tag) -> builder.suggest(tag.getId()));
                                    return builder.buildFuture();
                                })
                )
                .build();
    }
}
