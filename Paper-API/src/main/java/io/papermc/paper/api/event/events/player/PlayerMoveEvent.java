package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Holds information for player movement events
 */
public interface PlayerMoveEvent extends CancellablePlayerEvent {

    /**
     * Gets the location this player moved from
     *
     * @return Location the player moved from
     */
    @Param(1)
    Location from();

    /**
     * Gets the location this player moved to
     *
     * @return Location the player moved to
     */
    @Param(2)
    Location to();
}
