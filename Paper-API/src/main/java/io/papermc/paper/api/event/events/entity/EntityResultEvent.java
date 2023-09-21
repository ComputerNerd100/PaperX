package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.type.ResultEvent;

/**
 * Represents an event involving an entity that has the entity as a result.
 * <p>
 *     <b>
 *         Anything that implements/extends this interface cannot inherit {@link CancellableEntityEvent}
 *     </b>
 * </p>
 */
public interface EntityResultEvent extends EntityEvent, ResultEvent<Entity> {

    /**
     * Gets the entity involved in this event.
     * @return the entity involved in this event
     */
    default Entity entity() {
        return result();
    }

    /**
     * Sets the entity involved in this event.
     * @param entity the entity involved in this event
     */
    default void entity(Entity entity) {
        rawResult().set(entity);
    }
}
