package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

/**
 * Called when a player opens an inventory
 */
public interface InventoryOpenEvent extends CancellableInventoryEvent {

    /**
     * Gets the title override set by another event or null
     * if not set.
     *
     * @return the title override or null
     */
    @Param(1)
    Component titleOverride();
}
