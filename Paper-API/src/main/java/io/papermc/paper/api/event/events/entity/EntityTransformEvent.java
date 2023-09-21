package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

import java.util.List;

/**
 * Called when an entity is about to be replaced by another entity.
 */
public interface EntityTransformEvent extends CancellableEntityEvent {

    /**
     * Gets the entity that the original entity was transformed to.
     *
     * This returns the first entity in the transformed entity list.
     *
     * @return The transformed entity.
     * @see #convertedList() ()
     */
    @Param(1)
    Entity converted();

    /**
     * Gets the entities that the original entity was transformed to.
     *
     * @return The transformed entities.
     */
    @Param(2)
    List<Entity> convertedList();

    /**
     * Gets the reason for the conversion that has occurred.
     *
     * @return The reason for conversion that has occurred.
     */
    @Param(3)
    TransformReason transformReason();

    enum TransformReason {
        /**
         * When a zombie gets cured and a villager is spawned.
         */
        CURED,
        /**
         * When an entity is shaking in Powder Snow and a new entity spawns.
         */
        FROZEN,
        /**
         * When a villager gets infected and a zombie villager spawns.
         */
        INFECTION,
        /**
         * When an entity drowns in water and a new entity spawns.
         */
        DROWNED,
        /**
         * When a mooshroom (or MUSHROOM_COW) is sheared and a cow spawns.
         */
        SHEARED,
        /**
         * When lightning strikes a entity.
         */
        LIGHTNING,
        /**
         * When a slime splits into multiple smaller slimes.
         */
        SPLIT,
        /**
         * When a piglin converts to a zombified piglin.
         */
        PIGLIN_ZOMBIFIED,
        /**
         * When a tadpole converts to a frog
         */
        METAMORPHOSIS,
        /**
         * When reason is unknown.
         */
        UNKNOWN
    }
}
