package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.Projectile;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a projectile hits an object
 */
public interface ProjectileHitEvent extends CancellableEntityEvent {
    default Projectile projectile() {
        return (Projectile) entity();
    }

    /**
     * Gets the entity that was hit, if it was an entity that was hit.
     *
     * @return hit entity or else null
     */
    @Param(1)
    Entity hitEntity();

    /**
     * Gets the block that was hit, if it was a block that was hit.
     *
     * @return hit block or else null
     */
    @Param(2)
    Block hitBlock();

    /**
     * Gets the block face that was hit, if it was a block that was hit and the
     * face was provided in the vent.
     *
     * @return hit face or else null
     */
    @Param(3)
    BlockFace hitFace();
}
