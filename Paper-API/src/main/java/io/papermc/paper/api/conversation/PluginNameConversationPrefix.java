package io.papermc.paper.api.conversation;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * PluginNameConversationPrefix is a {@link ConversationPrefix} implementation
 * that displays the plugin name in front of conversation output.
 */
public class PluginNameConversationPrefix implements ConversationPrefix {

    protected String separator;
    protected ChatColor prefixColor;
    protected Plugin plugin;

    private String cachedPrefix;

    public PluginNameConversationPrefix(@NonNull Plugin plugin) {
        this(plugin, " > ", ChatColor.LIGHT_PURPLE);
    }

    public PluginNameConversationPrefix(@NonNull Plugin plugin, @NonNull String separator, @NonNull ChatColor prefixColor) {
        this.separator = separator;
        this.prefixColor = prefixColor;
        this.plugin = plugin;

        cachedPrefix = prefixColor + plugin.getDescription().getName() + separator + ChatColor.WHITE;
    }

    /**
     * Prepends each conversation message with the plugin name.
     *
     * @param context Context information about the conversation.
     * @return An empty string.
     */
    @Override
    @NonNull
    public String getPrefix(@NonNull ConversationContext context) {
        return cachedPrefix;
    }
}

