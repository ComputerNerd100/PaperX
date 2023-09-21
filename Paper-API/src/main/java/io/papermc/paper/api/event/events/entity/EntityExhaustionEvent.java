package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.HumanEntity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a human entity experiences exhaustion.
 *
 * An exhaustion level greater than 4.0 causes a decrease in saturation by 1.
 */
public interface EntityExhaustionEvent extends CancellableEntityEvent {

    /**
     * Gets the {@link HumanEntity} for this event
     * @return the human entity
     */
    default HumanEntity humanEntity() {
        return (HumanEntity) entity();
    }

    /**
     * Gets the {@link ExhaustionReason} for this event
     *
     * @return the exhaustion reason
     */
    @Param(1)
    ExhaustionReason exhaustionReason();

    /**
     * Get the amount of exhaustion to add to the player's current exhaustion.
     *
     * @return amount of exhaustion
     */
    @Param(2)
    float exhaustion();

    /**
     * The reason for why a PlayerExhaustionEvent takes place
     */
    enum ExhaustionReason {
        /**
         * Player mines a block
         */
        BLOCK_MINED,
        /**
         * Player has the hunger potion effect
         */
        HUNGER_EFFECT,
        /**
         * Player takes damage
         */
        DAMAGED,
        /**
         * Player attacks another entity
         */
        ATTACK,
        /**
         * Player is sprint jumping
         */
        JUMP_SPRINT,
        /**
         * Player jumps
         */
        JUMP,
        /**
         * Player swims one centimeter
         */
        SWIM,
        /**
         * Player walks underwater one centimeter
         */
        WALK_UNDERWATER,
        /**
         * Player moves on the surface of water one centimeter
         */
        WALK_ON_WATER,
        /**
         * Player sprints one centimeter
         */
        SPRINT,
        /**
         * Player crouches one centimeter (does not effect exhaustion, but fires
         * nonetheless)
         */
        CROUCH,
        /**
         * Player walks one centimeter (does not effect exhaustion, but fires
         * nonetheless)
         */
        WALK,
        /**
         * Player regenerated health
         */
        REGEN,
        /**
         * Unknown exhaustion reason
         */
        UNKNOWN
    }
}
