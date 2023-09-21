package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.InventoryView;

/**
 * Represents an inventory-related event that can be cancelled.
 * <p>
 *     <b>
 *         Anything that implements/extends this interface cannot inherit {@link InventoryResultEvent}
 *     </b>
 * </p>
 */
public interface CancellableInventoryEvent extends InventoryEvent, Cancellable {

    /**
     * Gets the inventory view involved in this event.
     * @return the inventory view
     */
    @Param(0)
    InventoryView inventoryView();
}
