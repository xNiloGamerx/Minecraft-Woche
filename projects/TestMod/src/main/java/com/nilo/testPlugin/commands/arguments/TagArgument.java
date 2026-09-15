package com.nilo.testPlugin.commands.arguments;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.nilo.testPlugin.tags.Tag;
import com.nilo.testPlugin.tags.TagManager;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.MessageComponentSerializer;
import io.papermc.paper.command.brigadier.argument.CustomArgumentType;
import net.kyori.adventure.text.Component;
import org.jspecify.annotations.NonNull;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public final class TagArgument implements CustomArgumentType<Tag, String> {
    private static final SimpleCommandExceptionType ERROR_BAD_SOURCE = new SimpleCommandExceptionType(
            MessageComponentSerializer.message().serialize(Component.text("The source needs to be a CommandSourceStack!"))
    );

    private static final SimpleCommandExceptionType ERROR_WRONG_ID = new SimpleCommandExceptionType(
            MessageComponentSerializer.message().serialize(Component.text("This id does not exist as a tag"))
    );

    @Override
    public @NonNull Tag parse(@NonNull StringReader reader) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S> @NonNull Tag parse(@NonNull StringReader reader, @NonNull S source) throws CommandSyntaxException {
        if (!(source instanceof CommandSourceStack stack)) {
            throw ERROR_BAD_SOURCE.create();
        }

        final Tag tag = TagManager.getTag(getNativeType().parse(reader));
        if (tag == null) {
            throw ERROR_WRONG_ID.create();
        }

        return tag;
    }

    @Override
    public @NonNull ArgumentType<String> getNativeType() {
        return StringArgumentType.word();
    }

    @Override
    public <S> @NonNull CompletableFuture<Suggestions> listSuggestions(@NonNull CommandContext<S> ctx, SuggestionsBuilder builder) {
        TagManager.getTags()
                .stream().filter(tag -> tag.getId().toLowerCase(Locale.ROOT).startsWith(builder.getRemainingLowerCase()))
                .forEach((tag) -> builder.suggest(tag.getId()));
        return builder.buildFuture();
    }
}
