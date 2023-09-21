package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * This event is fired when the player is leaving a bed.
 */
public interface PlayerBedLeaveEvent extends CancellablePlayerEvent {

    /**
     * Returns the bed block involved in this event.
     *
     * @return the bed block involved in this event
     */
    @Param(1)
    Block bed();

    /**
     * Get if this event should set the new spawn location for the
     * {@link Player}.
     * <br>
     * This does not remove any existing spawn location, only prevent it from
     * being changed (if true).
     * <br>
     * To change a {@link Player}'s spawn location, use
     * {@link Player#setBedSpawnLocation(Location)}.
     *
     * @return true if the spawn location will be changed
     */
    @Param(2)
    boolean setBedSpawn();
}
