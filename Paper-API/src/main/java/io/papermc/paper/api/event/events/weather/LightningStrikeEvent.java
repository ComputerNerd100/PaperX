package io.papermc.paper.api.event.events.weather;

import io.papermc.paper.api.entity.LightningStrike;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;

/**
 * Stores data for lightning striking
 */
public interface LightningStrikeEvent extends WeatherEvent, Cancellable {

    /**
     * Gets the bolt which is striking the earth.
     *
     * @return lightning entity
     */
    @Param(1)
    LightningStrike bolt();

    /**
     * Gets the cause of this lightning strike.
     *
     * @return strike cause
     */
    @Param(2)
    Cause cause();

    enum Cause {
        /**
         * Triggered by the /summon command.
         */
        COMMAND,
        /**
         * Triggered by a Plugin.
         */
        CUSTOM,
        /**
         * Triggered by a Spawner.
         */
        SPAWNER,
        /**
         * Triggered by an enchanted trident.
         */
        TRIDENT,
        /**
         * Triggered by a skeleton horse trap.
         */
        TRAP,
        /**
         * Triggered by weather.
         */
        WEATHER,
        /**
         * Unknown trigger.
         */
        UNKNOWN;
    }
}
