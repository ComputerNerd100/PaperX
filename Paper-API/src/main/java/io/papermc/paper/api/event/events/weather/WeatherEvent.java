package io.papermc.paper.api.event.events.weather;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.world.World;

/**
 * Represents a Weather-related event
 */
public interface WeatherEvent extends Event {

    /**
     * Returns the World where this event is occurring
     *
     * @return World this event is occurring in
     */
    @Param(0)
    World world();
}
