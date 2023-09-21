package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a block is ignited. If you want to catch when a Player places
 * fire, you need to use {@link BlockPlaceEvent}.
 * <p>
 * If a Block Ignite event is cancelled, the block will not be ignited.
 */
public interface BlockIgniteEvent extends CancellableBlockEvent {

    /**
     * Gets the cause of block ignite.
     *
     * @return An IgniteCause value detailing the cause of block ignition
     */
    @Param(1)
    IgniteCause cause();

    /**
     * Gets the entity who ignited this block
     *
     * @return The Entity that placed/ignited the fire block, or null if not ignited by a Entity.
     */
    @Param(2)
    Entity ignitingEntity();

    /**
     * Gets the block which ignited this block
     *
     * @return The Block that placed/ignited the fire block, or null if not ignited by a Block.
     */
    @Param(3)
    Block ignitingBlock();

    enum IgniteCause {

        /**
         * Block ignition caused by lava.
         */
        LAVA,
        /**
         * Block ignition caused by a player or dispenser using flint-and-steel.
         */
        FLINT_AND_STEEL,
        /**
         * Block ignition caused by dynamic spreading of fire.
         */
        SPREAD,
        /**
         * Block ignition caused by lightning.
         */
        LIGHTNING,
        /**
         * Block ignition caused by an entity using a fireball.
         */
        FIREBALL,
        /**
         * Block ignition caused by an Ender Crystal.
         */
        ENDER_CRYSTAL,
        /**
         * Block ignition caused by explosion.
         */
        EXPLOSION,
        /**
         * Block ignition caused by a flaming arrow.
         */
        ARROW,
    }

}
