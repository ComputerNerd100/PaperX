package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when the amount of air an entity has remaining changes.
 */
public interface EntityAirChangeEvent extends CancellableEntityEvent {

    /**
     * Gets the amount of air the entity has left (measured in ticks).
     *
     * @return amount of air remaining
     */
    @Param(1)
    int amount();
}
