package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Witch;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Fired when a witch consumes the potion in their hand to buff themselves.
 */
public interface WitchConsumePotionEvent extends CancellableEntityEvent {

    /**
     * The witch consuming the potion.
     * @return the witch
     */
    default Witch witch() {
        return (Witch) entity();
    }

    /**
     * @return the potion the witch will consume and have the effects applied.
     */
    @Param(1)
    ItemStack potion();
}
