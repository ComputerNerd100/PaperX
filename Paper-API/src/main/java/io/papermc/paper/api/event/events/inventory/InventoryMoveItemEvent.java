package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.Inventory;
import io.papermc.paper.api.inventory.ItemStack;


/**
 * Called when some entity or block (e.g. hopper) tries to move items directly
 * from one inventory to another.
 * <p>
 * When this event is called, the initiator may already have removed the item
 * from the source inventory and is ready to move it into the destination
 * inventory.
 * <p>
 * If this event is cancelled, the items will be returned to the source
 * inventory, if needed.
 * <p>
 * If this event is not cancelled, the initiator will try to put the ItemStack
 * into the destination inventory. If this is not possible and the ItemStack
 * has not been modified, the source inventory slot will be restored to its
 * former state. Otherwise any additional items will be discarded.
 */
public interface InventoryMoveItemEvent extends Event, Cancellable {

    /**
     * Gets the Inventory that the ItemStack is being taken from
     *
     * @return Inventory that the ItemStack is being taken from
     */
    @Param(0)
    Inventory sourceInventory();

    /**
     * Gets the Inventory that the ItemStack is being put into
     *
     * @return Inventory that the ItemStack is being put into
     */
    @Param(1)
    Inventory destinationInventory();

    /**
     * Gets the ItemStack being moved; if modified, the original item will not
     * be removed from the source inventory.
     *
     * @return ItemStack
     */
    @Param(2)
    ItemStack itemStack();

    /**
     * Gets whether the source inventory initiated this event.
     * @return true if the source inventory initiated this event
     */
    @Param(3)
    boolean didSourceInitiate();

    /**
     * TODO: Not sure what this is for
     * @return
     */
    @Param(4)
    boolean calledGetItem();

    /**
     * TODO: Not sure what this is for
     * @return
     */
    @Param(5)
    boolean calledSetItem();
}
