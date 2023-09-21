package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.advancement.Advancement;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a player is granted a criteria in an advancement.
 */
public interface PlayerAdvancementCriterionGrantEvent extends CancellablePlayerEvent {

    /**
     * Get the advancement which has been affected.
     *
     * @return affected advancement
     */
    @Param(1)
    Advancement advancement();

    /**
     * Get the criterion which has been granted.
     *
     * @return granted criterion
     */
    @Param(2)
    String criterion();
}
