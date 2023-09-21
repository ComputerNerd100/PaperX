package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a beacon effect is being applied to a player.
 */
public interface BeaconEffectEvent extends CancellableBlockEvent {

    /**
     * Gets the potion effect being applied.
     *
     * @return Potion effect
     */
    @Param(1)
    PotionEffect effect();

    /**
     * Gets the player who the potion effect is being applied to.
     *
     * @return Affected player
     */
    @Param(2)
    Player player();

    /**
     * Gets whether the effect is a primary beacon effect.
     *
     * @return true if this event represents a primary effect
     */
    @Param(3)
    boolean primary();
}
