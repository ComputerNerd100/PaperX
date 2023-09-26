package io.papermc.paper.api.command.cloud.commandframework.paper.parser.selector;

import cloud.commandframework.ArgumentDescription;
import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.arguments.parser.ArgumentParseResult;
import cloud.commandframework.context.CommandContext;
import com.google.common.collect.ImmutableList;
import io.papermc.paper.api.Paper;
import io.papermc.paper.api.command.cloud.commandframework.paper.arguments.selector.MultiplePlayerSelector;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.PlayerArgument;
import io.papermc.paper.api.entity.Player;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiFunction;

/**
 * Argument type for parsing {@link MultiplePlayerSelector}. On Minecraft 1.13+
 * this argument uses Minecraft's built-in entity selector argument for parsing
 * and suggestions. On prior versions, this argument behaves similarly to
 * {@link PlayerArgument}.
 *
 * @param <C> sender type
 */
public final class MultiplePlayerSelectorArgument<C> extends CommandArgument<C, MultiplePlayerSelector> {

    private MultiplePlayerSelectorArgument(
            final boolean allowEmpty,
            final boolean required,
            final @NonNull String name,
            final @NonNull String defaultValue,
            final @Nullable BiFunction<@NonNull CommandContext<C>, @NonNull String,
                    @NonNull List<@NonNull String>> suggestionsProvider,
            final @NonNull ArgumentDescription defaultDescription
    ) {
        super(required, name, new MultiplePlayerSelectorParser<>(allowEmpty), defaultValue, MultiplePlayerSelector.class,
                suggestionsProvider, defaultDescription
        );
    }

    /**
     * Create a new {@link Builder}.
     *
     * @param name argument name
     * @param <C>  sender type
     * @return new builder
     * @since 1.8.0
     */
    @API(status = API.Status.STABLE, since = "1.8.0")
    public static <C> @NonNull Builder<C> builder(final @NonNull String name) {
        return new Builder<>(name);
    }

    /**
     * Create a new required command argument
     *
     * @param name Argument name
     * @param <C>  Command sender type
     * @return Created argument
     */
    public static <C> @NonNull MultiplePlayerSelectorArgument<C> of(final @NonNull String name) {
        return MultiplePlayerSelectorArgument.<C>builder(name).asRequired().build();
    }

    /**
     * Create a new optional command argument
     *
     * @param name Argument name
     * @param <C>  Command sender type
     * @return Created argument
     */
    public static <C> @NonNull MultiplePlayerSelectorArgument<C> optional(final @NonNull String name) {
        return MultiplePlayerSelectorArgument.<C>builder(name).asOptional().build();
    }

    /**
     * Create a new required command argument with a default value
     *
     * @param name                  Argument name
     * @param defaultEntitySelector Default player
     * @param <C>                   Command sender type
     * @return Created argument
     */
    public static <C> @NonNull MultiplePlayerSelectorArgument<C> optional(
            final @NonNull String name,
            final @NonNull String defaultEntitySelector
    ) {
        return MultiplePlayerSelectorArgument.<C>builder(name).asOptionalWithDefault(defaultEntitySelector).build();
    }


    public static final class Builder<C> extends CommandArgument.TypedBuilder<C, MultiplePlayerSelector, Builder<C>> {

        private boolean allowEmpty = true;

        private Builder(final @NonNull String name) {
            super(MultiplePlayerSelector.class, name);
        }

        /**
         * Set whether to allow empty results.
         *
         * @param allowEmpty whether to allow empty results
         * @return builder instance
         * @since 1.8.0
         */
        @API(status = API.Status.STABLE, since = "1.8.0")
        public @NonNull Builder<C> allowEmpty(final boolean allowEmpty) {
            this.allowEmpty = allowEmpty;
            return this;
        }

        /**
         * Builder a new argument
         *
         * @return Constructed argument
         */
        @Override
        public @NonNull MultiplePlayerSelectorArgument<C> build() {
            return new MultiplePlayerSelectorArgument<>(
                    this.allowEmpty,
                    this.isRequired(),
                    this.getName(),
                    this.getDefaultValue(),
                    this.getSuggestionsProvider(),
                    this.getDefaultDescription()
            );
        }
    }


    public static final class MultiplePlayerSelectorParser<C> extends SelectorUtils.PlayerSelectorParser<C, MultiplePlayerSelector> {

        private final boolean allowEmpty;

        /**
         * Creates a new {@link MultiplePlayerSelectorParser}.
         *
         * @param allowEmpty Whether to allow an empty result
         * @since 1.8.0
         */
        @API(status = API.Status.STABLE, since = "1.8.0")
        public MultiplePlayerSelectorParser(final boolean allowEmpty) {
            super(false);
            this.allowEmpty = allowEmpty;
        }

        /**
         * Creates a new {@link MultiplePlayerSelectorParser}.
         */
        public MultiplePlayerSelectorParser() {
            this(true);
        }

        @Override
        public MultiplePlayerSelector mapResult(
                final @NonNull String input,
                final SelectorUtils.@NonNull EntitySelectorWrapper wrapper
        ) {
            final List<Player> players = wrapper.players();
            if (players.isEmpty() && !this.allowEmpty) {
                new Thrower(NO_PLAYERS_EXCEPTION_TYPE.get()).throwIt();
            }
            return new MultiplePlayerSelector(input, new ArrayList<>(players));
        }

        @Override
        protected @NonNull ArgumentParseResult<MultiplePlayerSelector> legacyParse(
                final @NonNull CommandContext<C> commandContext,
                final @NonNull Queue<@NonNull String> inputQueue
        ) {
            final String input = inputQueue.peek();
            @SuppressWarnings("deprecation") final @Nullable Player player = Paper.getPlayer(input);

            if (player == null) {
                return ArgumentParseResult.failure(new PlayerArgument.PlayerParseException(input, commandContext));
            }
            inputQueue.remove();
            return ArgumentParseResult.success(new MultiplePlayerSelector(input, ImmutableList.of(player)));
        }
    }
}

