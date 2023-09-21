package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.namespace.NamespacedKey;

/**
 * Called when a player discovers a new recipe in the recipe book.
 */
public interface PlayerRecipeDiscoverEvent extends CancellablePlayerEvent {

    /**
     * Get the namespaced key of the discovered recipe.
     *
     * @return the discovered recipe
     */
    @Param(1)
    NamespacedKey recipe();
}
