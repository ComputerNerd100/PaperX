package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.events.player.PlayerPortalEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.PortalType;
import io.papermc.paper.api.world.World;

/**
 * Called when an entity is ready to be teleported by a plugin.
 * Currently this is only called after the required
 * ticks have passed for a Nether Portal.
 * <p>
 * Cancelling this event resets the entity's readiness
 * regarding the current portal.
 */
public interface EntityPortalReadyEvent extends CancellableEntityEvent {

    /**
     * Gets the world this portal will teleport to.
     * Can be null if "allow-nether" is false in server.properties
     * or if there is another situation where there is no world to teleport to.
     * <p>
     * This world may be modified by later events such as {@link PlayerPortalEvent}
     * or {@link EntityPortalEvent}.
     *
     * @return the world the portal will teleport the entity to.
     */
    @Param(1)
    World targetWorld();

    /**
     * Gets the portal type for this event.
     *
     * @return the portal type
     */
    @Param(2)
    PortalType portalType();
}
