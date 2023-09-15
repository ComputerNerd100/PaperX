package io.papermc.paper.api.conversation;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.regex.Pattern;

/**
 * RegexPrompt is the base class for any prompt that requires an input
 * validated by a regular expression.
 */
public abstract class RegexPrompt extends ValidatingPrompt {

    private Pattern pattern;

    public RegexPrompt(@NonNull String regex) {
        this(Pattern.compile(regex));
    }

    public RegexPrompt(@NonNull Pattern pattern) {
        super();
        this.pattern = pattern;
    }

    private RegexPrompt() {}

    @Override
    protected boolean isInputValid(@NonNull ConversationContext context, @NonNull String input) {
        return pattern.matcher(input).matches();
    }
}

