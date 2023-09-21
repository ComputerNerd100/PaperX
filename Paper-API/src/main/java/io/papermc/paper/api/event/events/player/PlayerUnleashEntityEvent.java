package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.events.entity.EntityUnleashEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;

/**
 * Called prior to an entity being unleashed due to a player's action.
 */
public interface PlayerUnleashEntityEvent extends EntityUnleashEvent {

    /**
     * Returns the player who is unleashing the entity.
     *
     * @return The player
     */
    @Param(3)
    Player player();

    /**
     * Get the hand used by the player to unleash the entity.
     *
     * @return the hand
     */
    @Param(4)
    EquipmentSlot hand();
}
