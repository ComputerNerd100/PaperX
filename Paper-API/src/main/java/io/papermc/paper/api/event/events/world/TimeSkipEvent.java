package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when the time skips in a world.
 * <p>
 * If the event is cancelled the time will not change.
 */
public interface TimeSkipEvent extends CancellableWorldEvent {

    /**
     * Gets the reason why the time has skipped.
     *
     * @return a SkipReason value detailing why the time has skipped
     */
    @Param(1)
    SkipReason skipReason();

    /**
     * Gets the amount of time that was skipped.
     *
     * @return Amount of time skipped
     */
    @Param(2)
    long skipAmount();

    /**
     * An enum specifying the reason the time skipped.
     */
    enum SkipReason {

        /**
         * When time is changed using the vanilla /time command.
         */
        COMMAND,
        /**
         * When time is changed by a plugin.
         */
        CUSTOM,
        /**
         * When time is changed by all players sleeping in their beds and the
         * night skips.
         */
        NIGHT_SKIP
    }
}
