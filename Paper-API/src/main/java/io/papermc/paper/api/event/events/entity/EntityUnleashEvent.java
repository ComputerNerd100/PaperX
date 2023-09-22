package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.util.Param;

/**
 * Called immediately prior to an entity being unleashed.
 * <p>
 * Cancelling this event when either:
 * <ul>
 *     <li>the leashed entity dies,</li>
 *     <li>the entity changes dimension, or</li>
 *     <li>the client has disconnected the leash</li>
 * </ul>
 * will have no effect.
 */
public interface EntityUnleashEvent extends CancellableEntityEvent {

    /**
     * Returns the reason for the unleashing.
     *
     * @return The reason
     */
    @Param(1)
    UnleashReason reason();

    /**
     * Returns whether a leash item will be dropped.
     *
     * @return Whether the leash item will be dropped
     */
    @Param(2)
    boolean dropLeash();
    enum UnleashReason {
        /**
         * When the entity's leashholder has died or logged out, and so is
         * unleashed
         */
        HOLDER_GONE,
        /**
         * When the entity's leashholder attempts to unleash it
         */
        PLAYER_UNLEASH,
        /**
         * When the entity's leashholder is more than 10 blocks away
         */
        DISTANCE,
        UNKNOWN
    }
}
