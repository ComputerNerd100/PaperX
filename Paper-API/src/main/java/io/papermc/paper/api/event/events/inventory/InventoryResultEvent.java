package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.type.ResultEvent;
import io.papermc.paper.api.inventory.InventoryView;

/**
 * Represents an inventory-related event that has a result.
 * <p>
 *     <b>
 *         Anything that implements/extends this interface cannot inherit {@link CancellableInventoryEvent}
 *     </b>
 * </p>
 */
public interface InventoryResultEvent extends InventoryEvent, ResultEvent<InventoryView> {

    default InventoryView view() {
        return result();
    }
    default void setView(InventoryView view) {
        rawResult().set(view);
    }

}
