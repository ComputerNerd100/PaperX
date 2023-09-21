package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Witch;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Fired when a witch is about to consume a potion to buff themselves.
 */
public interface WitchReadyPotionEvent extends CancellableEntityEvent {
    default Witch witch() {
        return (Witch) entity();
    }

    /**
     * @return the potion the witch is readying to use
     */
    @Param(1)
    ItemStack potion();
}
