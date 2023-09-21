package io.papermc.paper.api.event.events.weather;

import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;

/**
 * Stores data for thunder state changing in a world
 */
public interface ThunderChangeEvent extends WeatherEvent, Cancellable {

    /**
     * Gets the state of thunder that the world is being set to
     *
     * @return true if the weather is being set to thundering, false otherwise
     */
    @Param(1)
    boolean to();

    /**
     * Gets the cause of the weather change.
     *
     * @return the weather change cause
     */
    @Param(2)
    Cause cause();

    enum Cause {
        COMMAND,
        NATURAL,
        SLEEP,
        PLUGIN,
        UNKNOWN
    }
}
