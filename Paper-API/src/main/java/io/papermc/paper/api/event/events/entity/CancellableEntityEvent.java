package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;

/**
 * Represents an event involving an {@link Entity} that can be cancelled.
 * <p>
 *     <b>
 *         Anything that implements/extends this interface cannot inherit {@link EntityResultEvent}
 *     </b>
 */
public interface CancellableEntityEvent extends EntityEvent, Cancellable {
    @Param(0)
    Entity entity();

}
