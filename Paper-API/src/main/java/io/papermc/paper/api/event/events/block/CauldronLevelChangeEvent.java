package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.BlockState;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.event.util.Param;

public interface CauldronLevelChangeEvent extends CancellableBlockEvent {

    /**
     * Get entity which did this. May be null.
     *
     * @return acting entity
     */
    @Param(1)
    Entity entity();
    @Param(2)
    ChangeReason reason();

    /**
     * Gets the new state of the cauldron.
     *
     * @return The block state of the block that will be changed
     */
    @Param(3)
    BlockState newState();

    enum ChangeReason {
        /**
         * Player emptying the cauldron by filling their bucket.
         */
        BUCKET_FILL,
        /**
         * Player filling the cauldron by emptying their bucket.
         */
        BUCKET_EMPTY,
        /**
         * Player emptying the cauldron by filling their bottle.
         */
        BOTTLE_FILL,
        /**
         * Player filling the cauldron by emptying their bottle.
         */
        BOTTLE_EMPTY,
        /**
         * Player cleaning their banner.
         */
        BANNER_WASH,
        /**
         * Player cleaning their armor.
         */
        ARMOR_WASH,
        /**
         * Player cleaning a shulker box.
         */
        SHULKER_WASH,
        /**
         * Entity being extinguished.
         */
        EXTINGUISH,
        /**
         * Evaporating due to biome dryness.
         */
        EVAPORATE,
        /**
         * Filling due to natural fluid sources, eg rain or dripstone.
         */
        NATURAL_FILL,
        /**
         * Unknown.
         */
        UNKNOWN
    }

}
