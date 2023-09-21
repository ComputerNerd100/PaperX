package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.util.game.GameRule;

import java.util.List;

/**
 * Called when an entity explodes interacting with blocks. The
 * event isn't called if the {@link GameRule#MOB_GRIEFING}
 * is disabled as no block interaction will occur.
 */
public interface EntityExplodeEvent extends CancellableEntityEvent {

    /**
     * Returns the location where the explosion happened.
     * <p>
     * It is not possible to get this value from the Entity as the Entity no
     * longer exists in the world.
     *
     * @return The location of the explosion
     */
    @Param(1)
    Location location();

    /**
     * Returns the list of blocks that would have been removed or were removed
     * from the explosion event.
     *
     * @return All blown-up blocks
     */
    @Param(2)
    List<Block> blocks();

    /**
     * Returns the percentage of blocks to drop from this explosion
     *
     * @return The yield.
     */
    @Param(3)
    float yield();
}
