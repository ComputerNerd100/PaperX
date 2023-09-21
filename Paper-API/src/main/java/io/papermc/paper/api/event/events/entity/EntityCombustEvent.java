package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when an entity combusts.
 * <p>
 * If an Entity Combust event is cancelled, the entity will not combust.
 */
public interface EntityCombustEvent extends CancellableEntityEvent {

    /**
     * @return the amount of time (in seconds) the combustee should be alight
     *     for
     */
    @Param(1)
    int duration();
}
