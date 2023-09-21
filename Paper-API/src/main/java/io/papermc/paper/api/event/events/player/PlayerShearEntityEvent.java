package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a player shears an entity
 */
public interface PlayerShearEntityEvent extends CancellablePlayerEvent {

    /**
     * Gets the entity the player is shearing
     *
     * @return the entity the player is shearing
     */
    @Param(1)
    Entity what();

    /**
     * Gets the item used to shear the entity.
     *
     * @return the shears
     */
    @Param(2)
    ItemStack item();

    /**
     * Gets the hand used to shear the entity.
     *
     * @return the hand
     */
    @Param(3)
    EquipmentSlot hand();
}
