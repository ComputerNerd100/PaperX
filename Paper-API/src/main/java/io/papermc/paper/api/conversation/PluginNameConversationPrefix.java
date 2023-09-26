package io.papermc.paper.api.conversation;

import io.papermc.paper.api.plugin.Plugin;
import net.kyori.adventure.text.format.NamedTextColor;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * PluginNameConversationPrefix is a {@link ConversationPrefix} implementation
 * that displays the plugin name in front of conversation output.
 */
public class PluginNameConversationPrefix implements ConversationPrefix {

    protected String separator;
    protected NamedTextColor prefixColor;
    protected Plugin plugin;

    private final String cachedPrefix;

    public PluginNameConversationPrefix(@NonNull Plugin plugin) {
        this(plugin, " > ", NamedTextColor.LIGHT_PURPLE);
    }

    public PluginNameConversationPrefix(@NonNull Plugin plugin, @NonNull String separator, @NonNull NamedTextColor prefixColor) {
        this.separator = separator;
        this.prefixColor = prefixColor;
        this.plugin = plugin;

        cachedPrefix = prefixColor + plugin.getDescription().getName() + separator + NamedTextColor.WHITE;
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

