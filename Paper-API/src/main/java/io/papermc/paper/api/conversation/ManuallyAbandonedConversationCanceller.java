package io.papermc.paper.api.conversation;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * The ManuallyAbandonedConversationCanceller is only used as part of a {@link
 * ConversationAbandonedEvent} to indicate that the conversation was manually
 * abandoned by programmatically calling the abandon() method on it.
 */
public class ManuallyAbandonedConversationCanceller implements ConversationCanceller {
    @Override
    public void setConversation(@NonNull Conversation conversation) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean cancelBasedOnInput(@NonNull ConversationContext context, @NonNull String input) {
        throw new UnsupportedOperationException();
    }

    @Override
    @NonNull
    public ConversationCanceller clone() {
        throw new UnsupportedOperationException();
    }
}

