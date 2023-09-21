package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Creeper;
import io.papermc.paper.api.entity.LightningStrike;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a Creeper is struck by lightning.
 * <p>
 * If a Creeper Power event is cancelled, the Creeper will not be powered.
 */
public interface CreeperPowerEvent extends CancellableEntityEvent {
    default Creeper creeper() {
        return (Creeper) entity();
    }

    /**
     * Gets the cause of the creeper being (un)powered.
     *
     * @return A PowerCause value detailing the cause of change in power.
     */
    @Param(1)
    PowerCause cause();

    /**
     * Gets the lightning bolt which is striking the Creeper.
     *
     * @return The Entity for the lightning bolt which is striking the Creeper
     */
    @Param(2)
    LightningStrike lightningStrike();

    enum PowerCause {
        /**
         * Power change caused by a lightning bolt
         * <p>
         * Powered state: true
         */
        LIGHTNING,
        /**
         * Power change caused by something else (probably a plugin)
         * <p>
         * Powered state: true
         */
        SET_ON,
        /**
         * Power change caused by something else (probably a plugin)
         * <p>
         * Powered state: false
         */
        SET_OFF
    }
}
