package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

import java.util.List;

/**
 * Called when a portal is created
 */
public interface PortalCreateEvent extends CancellableWorldEvent {

    /**
     * Gets an array list of all the blocks associated with the created portal
     *
     * @return array list of all the blocks associated with the created portal
     */
    @Param(1)
    List<BlockState> blocks();

    /**
     * Returns the Entity that triggered this portal creation (if available)
     *
     * @return Entity involved in this event
     */
    @Param(2)
    Entity entity();

    /**
     * Gets the reason for the portal's creation
     *
     * @return CreateReason for the portal's creation
     */
    @Param(3)
    CreateReason reason();

    /**
     * An enum to specify the various reasons for a portal's creation
     */
    enum CreateReason {
        /**
         * When the blocks inside a portal are created due to a portal frame
         * being set on fire.
         */
        FIRE,
        /**
         * When a nether portal frame and portal is created at the exit of an
         * entered nether portal.
         */
        NETHER_PAIR,
        /**
         * When the target end platform is created as a result of a player
         * entering an end portal.
         */
        END_PLATFORM
    }
}
