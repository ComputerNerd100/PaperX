package io.papermc.paper.api.event.events.hanging;

import io.papermc.paper.api.entity.Hanging;
import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;

/**
 * Represents a hanging entity-related event.
 */
public interface HangingEvent extends Event {

    /**
     * Gets the hanging entity involved in this event.
     *
     * @return the hanging entity
     */
    @Param(0)
    Hanging hanging();
}
