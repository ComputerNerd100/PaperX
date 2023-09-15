package io.papermc.paper.api.conversation;

import org.apache.commons.lang3.math.NumberUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * NumericPrompt is the base class for any prompt that requires a {@link
 * Number} response from the user.
 */
public abstract class NumericPrompt extends ValidatingPrompt {
    public NumericPrompt() {
        super();
    }

    @Override
    protected boolean isInputValid(@NonNull ConversationContext context, @NonNull String input) {
        return NumberUtils.isNumber(input) && isNumberValid(context, NumberUtils.createNumber(input));
    }

    /**
     * Override this method to do further validation on the numeric player
     * input after the input has been determined to actually be a number.
     *
     * @param context Context information about the conversation.
     * @param input The number the player provided.
     * @return The validity of the player's input.
     */
    protected boolean isNumberValid(@NonNull ConversationContext context, @NonNull Number input) {
        return true;
    }

    @Nullable
    @Override
    protected Prompt acceptValidatedInput(@NonNull ConversationContext context, @NonNull String input) {
        try {
            return acceptValidatedInput(context, NumberUtils.createNumber(input));
        } catch (NumberFormatException e) {
            return acceptValidatedInput(context, NumberUtils.INTEGER_ZERO);
        }
    }

    /**
     * Override this method to perform some action with the user's integer
     * response.
     *
     * @param context Context information about the conversation.
     * @param input The user's response as a {@link Number}.
     * @return The next {@link Prompt} in the prompt graph.
     */
    @Nullable
    protected abstract Prompt acceptValidatedInput(@NonNull ConversationContext context, @NonNull Number input);

    @Nullable
    @Override
    protected String getFailedValidationText(@NonNull ConversationContext context, @NonNull String invalidInput) {
        if (NumberUtils.isNumber(invalidInput)) {
            return getFailedValidationText(context, NumberUtils.createNumber(invalidInput));
        } else {
            return getInputNotNumericText(context, invalidInput);
        }
    }

    /**
     * Optionally override this method to display an additional message if the
     * user enters an invalid number.
     *
     * @param context Context information about the conversation.
     * @param invalidInput The invalid input provided by the user.
     * @return A message explaining how to correct the input.
     */
    @Nullable
    protected String getInputNotNumericText(@NonNull ConversationContext context, @NonNull String invalidInput) {
        return null;
    }

    /**
     * Optionally override this method to display an additional message if the
     * user enters an invalid numeric input.
     *
     * @param context Context information about the conversation.
     * @param invalidInput The invalid input provided by the user.
     * @return A message explaining how to correct the input.
     */
    @Nullable
    protected String getFailedValidationText(@NonNull ConversationContext context, @NonNull Number invalidInput) {
        return null;
    }
}

