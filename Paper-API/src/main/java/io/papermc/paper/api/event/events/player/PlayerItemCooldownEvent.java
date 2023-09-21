package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.material.Material;

/**
 * Fired when a player receives an item cooldown.
 */
public interface PlayerItemCooldownEvent extends CancellablePlayerEvent {

    /**
     * Get the material affected by the cooldown.
     *
     * @return material affected by the cooldown
     */
    @Param(1)
    Material type();

    /**
     * Gets the cooldown in ticks.
     *
     * @return cooldown in ticks
     */
    @Param(2)
    int cooldown();
}
