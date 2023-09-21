package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;
import net.kyori.adventure.text.Component;
import net.kyori.examination.Examinable;
import net.kyori.examination.ExaminableProperty;
import net.kyori.examination.string.StringExaminer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

/**
 * Allows plugins to compute tab completion results asynchronously. If this event provides completions, then the standard synchronous process will not be fired to populate the results. However, the synchronous TabCompleteEvent will fire with the Async results.
 *
 * Only 1 process will be allowed to provide completions, the Async Event, or the standard process.
 */
public interface AsyncTabCompleteEvent extends Event, Cancellable {

    /**
     * Get the sender completing this command.
     *
     * @return the {@link CommandSender} instance
     */
    @Param(0)
    CommandSender sender();

    /**
     * Return the entire buffer which formed the basis of this completion.
     *
     * @return command buffer, as entered
     */
    @Param(1)
    String buffer();

    /**
     * @return True if it is a command being tab completed, false if it is a chat message.
     */
    @Param(2)
    boolean isCommand();

    /**
     * @return The position looked at by the sender, or null if none
     */
    @Param(3)
    Location location();

    /**
     * The list of {@link Completion completions} which will be offered to the sender, in order.
     * This list is mutable and reflects what will be offered.
     * <p>
     * If this collection is not empty after the event is fired, then
     * the standard process of calling {@link Command#tabComplete(CommandSender, String, String[])}
     * or current player names will not be called.
     *
     * @return a list of offered completions
     */
    @Param(4)
    List<Completion> completions();

    /**
     * The list of completions which will be offered to the sender, in order.
     * This list is mutable and reflects what will be offered.
     *
     * If this collection is not empty after the event is fired, then
     * the standard process of calling {@link Command#tabComplete(CommandSender, String, String[])}
     * or current player names will not be called.
     *
     * @return a list of offered completions
     */
    @Param(5)
    List<String> stringCompletions();

    /**
     * If true, the standard process of calling {@link Command#tabComplete(CommandSender, String, String[])}
     * or current player names will not be called.
     *
     * @return Is completions considered handled. Always true if completions is not empty.
     */
    @Param(6)
    boolean handled();
    @Param(7)
    boolean fireSyncHandler();

    interface Completion extends Examinable {
        /**
         * Get the suggestion string for this {@link Completion}.
         *
         * @return suggestion string
         */
        @NotNull String suggestion();

        /**
         * Get the suggestion tooltip for this {@link Completion}.
         *
         * @return tooltip component
         */
        @Nullable Component tooltip();

        @Override
        default @NotNull Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of(ExaminableProperty.of("suggestion", this.suggestion()), ExaminableProperty.of("tooltip", this.tooltip()));
        }

        /**
         * Create a new {@link Completion} from a suggestion string.
         *
         * @param suggestion suggestion string
         * @return new completion instance
         */
        static @NotNull Completion completion(final @NotNull String suggestion) {
            return new CompletionImpl(suggestion, null);
        }

        /**
         * Create a new {@link Completion} from a suggestion string and a tooltip {@link Component}.
         *
         * <p>If the provided component is null, the suggestion will not have a tooltip.</p>
         *
         * @param suggestion suggestion string
         * @param tooltip    tooltip component, or null
         * @return new completion instance
         */
        static @NotNull Completion completion(final @NotNull String suggestion, final @Nullable Component tooltip) {
            return new CompletionImpl(suggestion, tooltip);
        }
    }

    final class CompletionImpl implements Completion {
        private final String suggestion;
        private final Component tooltip;

        CompletionImpl(final @NotNull String suggestion, final @Nullable Component tooltip) {
            this.suggestion = suggestion;
            this.tooltip = tooltip;
        }

        @Override
        public @NotNull String suggestion() {
            return this.suggestion;
        }

        @Override
        public @Nullable Component tooltip() {
            return this.tooltip;
        }

        @Override
        public boolean equals(final @Nullable Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            final CompletionImpl that = (CompletionImpl) o;
            return this.suggestion.equals(that.suggestion)
                    && java.util.Objects.equals(this.tooltip, that.tooltip);
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(this.suggestion, this.tooltip);
        }

        @Override
        public @NotNull String toString() {
            return StringExaminer.simpleEscaping().examine(this);
        }
    }
}
