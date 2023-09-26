package io.papermc.paper.api.command.cloud.commandframework.paper.parser.selector;

import cloud.commandframework.captions.Caption;
import cloud.commandframework.captions.CaptionVariable;
import cloud.commandframework.context.CommandContext;
import cloud.commandframework.exceptions.parsing.ParserException;
import io.papermc.paper.api.command.cloud.commandframework.paper.PaperCaptionKeys;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * EntitySelector parse exception
 */
public final class SelectorParseException extends ParserException {

    private static final long serialVersionUID = 1900826717897819065L;
    private final String input;
    private final FailureReason reason;

    /**
     * Construct a new EntitySelector parse exception
     *
     * @param input   String input
     * @param context Command context
     * @param reason  Reason for parse failure
     * @param parser  The parser class
     */
    public SelectorParseException(
            final @NonNull String input,
            final @NonNull CommandContext<?> context,
            final @NonNull FailureReason reason,
            final @NonNull Class<?> parser
    ) {
        super(
                parser,
                context,
                reason.getCaption(),
                CaptionVariable.of("input", input)
        );
        this.reason = reason;
        this.input = input;
    }

    /**
     * Get the supplied input
     *
     * @return String value
     */
    public @NonNull String getInput() {
        return this.input;
    }

    /**
     * Get the reason of failure for the selector parser.
     *
     * <p>Note: The only type currently used is {@link FailureReason#UNSUPPORTED_VERSION}, other exceptions
     * are now handled by Brigadier in the form of {@link com.mojang.brigadier.exceptions.CommandSyntaxException}.</p>
     *
     * @return Failure reason
     * @since 1.2.0
     */
    public @NonNull FailureReason getFailureReason() {
        return this.reason;
    }

    /**
     * Reasons for which selector parsing may fail
     *
     * @since 1.1.0
     */
    public enum FailureReason {
        UNSUPPORTED_VERSION(PaperCaptionKeys.ARGUMENT_PARSE_FAILURE_SELECTOR_UNSUPPORTED);


        private final Caption caption;

        FailureReason(final @NonNull Caption caption) {
            this.caption = caption;
        }

        /**
         * Get the caption used for this failure reason
         *
         * @return The caption
         */
        public @NonNull Caption getCaption() {
            return this.caption;
        }
    }
}

