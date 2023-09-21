package io.papermc.paper.api.event.events.hanging;

import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;

/**
 * Triggered when a hanging entity is removed
 */
public interface HangingBreakEvent extends HangingEvent, Cancellable {

    /**
     * Gets the cause for the hanging entity's removal
     *
     * @return the RemoveCause for the hanging entity's removal
     */
    @Param(1)
    RemoveCause cause();
    enum RemoveCause {
        /**
         * Removed by an entity
         */
        ENTITY,
        /**
         * Removed by an explosion
         */
        EXPLOSION,
        /**
         * Removed by placing a block on it
         */
        OBSTRUCTION,
        /**
         * Removed by destroying the block behind it, etc
         */
        PHYSICS,
        /**
         * Removed by an uncategorised cause
         */
        DEFAULT,
    }
}
