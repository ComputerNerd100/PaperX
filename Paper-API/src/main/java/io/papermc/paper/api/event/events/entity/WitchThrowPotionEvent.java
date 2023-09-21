package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.entity.Witch;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Fired when a witch throws a potion at a player
 */
public interface WitchThrowPotionEvent extends CancellableEntityEvent {
    default Witch witch() {
        return (Witch) entity();
    }

    /**
     * @return The target of the potion
     */
    @Param(1)
    LivingEntity target();

    /**
     * @return The potion the witch will throw at a player
     */
    @Param(2)
    ItemStack potion();
}
