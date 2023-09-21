package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.namespace.NamespacedKey;

/**
 * Called when a player clicks a recipe in the recipe book
 */
public interface PlayerRecipeBookClickEvent extends CancellablePlayerEvent {

    /**
     * Gets the namespaced key of the recipe that was clicked by the player
     *
     * @return The namespaced key of the recipe
     */
    @Param(1)
    NamespacedKey recipe();

    /**
     * Gets a boolean which indicates whether or not the player requested to make the maximum amount of results. This is
     * true if shift is pressed while the recipe is clicked in the recipe book
     *
     * @return {@code true} if shift is pressed while the recipe is clicked
     */
    @Param(2)
    boolean makeAll();
}
