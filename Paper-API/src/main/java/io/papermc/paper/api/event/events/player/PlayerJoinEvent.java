package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

/**
 * Called when a player joins a server
 */
public interface PlayerJoinEvent extends PlayerResultEvent {

    /**
     * Gets the join message to send to all online players
     *
     * @return string join message. Can be null
     */
    @Param(0)
    Component joinMessage();
}
