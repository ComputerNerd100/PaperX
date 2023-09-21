package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.vector.Vector;

/**
 * Represents an event that is called when a player right clicks an entity that
 * also contains the location where the entity was clicked.
 * <br>
 * Note that the client may sometimes spuriously send this packet in addition to {@link PlayerInteractEntityEvent}.
 * Users are advised to listen to this (parent) class unless specifically required.
 * <br>
 * Note that interacting with Armor Stands fires this event only and not its parent and as such users are expressly required
 * to listen to this event for that scenario.
 */
public interface PlayerInteractAtEntityEvent extends PlayerInteractEntityEvent {

    /**
     * Gets the position where the entity was interacted with.
     * @return the position where the entity was interacted with
     */
    @Param(3)
    Vector position();
}
