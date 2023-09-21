package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.events.block.CancellableBlockEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.BrewerInventory;
import io.papermc.paper.api.inventory.ItemStack;

import java.util.List;

/**
 * Called when the brewing of the contents inside the Brewing Stand is
 * complete.
 */
public interface BrewEvent extends CancellableBlockEvent {

    /**
     * Gets the contents of the Brewing Stand.
     *
     * <b>Note:</b> The brewer inventory still holds the items found prior to
     * the finalization of the brewing process, e.g. the plain water bottles.
     *
     * @return the contents
     */
    @Param(1)
    BrewerInventory contents();

    /**
     * Gets the resulting items in the Brewing Stand.
     *
     * The returned list, in case of a server-created event instance, is
     * mutable. Any changes in the returned list will reflect in the brewing
     * result if the event is not cancelled. If the size of the list is reduced,
     * remaining items will be set to air.
     *
     * @return List of {@link ItemStack} resulting for this operation
     */
    @Param(2)
    List<ItemStack> results();

    /**
     * Gets the remaining fuel level.
     *
     * @return the remaining fuel
     */
    @Param(3)
    int fuelLevel();
}
