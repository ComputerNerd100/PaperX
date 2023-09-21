package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.events.entity.EntityPortalEvent;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a player is about to teleport because it is in contact with a
 * portal which will generate an exit portal.
 * <p>
 * For other entities see {@link EntityPortalEvent}
 */
public interface PlayerPortalEvent extends PlayerTeleportEvent {

    /**
     * Gets the search radius value for finding an available portal.
     *
     * @return the currently set search radius
     */
    @Param(4)
    int searchRadius();

    /**
     * Returns whether the server will attempt to create a destination portal or
     * not.
     *
     * @return whether there should create be a destination portal created
     */
    @Param(5)
    boolean createPortal();

    /**
     * Gets the maximum radius the world is searched for a free space from the
     * given location.
     *
     * If enough free space is found then the portal will be created there, if
     * not it will force create with air-space at the target location.
     *
     * Does not apply to end portal target platforms which will always appear at
     * the target location.
     *
     * @return the currently set creation radius
     */
    @Param(6)
    int creationRadius();
}
