package io.papermc.paper.api.conversation;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

/**
 * The Conversable interface is used to indicate objects that can have
 * conversations.
 */
public interface Conversable {

    /**
     * Tests to see of a Conversable object is actively engaged in a
     * conversation.
     *
     * @return True if a conversation is in progress
     */
    boolean isConversing();

    /**
     * Accepts input into the active conversation. If no conversation is in
     * progress, this method does nothing.
     *
     * @param input The input message into the conversation
     */
    void acceptConversationInput(@NonNull String input);

    /**
     * Enters into a dialog with a Conversation object.
     *
     * @param conversation The conversation to begin
     * @return True if the conversation should proceed, false if it has been
     *     enqueued
     */
    boolean beginConversation(@NonNull Conversation conversation);

    /**
     * Abandons an active conversation.
     *
     * @param conversation The conversation to abandon
     */
    void abandonConversation(@NonNull Conversation conversation);

    /**
     * Abandons an active conversation.
     *
     * @param conversation The conversation to abandon
     * @param details Details about why the conversation was abandoned
     */
    void abandonConversation(@NonNull Conversation conversation, @NonNull ConversationAbandonedEvent details);

    /**
     * Sends this sender a message raw
     *
     * @param message Message to be displayed
     */
    @org.jetbrains.annotations.ApiStatus.Obsolete // Paper
    void sendRawMessage(@NonNull String message);

    /**
     * Sends this sender a message raw
     *
     * @param message Message to be displayed
     * @param sender The sender of this message
     * @deprecated sender UUID is ignored
     */
    @Deprecated // Paper
    void sendRawMessage(@Nullable UUID sender, @NonNull String message);
}

