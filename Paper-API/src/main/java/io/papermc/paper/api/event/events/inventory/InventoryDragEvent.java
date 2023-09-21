package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.entity.HumanEntity;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.Inventory;
import io.papermc.paper.api.inventory.InventoryView;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.location.Location;

import java.util.Map;
import java.util.Set;

/**
 * This event is called when the player drags an item in their cursor across
 * the inventory. The ItemStack is distributed across the slots the
 * HumanEntity dragged over. The method of distribution is described by the
 * DragType returned by {@link #type()}.
 * <p>
 * Canceling this event will result in none of the changes described in
 * {@link #addedItems()} being applied to the Inventory.
 * <p>
 * Because InventoryDragEvent occurs within a modification of the Inventory,
 * not all Inventory related methods are safe to use.
 * <p>
 * The following should never be invoked by an EventHandler for
 * InventoryDragEvent using the HumanEntity or InventoryView associated with
 * this event.
 * <ul>
 * <li>{@link HumanEntity#closeInventory()}
 * <li>{@link HumanEntity#openInventory(Inventory)}
 * <li>{@link HumanEntity#openWorkbench(Location, boolean)}
 * <li>{@link HumanEntity#openEnchanting(Location, boolean)}
 * <li>{@link InventoryView#close()}
 * </ul>
 * To invoke one of these methods, schedule a task using
 * {@link PaperScheduler#runTask(Plugin, Runnable)}, which will run the task
 * on the next tick.  Also be aware that this is not an exhaustive list, and
 * other methods could potentially create issues as well.
 * <p>
 * Assuming the EntityHuman associated with this event is an instance of a
 * Player, manipulating the MaxStackSize or contents of an Inventory will
 * require an Invocation of {@link Player#updateInventory()}.
 * <p>
 * Any modifications to slots that are modified by the results of this
 * InventoryDragEvent will be overwritten. To change these slots, this event
 * should be cancelled and the changes applied. Alternatively, scheduling a
 * task using {@link PaperScheduler#runTask(Plugin, Runnable)}, which would
 * execute the task on the next tick, would work as well.
 */
public interface InventoryDragEvent extends InventoryInteractEvent {

    /**
     * Gets the DragType that describes the behavior of ItemStacks placed
     * after this InventoryDragEvent.
     * <p>
     * The ItemStacks and the raw slots that they're being applied to can be
     * found using {@link #getNewItems()}.
     *
     * @return the DragType of this InventoryDragEvent
     */
    @Param(2)
    DragType type();

    /**
     * Gets all items to be added to the inventory in this drag.
     *
     * @return map from raw slot id to new ItemStack
     */
    @Param(3)
    Map<Integer, ItemStack> addedItems();

    /**
     * Gets the raw slot ids to be changed in this drag.
     *
     * @return list of raw slot ids, suitable for getView().getItem(int)
     */
    @Param(4)
    Set<Integer> containerSlots();

    /**
     * Gets an ItemStack representing the cursor prior to any modifications
     * as a result of this drag.
     *
     * @return the original cursor
     */
    @Param(5)
    ItemStack oldCursor();

    /**
     * Gets the result cursor after the drag is done. The returned value is
     * mutable.
     *
     * @return the result cursor
     */
    @Param(6)
    ItemStack newCursor();
}
