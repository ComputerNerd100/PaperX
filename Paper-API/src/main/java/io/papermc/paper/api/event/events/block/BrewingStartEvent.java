package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when a brewing stand starts to brew.
 */
public interface BrewingStartEvent extends InventoryBlockStartEvent {

    /**
     * Gets the total brew time associated with this event.
     *
     * @return the total brew time
     */
    @Param(1)
    int brewTime();
}
