package io.papermc.paper.api.command.cloud.commandframework.paper.parser;

import cloud.commandframework.ArgumentDescription;
import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.arguments.parser.ArgumentParseResult;
import cloud.commandframework.arguments.parser.ArgumentParser;
import cloud.commandframework.captions.CaptionVariable;
import cloud.commandframework.context.CommandContext;
import cloud.commandframework.exceptions.parsing.NoInputProvidedException;
import cloud.commandframework.exceptions.parsing.ParserException;
import io.papermc.paper.api.Paper;
import io.papermc.paper.api.command.cloud.commandframework.paper.PaperCaptionKeys;
import io.papermc.paper.api.world.World;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.Queue;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * cloud argument type that parses Bukkit {@link World worlds}
 *
 * @param <C> Command sender type
 */
public class WorldArgument<C> extends CommandArgument<C, World> {

    protected WorldArgument(
            final boolean required,
            final @NonNull String name,
            final @NonNull String defaultValue,
            final @Nullable BiFunction<CommandContext<C>, String, List<String>> suggestionsProvider,
            final @NonNull ArgumentDescription defaultDescription
    ) {
        super(required, name, new WorldParser<>(), defaultValue, World.class, suggestionsProvider, defaultDescription);
    }

    /**
     * Create a new {@link Builder}.
     *
     * @param name argument name
     * @param <C>  sender type
     * @return new {@link Builder}
     * @since 1.8.0
     */
    @API(status = API.Status.STABLE, since = "1.8.0")
    public static <C> @NonNull Builder<C> builder(final @NonNull String name) {
        return new Builder<>(name);
    }

    /**
     * Create a new builder
     *
     * @param name Name of the argument
     * @param <C>  Command sender type
     * @return Created builder
     * @deprecated prefer {@link #builder(String)}
     */
    @API(status = API.Status.DEPRECATED, since = "1.8.0")
    @Deprecated
    public static <C> @NonNull Builder<C> newBuilder(final @NonNull String name) {
        return builder(name);
    }

    /**
     * Create a new required argument
     *
     * @param name Argument name
     * @param <C>  Command sender type
     * @return Created argument
     */
    public static <C> @NonNull CommandArgument<C, World> of(final @NonNull String name) {
        return WorldArgument.<C>builder(name).asRequired().build();
    }

    /**
     * Create a new optional argument
     *
     * @param name Argument name
     * @param <C>  Command sender type
     * @return Created argument
     */
    public static <C> @NonNull CommandArgument<C, World> optional(final @NonNull String name) {
        return WorldArgument.<C>builder(name).asOptional().build();
    }

    /**
     * Create a new optional argument with a default value
     *
     * @param name         Argument name
     * @param defaultValue Default value
     * @param <C>          Command sender type
     * @return Created argument
     */
    public static <C> @NonNull CommandArgument<C, World> optional(
            final @NonNull String name,
            final @NonNull String defaultValue
    ) {
        return WorldArgument.<C>builder(name).asOptionalWithDefault(defaultValue).build();
    }


    public static final class Builder<C> extends CommandArgument.Builder<C, World> {

        private Builder(final @NonNull String name) {
            super(World.class, name);
        }

        @Override
        public @NonNull CommandArgument<C, World> build() {
            return new WorldArgument<>(
                    this.isRequired(),
                    this.getName(),
                    this.getDefaultValue(),
                    this.getSuggestionsProvider(),
                    this.getDefaultDescription()
            );
        }
    }


    public static final class WorldParser<C> implements ArgumentParser<C, World> {

        @Override
        public @NonNull ArgumentParseResult<World> parse(
                final @NonNull CommandContext<C> commandContext,
                final @NonNull Queue<String> inputQueue
        ) {
            final String input = inputQueue.peek();
            if (input == null) {
                return ArgumentParseResult.failure(new NoInputProvidedException(
                        WorldParser.class,
                        commandContext
                ));
            }

            final World world = Paper.getWorld(input);
            if (world == null) {
                return ArgumentParseResult.failure(new WorldParseException(input, commandContext));
            }

            inputQueue.remove();
            return ArgumentParseResult.success(world);
        }

        @Override
        public @NonNull List<String> suggestions(final @NonNull CommandContext<C> commandContext, final @NonNull String input) {
            return Paper.getWorlds().stream().map(World::getName).collect(Collectors.toList());
        }
    }


    public static final class WorldParseException extends ParserException {

        private static final long serialVersionUID = 561648144491587450L;
        private final String input;

        /**
         * Construct a new WorldParseException
         *
         * @param input   Input
         * @param context Command context
         */
        public WorldParseException(
                final @NonNull String input,
                final @NonNull CommandContext<?> context
        ) {
            super(
                    WorldParser.class,
                    context,
                    PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_WORLD,
                    CaptionVariable.of("input", input)
            );
            this.input = input;
        }

        /**
         * Get the input provided by the sender
         *
         * @return Input
         */
        public @NonNull String getInput() {
            return this.input;
        }
    }
}

