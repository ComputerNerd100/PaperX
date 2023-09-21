package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.util.Param;

/**
 * Stores data for health-regain events
 */
public interface EntityRegainHealthEvent extends CancellableEntityEvent {

    /**
     * Gets the amount of regained health
     *
     * @return The amount of health regained
     */
    @Param(1)
    double amount();

    /**
     * Gets the reason for why the entity is regaining health
     *
     * @return A RegainReason detailing the reason for the entity regaining health
     */
    @Param(2)
    RegainReason regainReason();

    /**
     * Is this event a result of the fast regeneration mechanic
     *
     * @return Whether the event is the result of a fast regeneration mechanic
     */
    @Param(3)
    boolean isFastRegen();

    enum RegainReason {
        /**
         * When a player regains health from regenerating due to Peaceful mode
         * (difficulty=0)
         */
        REGEN,
        /**
         * When a player regains health from regenerating due to their hunger
         * being satisfied
         */
        SATIATED,
        /**
         * When an animal regains health from eating consumables
         */
        EATING,
        /**
         * When an ender dragon regains health from an ender crystal
         */
        ENDER_CRYSTAL,
        /**
         * When a player is healed by a potion or spell
         */
        MAGIC,
        /**
         * When a player is healed over time by a potion or spell
         */
        MAGIC_REGEN,
        /**
         * When a wither is filling its health during spawning
         */
        WITHER_SPAWN,
        /**
         * When an entity is damaged by the Wither potion effect
         */
        WITHER,
        /**
         * Any other reason not covered by the reasons above
         */
        CUSTOM
    }
}
