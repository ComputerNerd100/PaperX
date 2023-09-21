package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.events.player.PlayerPortalEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.PortalType;

/**
 * Called when a non-player entity is about to teleport because it is in
 * contact with a portal.
 * <p>
 * For players see {@link PlayerPortalEvent}
 */
public interface EntityPortalEvent extends EntityTeleportEvent {

    /**
     * Gets the search radius value for finding an available portal.
     *
     * @return the currently set search radius
     */
    @Param(3)
    int searchRadius();

    /**
     * Get the portal type relating to this event.
     *
     * @return the portal type
     */
    @Param(4)
    PortalType portalType();

}
