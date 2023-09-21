package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.world.World;

/**
 * Called when a player switches to another world.
 */
public interface PlayerChangedWorldEvent extends PlayerResultEvent {

    /**
     * Gets the world the player is switching from.
     *
     * @return  player's previous world
     */
    @Param(0)
    World from();
}
