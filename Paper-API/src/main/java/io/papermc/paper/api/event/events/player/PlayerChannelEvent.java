package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;

/**
 * This event is called after a player registers or unregisters a new plugin
 * channel.
 */
public interface PlayerChannelEvent extends PlayerResultEvent {

    /**
     * Gets the name of the channel that was registered or unregistered.
     * @return the channel name
     */
    @Param(0)
    String channel();
}
