package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.util.Param;

/**
 * Is called when an entity sits down or stands up.
 */
public interface EntityToggleSitEvent extends CancellableEntityEvent {

    /**
     * Gets the new sitting state that the entity will change to.
     *
     * @return If it's going to sit or not.
     */
    @Param(1)
    boolean sitting();
}
