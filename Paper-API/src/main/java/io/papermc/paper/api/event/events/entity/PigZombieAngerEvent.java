package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.PigZombie;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a Pig Zombie is angered by another entity.
 * <p>
 * If the event is cancelled, the pig zombie will not be angered.
 */
public interface PigZombieAngerEvent extends CancellableEntityEvent {
    default PigZombie pigZombie() {
        return (PigZombie) entity();
    }

    /**
     * Gets the entity (if any) which triggered this anger update.
     *
     * @return triggering entity, or null
     */
    @Param(1)
    Entity target();

    /**
     * Gets the new anger resulting from this event.
     *
     * @return new anger
     * @see PigZombie#getAnger()
     */
    @Param(2)
    int newAnger();
}
