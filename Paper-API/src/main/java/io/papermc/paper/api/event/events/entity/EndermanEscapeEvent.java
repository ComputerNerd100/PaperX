package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Enderman;
import io.papermc.paper.api.event.util.Param;

public interface EndermanEscapeEvent extends CancellableEntityEvent {
    default Enderman enderman() {
        return (Enderman) this.entity();
    }
    @Param(1)
    Reason reason();
    enum Reason {
        /**
         * The enderman has stopped attacking and ran away
         */
        RUNAWAY,
        /**
         * The enderman has teleported away due to indirect damage (ranged)
         */
        INDIRECT,
        /**
         * The enderman has teleported away due to a critical hit
         */
        CRITICAL_HIT,
        /**
         * The enderman has teleported away due to the player staring at it during combat
         */
        STARE,
        /**
         * Specific case for CRITICAL_HIT where the enderman is taking rain damage
         */
        DROWN
    }
}
