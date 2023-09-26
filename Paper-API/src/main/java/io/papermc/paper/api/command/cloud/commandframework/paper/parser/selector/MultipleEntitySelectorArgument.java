package io.papermc.paper.api.command.cloud.commandframework.paper.parser.selector;

import cloud.commandframework.ArgumentDescription;
import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.context.CommandContext;
import io.papermc.paper.api.command.cloud.commandframework.paper.arguments.selector.MultipleEntitySelector;
import io.papermc.paper.api.entity.Entity;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.function.BiFunction;

/**
 * Argument type for parsing {@link MultipleEntitySelector}. On Minecraft 1.13+
 * this argument uses Minecraft's built-in entity selector argument for parsing
 * and suggestions. On prior versions, this argument will suggest nothing and
 * always fail parsing with {@link SelectorParseException.FailureReason#UNSUPPORTED_VERSION}.
 *
 * @param <C> sender type
 */
public final class MultipleEntitySelectorArgument<C> extends CommandArgument<C, MultipleEntitySelector> {

    private MultipleEntitySelectorArgument(
            final boolean allowEmpty,
            final boolean required,
            final @NonNull String name,
            final @NonNull String defaultValue,
            final @Nullable BiFunction<@NonNull CommandContext<C>, @NonNull String,
                    @NonNull List<@NonNull String>> suggestionsProvider,
            final @NonNull ArgumentDescription defaultDescription
    ) {
        super(required, name, new MultipleEntitySelectorParser<>(allowEmpty), defaultValue,
                MultipleEntitySelector.class, suggestionsProvider, defaultDescription
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
    public static <C> @NonNull MultipleEntitySelectorArgument<C> of(final @NonNull String name) {
        return MultipleEntitySelectorArgument.<C>builder(name).asRequired().build();
    }

    /**
     * Create a new optional command argument
     *
     * @param name Argument name
     * @param <C>  Command sender type
     * @return Created argument
     */
    public static <C> @NonNull MultipleEntitySelectorArgument<C> optional(final @NonNull String name) {
        return MultipleEntitySelectorArgument.<C>builder(name).asOptional().build();
    }

    /**
     * Create a new required command argument with a default value
     *
     * @param name                  Argument name
     * @param defaultEntitySelector Default player
     * @param <C>                   Command sender type
     * @return Created argument
     */
    public static <C> @NonNull MultipleEntitySelectorArgument<C> optional(
            final @NonNull String name,
            final @NonNull String defaultEntitySelector
    ) {
        return MultipleEntitySelectorArgument.<C>builder(name).asOptionalWithDefault(defaultEntitySelector).build();
    }


    public static final class Builder<C> extends CommandArgument.TypedBuilder<C, MultipleEntitySelector, Builder<C>> {

        private boolean allowEmpty = true;

        private Builder(final @NonNull String name) {
            super(MultipleEntitySelector.class, name);
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
        public @NonNull MultipleEntitySelectorArgument<C> build() {
            return new MultipleEntitySelectorArgument<>(
                    this.allowEmpty,
                    this.isRequired(),
                    this.getName(),
                    this.getDefaultValue(),
                    this.getSuggestionsProvider(),
                    this.getDefaultDescription()
            );
        }
    }


    public static final class MultipleEntitySelectorParser<C> extends SelectorUtils.EntitySelectorParser<C, MultipleEntitySelector> {

        private final boolean allowEmpty;

        /**
         * Creates a new {@link MultipleEntitySelectorParser}.
         *
         * @param allowEmpty Whether to allow an empty result
         * @since 1.8.0
         */
        @API(status = API.Status.STABLE, since = "1.8.0")
        public MultipleEntitySelectorParser(final boolean allowEmpty) {
            super(false);
            this.allowEmpty = allowEmpty;
        }

        /**
         * Creates a new {@link MultipleEntitySelectorParser}.
         */
        public MultipleEntitySelectorParser() {
            this(true);
        }

        @Override
        public MultipleEntitySelector mapResult(
                final @NonNull String input,
                final SelectorUtils.@NonNull EntitySelectorWrapper wrapper
        ) {
            final List<Entity> entities = wrapper.entities();
            if (entities.isEmpty() && !this.allowEmpty) {
                new Thrower(NO_ENTITIES_EXCEPTION_TYPE.get()).throwIt();
            }
            return new MultipleEntitySelector(input, entities);
        }
    }
}

