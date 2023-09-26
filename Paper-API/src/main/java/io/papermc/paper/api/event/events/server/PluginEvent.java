package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.plugin.Plugin;

/**
 * Used for plugin enable and disable events
 */
public interface PluginEvent extends ServerEvent {

    /**
     * Gets the plugin involved in this event
     *
     * @return Plugin for this event
     */
    @Param(0)
    Plugin plugin();
}
