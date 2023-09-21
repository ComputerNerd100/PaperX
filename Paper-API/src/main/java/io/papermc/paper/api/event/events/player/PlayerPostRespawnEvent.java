package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Fired after a player has respawned
 */
public interface PlayerPostRespawnEvent extends PlayerResultEvent {

    /**
     * Returns the location of the respawned player
     *
     * @return location of the respawned player
     */
    @Param(0)
    Location respawnLocation();

    /**
     * Checks if the player respawned to their bed
     *
     * @return whether the player respawned to their bed
     */
    @Param(1)
    boolean isBedSpawn();
}
