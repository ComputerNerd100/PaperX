package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Villager;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a villager's career changes.
 */
public interface VillagerCareerChangeEvent extends CancellableEntityEvent {
    default Villager villager() {
        return (Villager) entity();
    }

    /**
     * Gets the future profession of the villager.
     *
     * @return The profession the villager will change to
     */
    @Param(1)
    Villager.Profession profession();

    /**
     * Gets the reason for why the villager's career is changing.
     *
     * @return Reason for villager's profession changing
     */
    @Param(2)
    ChangeReason reason();

    enum ChangeReason {
        /**
         * Villager lost their job due to too little experience.
         */
        LOSING_JOB,
        /**
         * Villager gained employment.
         */
        EMPLOYED;
    }
}
