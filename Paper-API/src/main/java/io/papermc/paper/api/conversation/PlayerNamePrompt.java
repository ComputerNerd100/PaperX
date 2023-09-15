package io.papermc.paper.api.conversation;

import io.papermc.paper.api.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * PlayerNamePrompt is the base class for any prompt that requires the player
 * to enter another player's name.
 */
public abstract class PlayerNamePrompt extends ValidatingPrompt {
    private Plugin plugin;

    public PlayerNamePrompt(@NonNull Plugin plugin) {
        super();
        this.plugin = plugin;
    }

    @Override
    protected boolean isInputValid(@NonNull ConversationContext context, @NonNull String input) {
        return plugin.getServer().getPlayer(input) != null;
    }

    @Nullable
    @Override
    protected Prompt acceptValidatedInput(@NonNull ConversationContext context, @NonNull String input) {
        return acceptValidatedInput(context, plugin.getServer().getPlayer(input));
    }

    /**
     * Override this method to perform some action with the user's player name
     * response.
     *
     * @param context Context information about the conversation.
     * @param input The user's player name response.
     * @return The next {@link Prompt} in the prompt graph.
     */
    @Nullable
    protected abstract Prompt acceptValidatedInput(@NonNull ConversationContext context, @NonNull Player input);
}

