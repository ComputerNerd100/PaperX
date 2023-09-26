package io.papermc.paper.api.conversation;

import io.papermc.paper.api.plugin.Plugin;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * An InactivityConversationCanceller will cancel a {@link Conversation} after
 * a period of inactivity by the user.
 */
public class InactivityConversationCanceller implements ConversationCanceller {
    protected Plugin plugin;
    protected int timeoutSeconds;
    protected Conversation conversation;
    private int taskId = -1;

    /**
     * Creates an InactivityConversationCanceller.
     *
     * @param plugin The owning plugin.
     * @param timeoutSeconds The number of seconds of inactivity to wait.
     */
    public InactivityConversationCanceller(@NonNull Plugin plugin, int timeoutSeconds) {
        this.plugin = plugin;
        this.timeoutSeconds = timeoutSeconds;
    }

    @Override
    public void setConversation(@NonNull Conversation conversation) {
        this.conversation = conversation;
        startTimer();
    }

    @Override
    public boolean cancelBasedOnInput(@NonNull ConversationContext context, @NonNull String input) {
        // Reset the inactivity timer
        stopTimer();
        startTimer();
        return false;
    }

    @Override
    @NonNull
    public ConversationCanceller clone() {
        return new InactivityConversationCanceller(plugin, timeoutSeconds);
    }

    /**
     * Starts an inactivity timer.
     */
    private void startTimer() {
        taskId = plugin.server().scheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                if (conversation.getState() == Conversation.ConversationState.UNSTARTED) {
                    startTimer();
                } else if (conversation.getState() == Conversation.ConversationState.STARTED) {
                    cancelling(conversation);
                    conversation.abandon(new ConversationAbandonedEvent(conversation, InactivityConversationCanceller.this));
                }
            }
        }, timeoutSeconds * 20);
    }

    /**
     * Stops the active inactivity timer.
     */
    private void stopTimer() {
        if (taskId != -1) {
            plugin.server().scheduler().cancelTask(taskId);
            taskId = -1;
        }
    }

    /**
     * Subclasses of InactivityConversationCanceller can override this method
     * to take additional actions when the inactivity timer abandons the
     * conversation.
     *
     * @param conversation The conversation being abandoned.
     */
    protected void cancelling(@NonNull Conversation conversation) {

    }
}

