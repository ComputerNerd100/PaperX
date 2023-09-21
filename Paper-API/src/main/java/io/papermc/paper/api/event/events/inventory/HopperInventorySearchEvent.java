package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.events.block.BlockResultEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.Inventory;

public interface HopperInventorySearchEvent extends BlockResultEvent {

    /**
     * Gets the {@link Inventory} that the Hopper will use for its
     * source/attached Container.
     *
     * @return the inventory which will be used
     */
    @Param(0)
    Inventory inventory();

    /**
     * Gets the Container type the Hopper is searching for.
     *
     * @return the container type being searched for
     */
    @Param(1)
    ContainerType containerType();

    /**
     * Gets the Block that is being searched for an inventory.
     *
     * @return block being searched for an inventory
     */
    @Param(2)
    Block searchBlock();


    enum ContainerType {

        /**
         * The source container the hopper is looking for.
         *
         * This is the Inventory above the Hopper where it extracts items from.
         */
        SOURCE,
        /**
         * The container the hopper is attached to.
         *
         * This is the Inventory the Hopper pushes items into.
         */
        DESTINATION;
    }
}
