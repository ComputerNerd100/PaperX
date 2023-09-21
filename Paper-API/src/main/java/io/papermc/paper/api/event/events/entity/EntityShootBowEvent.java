package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a LivingEntity shoots a bow firing an arrow
 */
public interface EntityShootBowEvent extends CancellableEntityEvent {

    /**
     * Gets the bow ItemStack used to fire the arrow.
     *
     * @return the bow involved in this event
     */
    @Param(1)
    ItemStack bow();

    /**
     * Get the ItemStack to be consumed in this event (if any).
     *
     * For instance, bows will consume an arrow ItemStack in a player's
     * inventory.
     *
     * @return the consumable item
     */
    @Param(2)
    ItemStack consumable();

    /**
     * Gets the projectile which will be launched by this event
     *
     * @return the launched projectile
     */
    @Param(3)
    Entity projectile();

    /**
     * Get the hand from which the bow was shot.
     *
     * @return the hand
     */
    @Param(4)
    EquipmentSlot hand();

    /**
     * Gets the force the arrow was launched with
     *
     * @return bow shooting force, up to 1.0
     */
    @Param(5)
    float force();

    /**
     * Get whether or not the consumable item should be consumed in this event.
     *
     * @return true if consumed, false otherwise
     */
    @Param(6)
    boolean consumeItem();
}
