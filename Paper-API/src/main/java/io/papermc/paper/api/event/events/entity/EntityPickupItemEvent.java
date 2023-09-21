package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Item;
import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;

/**
 * Thrown when an entity picks an item up from the ground
 */
public interface EntityPickupItemEvent extends CancellableEntityEvent {
    default LivingEntity livingEntity() {
        return (LivingEntity) entity();
    }

    /**
     * Gets the Item picked up by the entity.
     *
     * @return Item
     */
    @Param(1)
    Item item();

    /**
     * Gets the amount remaining on the ground, if any
     *
     * @return amount remaining on the ground
     */
    @Param(2)
    int remaining();
}
