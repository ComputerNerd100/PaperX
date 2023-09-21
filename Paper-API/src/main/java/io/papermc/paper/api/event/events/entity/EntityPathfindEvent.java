package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Fired when an Entity decides to start moving towards a location.
 *
 * This event does not fire for the entities actual movement. Only when it
 * is choosing to start moving to a location.
 */
public interface EntityPathfindEvent extends CancellableEntityEvent {

    /**
     * If the Entity is trying to pathfind to an entity, this is the entity in relation.
     *
     * Otherwise this will return null.
     *
     * @return The entity target or null
     */
    @Param(1)
    Entity targetEntity();

    /**
     * The Location of where the entity is about to move to.
     *
     * Note that if the target happened to of been an entity
     * @return Location of where the entity is trying to pathfind to.
     */
    @Param(2)
    Location loc();
}
