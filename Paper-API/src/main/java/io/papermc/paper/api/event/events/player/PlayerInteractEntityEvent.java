package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;

/**
 * Represents an event that is called when a player right clicks an entity.
 */
public interface PlayerInteractEntityEvent extends CancellablePlayerEvent {

    /**
     * Gets the entity that was right-clicked by the player.
     *
     * @return entity right clicked by player
     */
    @Param(1)
    Entity clickedEntity();

    /**
     * The hand used to perform this interaction.
     *
     * @return the hand used to interact
     */
    @Param(2)
    EquipmentSlot hand();
}
