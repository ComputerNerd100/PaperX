package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.ExperienceOrb;
import io.papermc.paper.api.event.util.Param;

/**
 * Fired anytime the server is about to merge 2 experience orbs into one
 */
public interface ExperienceOrbMergeEvent extends CancellableEntityEvent {

    /**
     * @return The orb that will absorb the other experience orb
     */
    @Param(1)
    ExperienceOrb mergeTarget();

    /**
     * @return The orb that is subject to being removed and merged into the target orb
     */
    @Param(2)
    ExperienceOrb mergeSource();
}
