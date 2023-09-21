package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.Warden;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a Warden's anger level has changed due to another entity.
 * <p>
 * If the event is cancelled, the warden's anger level will not change.
 */
public interface WardenAngerChangeEvent extends CancellableEntityEvent {
    default Warden warden() {
        return (Warden) this.entity();
    }

    /**
     * Gets the entity (if any) which triggered this anger update.
     *
     * @return triggering entity, or null
     */
    @Param(1)
    Entity target();

    /**
     * Gets the old anger level.
     *
     * @return old anger level
     * @see Warden#getAnger(Entity)
     */
    @Param(2)
    int oldAnger();

    /**
     * Gets the new anger level resulting from this event.
     *
     * @return new anger level
     * @see Warden#getAnger(Entity)
     */
    @Param(3)
    int newAnger();

}
