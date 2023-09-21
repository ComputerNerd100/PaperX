package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.util.Param;

/**
 * An abstract base class for events that describe an interaction between a
 * HumanEntity and the contents of an Inventory.
 */
public interface InventoryInteractEvent extends CancellableInventoryEvent {

    /**
     * Gets the {@link io.papermc.paper.api.event.Event.Result} of this event. The Result describes the
     * behavior that will be applied to the inventory in relation to this
     * event.
     *
     * @return the Result of this event.
     */
    @Param(1)
    Result result();
}
