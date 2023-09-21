package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Projectile;
import io.papermc.paper.api.event.events.entity.EntityShootBowEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a player shoots a projectile.
 * <p>
 * Notably this event is not called for arrows as the player does not launch them, rather shoots them with the help
 * of a bow or crossbow. A plugin may listen to {@link EntityShootBowEvent} for these actions
 * instead.
 */
public interface PlayerLaunchProjectileEvent extends CancellablePlayerEvent {

    /**
     * Gets the projectile which will be launched by this event
     *
     * @return the launched projectile
     */
    @Param(1)
    Projectile projectile();

    /**
     * Get the ItemStack used to fire the projectile
     *
     * @return The ItemStack used
     */
    @Param(2)
    ItemStack itemStack();

    /**
     * Get whether to consume the ItemStack or not
     *
     * @return True to consume
     */
    @Param(3)
    boolean consumeItem();
}

