package io.papermc.paper.api.event;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Parent interface for all Paper events.
 */
public interface Event {

    /**
     * Gets the type of the event.
     * @return the type of the event
     */
    @NonNull Class<? extends Event> getEventType();

}
