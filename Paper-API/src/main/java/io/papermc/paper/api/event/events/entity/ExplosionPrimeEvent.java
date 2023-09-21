package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Explosive;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when an entity has made a decision to explode.
 */
public interface ExplosionPrimeEvent extends CancellableEntityEvent {
    default Explosive explosive() {
        return (Explosive) entity();
    }

    /**
     * Gets the radius of the explosion
     *
     * @return returns the radius of the explosion
     */
    @Param(1)
    float radius();

    /**
     * Gets whether this explosion will create fire or not
     *
     * @return true if this explosion will create fire
     */
    @Param(2)
    boolean fire();
}
