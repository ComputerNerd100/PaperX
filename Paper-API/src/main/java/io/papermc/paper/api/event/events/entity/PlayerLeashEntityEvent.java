package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;

/**
 * Called immediately prior to a creature being leashed by a player.
 */
public interface PlayerLeashEntityEvent extends CancellableEntityEvent {

    /**
     * Returns the entity that is holding the leash.
     *
     * @return The leash holder
     */
    @Param(1)
    Entity leashHolder();

    /**
     * Returns the player involved in this event
     *
     * @return Player who is involved in this event
     */
    @Param(2)
    Player player();

    /**
     * Returns the hand used by the player to leash the entity.
     *
     * @return the hand
     */
    @Param(3)
    EquipmentSlot hand();
}
