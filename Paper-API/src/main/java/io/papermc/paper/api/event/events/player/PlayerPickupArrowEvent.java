package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.AbstractArrow;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.events.entity.EntityPickupItemEvent;
import io.papermc.paper.api.event.util.Param;

/**
 * Thrown when a player picks up an arrow from the ground.
 */
public interface PlayerPickupArrowEvent extends EntityPickupItemEvent {
    default Player player() {
        return (Player) livingEntity();
    }

    /**
     * Get the arrow being picked up by the player
     *
     * @return The arrow being picked up
     */
    @Param(3)
    AbstractArrow arrow();
}
