package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.vector.Vector;

/**
 * Called before an entity exits a portal.
 * <p>
 * This event allows you to modify the velocity of the entity after they have
 * successfully exited the portal.
 * <p>
 * Cancelling this event does not prevent the teleport, but it does prevent
 * any changes to velocity and location from taking place.
 */
public interface EntityPortalExitEvent extends EntityTeleportEvent {

    /**
     * Gets a copy of the velocity that the entity has before entering the
     * portal.
     *
     * @return velocity of entity before entering the portal
     */
    @Param(3)
    Vector before();

    /**
     * Gets a copy of the velocity that the entity will have after exiting the
     * portal.
     *
     * @return velocity of entity after exiting the portal
     */
    @Param(4)
    Vector after();
}
