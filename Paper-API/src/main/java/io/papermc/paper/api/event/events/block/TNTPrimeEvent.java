package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a block of TNT in the world become primed.
 * <p>
 * If a TNT Prime event is cancelled, the block of TNT will not become primed.
 */
public interface TNTPrimeEvent extends CancellableBlockEvent {

    /**
     * Get the cause of the TNT becoming primed.
     *
     * @return the cause
     */
    @Param(1)
    PrimeCause igniteCause();

    /**
     * Get the entity that caused the TNT to be primed.
     *
     * @return the entity that caused the TNT to be primed, or null if it was
     * not caused by an entity.
     */
    @Param(2)
    Entity primingEntity();

    /**
     * Get the block that caused the TNT to be primed.
     *
     * @return the block that caused the TNT to be primed, or null if it was not
     * caused by a block.
     */
    @Param(3)
    Block primingBlock();

    /**
     * An enum to represent the cause of a TNT block becoming primed.
     */
    enum PrimeCause {

        /**
         * When TNT is primed by fire spreading.
         */
        FIRE,
        /**
         * When TNT is primed by a redstone signal.
         */
        REDSTONE,
        /**
         * When TNT is primed by a player interacting with it directly.
         */
        PLAYER,
        /**
         * When TNT is primed by a nearby explosion.
         */
        EXPLOSION,
        /**
         * When TNT is primed after getting hit with a burning projectile.
         */
        PROJECTILE,
        /**
         * When TNT with the unstable block state set to true is broken.
         * <p>
         * Note: Canceling a prime event with this cause will stop the primed
         * TNT from spawning but will not stop the block from being broken.
         */
        BLOCK_BREAK,
        /**
         * When TNT is primed by a dispenser holding flint and steel.
         * <p>
         * Note: This event is not called for a dispenser dispensing TNT
         * directly.
         */
        DISPENSER;
    }

}
