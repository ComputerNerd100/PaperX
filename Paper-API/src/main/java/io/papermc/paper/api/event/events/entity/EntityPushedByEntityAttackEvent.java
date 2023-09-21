package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.vector.Vector;

/**
 * Fired when an entity is pushed by another entity's attack. The acceleration vector can be
 * modified. If this event is cancelled, the entity will not get pushed.
 * <p>
 * Note: Some entities might trigger this multiple times on the same entity
 * as multiple acceleration calculations are done.
 */
public interface EntityPushedByEntityAttackEvent extends CancellableEntityEvent {

    /**
     * Gets the entity which pushed the affected entity.
     *
     * @return the pushing entity
     */
    @Param(1)
    Entity pushedBy();

    /**
     * Gets the acceleration that will be applied to the affected entity.
     *
     * @return the acceleration vector
     */
    @Param(2)
    Vector acceleration();
}
