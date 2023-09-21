package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Event fired when a dispenser shears a nearby sheep.
 */
public interface BlockShearEntityEvent extends CancellableBlockEvent {

    /**
     * Gets the entity that was sheared.
     *
     * @return the entity that was sheared.
     */
    @Param(1)
    Entity entity();

    /**
     * Gets the item used to shear this sheep.
     *
     * @return the item used to shear this sheep.
     */
    @Param(2)
    ItemStack tool();

}
