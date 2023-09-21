package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.HumanEntity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a human entity's food level changes
 */
public interface FoodLevelChangeEvent extends CancellableEntityEvent {
    default HumanEntity humanEntity() {
        return (HumanEntity) entity();
    }

    /**
     * Gets the resultant food level that the entity involved in this event
     * should be set to.
     * <p>
     * Where 20 is a full food bar and 0 is an empty one.
     *
     * @return The resultant food level
     */
    @Param(1)
    int foodLevel();

    /**
     * Gets the item that triggered this event, if any.
     *
     * @return an ItemStack for the item being consumed
     */
    @Param(2)
    ItemStack item();
}
