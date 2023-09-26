package io.papermc.paper.api.conversation;

import io.papermc.paper.api.plugin.Plugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Map;

/**
 * A ConversationContext provides continuity between nodes in the prompt graph
 * by giving the developer access to the subject of the conversation and a
 * generic map for storing values that are shared between all {@link Prompt}
 * invocations.
 */
public class ConversationContext {
    private final Conversable forWhom;
    private final Map<Object, Object> sessionData;
    private final Plugin plugin;

    /**
     * @param plugin The owning plugin.
     * @param forWhom The subject of the conversation.
     * @param initialSessionData Any initial values to put in the sessionData
     *     map.
     */
    public ConversationContext(@Nullable Plugin plugin, @NonNull Conversable forWhom, @NonNull Map<Object, Object> initialSessionData) {
        this.plugin = plugin;
        this.forWhom = forWhom;
        this.sessionData = initialSessionData;
    }

    /**
     * Gets the plugin that owns this conversation.
     *
     * @return The owning plugin.
     */
    @Nullable
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * Gets the subject of the conversation.
     *
     * @return The subject of the conversation.
     */
    @NonNull
    public Conversable getForWhom() {
        return forWhom;
    }

    /**
     * Gets the underlying sessionData map.
     *
     * May be directly modified to manipulate session data.
     *
     * @return The full sessionData map.
     */
    @NonNull
    public Map<Object, Object> getAllSessionData() {
        return sessionData;
    }

    /**
     * Gets session data shared between all {@link Prompt} invocations. Use
     * this as a way to pass data through each Prompt as the conversation
     * develops.
     *
     * @param key The session data key.
     * @return The requested session data.
     */
    @Nullable
    public Object getSessionData(@NonNull Object key) {
        return sessionData.get(key);
    }

    /**
     * Sets session data shared between all {@link Prompt} invocations. Use
     * this as a way to pass data through each prompt as the conversation
     * develops.
     *
     * @param key The session data key.
     * @param value The session data value.
     */
    public void setSessionData(@NonNull Object key, @Nullable Object value) {
        sessionData.put(key, value);
    }
}

