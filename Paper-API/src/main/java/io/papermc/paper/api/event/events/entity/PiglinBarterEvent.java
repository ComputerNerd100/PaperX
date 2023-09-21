package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Piglin;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

import java.util.List;

/**
 * Stores all data related to the bartering interaction with a piglin.
 *
 * Called when a piglin completes a barter.
 */
public interface PiglinBarterEvent extends CancellableEntityEvent {
    default Piglin piglin() {
        return (Piglin) entity();
    }

    /**
     * Returns a mutable list representing the outcome of the barter.
     *
     * @return A mutable list of the item the player will receive
     */
    @Param(1)
    List<ItemStack> outcome();

    /**
     * Gets the input of the barter.
     *
     * @return The item that was used to barter with
     */
    @Param(2)
    ItemStack input();
}
