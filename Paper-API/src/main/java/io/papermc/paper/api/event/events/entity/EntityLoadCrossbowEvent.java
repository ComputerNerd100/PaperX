package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a LivingEntity loads a crossbow with a projectile.
 */
public interface EntityLoadCrossbowEvent extends CancellableEntityEvent {
    default LivingEntity livingEntity() {
        return (LivingEntity) entity();
    }

    /**
     * Gets the crossbow {@link ItemStack} being loaded.
     *
     * @return the crossbow involved in this event
     */
    @Param(1)
    ItemStack crossbow();

    /**
     * Gets the hand from which the crossbow was loaded.
     *
     * @return the hand
     */
    @Param(2)
    EquipmentSlot hand();

    /**
     * @return should the itemstack be consumed
     */
    @Param(3)
    boolean consumeItem();
}
