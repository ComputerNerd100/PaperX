package io.papermc.paper.api.event.events.world.border;

import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a world border changes its bounds, either over time, or instantly.
 */
public interface WorldBorderBoundsChangeEvent extends WorldBorderEvent, Cancellable {

    /**
     * Gets if this change is an instant change or over-time change.
     *
     * @return the change type
     */
    @Param(2)
    Type type();

    /**
     * Gets the old size or the world border.
     *
     * @return the old size
     */
    @Param(3)
    double oldSize();

    /**
     * Gets the new size of the world border.
     *
     * @return the new size
     */
    @Param(4)
    double newSize();

    /**
     * Gets the time in milliseconds for the change. Will be 0 if instant.
     *
     * @return the time in milliseconds for the change
     */
    @Param(5)
    long duration();

    enum Type {
        STARTED_MOVE,
        INSTANT_MOVE
    }
}
