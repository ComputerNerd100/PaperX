package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a creature targets or untargets another entity
 */
public interface EntityTargetEvent extends CancellableEntityEvent {

    /**
     * Get the entity that this is targeting.
     * <p>
     * This will be null in the case that the event is called when the mob
     * forgets its target.
     *
     * @return The entity
     */
    @Param(1)
    Entity target();

    /**
     * Returns the reason for the targeting
     *
     * @return The reason
     */
    @Param(2)
    TargetReason reason();

    enum TargetReason {
        /**
         * When the entity's target has died, and so it no longer targets it
         */
        TARGET_DIED,
        /**
         * When the entity doesn't have a target, so it attacks the nearest
         * player
         */
        CLOSEST_PLAYER,
        /**
         * When the target attacks the entity, so entity targets it
         */
        TARGET_ATTACKED_ENTITY,
        /**
         * When the target is forgotten for whatever reason.
         */
        FORGOT_TARGET,
        /**
         * When the target attacks the owner of the entity, so the entity
         * targets it.
         */
        TARGET_ATTACKED_OWNER,
        /**
         * When the owner of the entity attacks the target attacks, so the
         * entity targets it.
         */
        OWNER_ATTACKED_TARGET,
        /**
         * When the entity has no target, so the entity randomly chooses one.
         */
        RANDOM_TARGET,
        /**
         * When an entity selects a target while defending a village.
         */
        DEFEND_VILLAGE,
        /**
         * When the target attacks a nearby entity of the same type, so the entity targets it
         */
        TARGET_ATTACKED_NEARBY_ENTITY,
        /**
         * When a zombie targeting an entity summons reinforcements, so the reinforcements target the same entity
         */
        REINFORCEMENT_TARGET,
        /**
         * When an entity targets another entity after colliding with it.
         */
        COLLISION,
        /**
         * For custom calls to the event.
         */
        CUSTOM,
        /**
         * When the entity doesn't have a target, so it attacks the nearest
         * entity
         */
        CLOSEST_ENTITY,
        /**
         * When a raiding entity selects the same target as one of its compatriots.
         */
        FOLLOW_LEADER,
        /**
         * When another entity tempts this entity by having a desired item such
         * as wheat in its hand.
         */
        TEMPT,
        /**
         * When the target is in a different dimension
         */
        TARGET_OTHER_LEVEL,
        /**
         * When the target is in creative or spectator gamemode, or the difficulty is peaceful, or other reasons
         */
        TARGET_INVALID,
        /**
         * A currently unknown reason for the entity changing target.
         */
        UNKNOWN
    }
}
