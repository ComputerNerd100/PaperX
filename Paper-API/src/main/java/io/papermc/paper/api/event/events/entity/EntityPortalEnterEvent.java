package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Called when an entity comes into contact with a portal
 */
public interface EntityPortalEnterEvent extends EntityResultEvent {

    /**
     * Gets the portal block the entity is touching
     *
     * @return The portal block the entity is touching
     */
    @Param(0)
    Location location();
}
