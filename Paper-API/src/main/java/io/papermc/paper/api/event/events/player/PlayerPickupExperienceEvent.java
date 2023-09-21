package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.ExperienceOrb;
import io.papermc.paper.api.event.util.Param;

/**
 * Fired when a player is attempting to pick up an experience orb
 */
public interface PlayerPickupExperienceEvent extends CancellablePlayerEvent {

    /**
     * @return Returns the Orb that the player is picking up
     */
    @Param(1)
    ExperienceOrb experienceOrb();
}
