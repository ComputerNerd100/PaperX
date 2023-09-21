package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * An event that is called when a world's spawn changes. The world's previous
 * spawn location is included.
 */
public interface SpawnChangeEvent extends WorldResultEvent {

    /**
     * Gets the previous spawn location
     *
     * @return Location that used to be spawn
     */
    @Param(0)
    Location previousLocation();
}
