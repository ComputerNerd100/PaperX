package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Firework;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Fired when a player boosts elytra flight with a firework
 */
public interface PlayerElytraBoostEvent extends CancellablePlayerEvent {

    /**
     * Get the firework itemstack used
     *
     * @return ItemStack of firework
     */
    @Param(1)
    ItemStack itemStack();

    /**
     * Get the firework entity that was spawned
     *
     * @return Firework entity
     */
    @Param(2)
    Firework firework();

    /**
     * Get whether to consume the firework or not
     *
     * @return True to consume
     */
    @Param(3)
    boolean consume();
}
