package io.papermc.paper.api.conversation;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * NullConversationPrefix is a {@link ConversationPrefix} implementation that
 * displays nothing in front of conversation output.
 */
public class NullConversationPrefix implements ConversationPrefix {

    /**
     * Prepends each conversation message with an empty string.
     *
     * @param context Context information about the conversation.
     * @return An empty string.
     */
    @Override
    @NonNull
    public String getPrefix(@NonNull ConversationContext context) {
        return "";
    }
}
