package io.papermc.paper.api.conversation;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * An ExactMatchConversationCanceller cancels a conversation if the user
 * enters an exact input string
 */
public class ExactMatchConversationCanceller implements ConversationCanceller {
    private String escapeSequence;

    /**
     * Builds an ExactMatchConversationCanceller.
     *
     * @param escapeSequence The string that, if entered by the user, will
     *     cancel the conversation.
     */
    public ExactMatchConversationCanceller(@NonNull String escapeSequence) {
        this.escapeSequence = escapeSequence;
    }

    @Override
    public void setConversation(@NonNull Conversation conversation) {}

    @Override
    public boolean cancelBasedOnInput(@NonNull ConversationContext context, @NonNull String input) {
        return input.equals(escapeSequence);
    }

    @Override
    @NonNull
    public ConversationCanceller clone() {
        return new ExactMatchConversationCanceller(escapeSequence);
    }
}

