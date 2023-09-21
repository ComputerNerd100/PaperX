package io.papermc.paper.api.event.events.raid;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.Raid;

/**
 * Called when a {@link Raid} is stopped.
 */
public interface RaidStopEvent extends RaidEvent {

    /**
     * Returns the stop reason.
     *
     * @return Reason
     */
    @Param(2)
    Reason reason();

    enum Reason {
        /**
         * Because the difficulty has been changed to peaceful.
         */
        PEACE,
        /**
         * The raid took a long time without a final result.
         */
        TIMEOUT,
        /**
         * Finished the raid.
         */
        FINISHED,
        /**
         * Couldn't find a suitable place to spawn raiders.
         */
        UNSPAWNABLE,
        /**
         * The place where the raid occurs no longer be a village.
         */
        NOT_IN_VILLAGE
    }
}
