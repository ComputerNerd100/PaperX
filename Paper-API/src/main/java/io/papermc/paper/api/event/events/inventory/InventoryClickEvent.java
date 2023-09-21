package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.entity.HumanEntity;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.Inventory;
import io.papermc.paper.api.inventory.InventoryType;
import io.papermc.paper.api.inventory.InventoryView;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.location.Location;

/**
 * This event is called when a player clicks in an inventory.
 * <p>
 * Because InventoryClickEvent occurs within a modification of the Inventory,
 * not all Inventory related methods are safe to use.
 * <p>
 * Methods that change the view a player is looking at should never be invoked
 * by an EventHandler for InventoryClickEvent using the HumanEntity or
 * InventoryView associated with this event.
 * Examples of these include:
 * <ul>
 * <li>{@link HumanEntity#closeInventory()}
 * <li>{@link HumanEntity#openInventory(Inventory)}
 * <li>{@link HumanEntity#openWorkbench(Location, boolean)}
 * <li>{@link HumanEntity#openEnchanting(Location, boolean)}
 * <li>{@link InventoryView#close()}
 * </ul>
 * To invoke one of these methods, schedule a task using
 * {@link PaperScheduler#runTask(Plugin, Runnable)}, which will run the task
 * on the next tick. Also be aware that this is not an exhaustive list, and
 * other methods could potentially create issues as well.
 * <p>
 * Assuming the EntityHuman associated with this event is an instance of a
 * Player, manipulating the MaxStackSize or contents of an Inventory will
 * require an Invocation of {@link Player#updateInventory()}.
 * <p>
 * Modifications to slots that are modified by the results of this
 * InventoryClickEvent can be overwritten. To change these slots, this event
 * should be cancelled and all desired changes to the inventory applied.
 * Alternatively, scheduling a task using {@link PaperScheduler#runTask(
 * Plugin, Runnable)}, which would execute the task on the next tick, would
 * work as well.
 */
public interface InventoryClickEvent extends InventoryInteractEvent {

    /**
     * Gets the ClickType for this event.
     * <p>
     * This is insulated against changes to the inventory by other plugins.
     *
     * @return the type of inventory click
     */
    @Param(2)
    ClickType click();

    /**
     * Gets the InventoryAction that triggered this event.
     * <p>
     * This action cannot be changed, and represents what the normal outcome
     * of the event will be. To change the behavior of this
     * InventoryClickEvent, changes must be manually applied.
     *
     * @return the InventoryAction that triggered this event.
     */
    @Param(3)
    InventoryAction action();

    /**
     * Gets the type of slot that was clicked.
     *
     * @return the slot type
     */
    @Param(4)
    InventoryType.SlotType slotType();

    /**
     * The slot number that was clicked, ready for passing to
     * {@link Inventory#getItem(int)}. Note that there may be two slots with
     * the same slot number, since a view links two different inventories.
     *
     * @return The slot number.
     */
    @Param(5)
    int whichSlot();

    /**
     * The raw slot number clicked, ready for passing to {@link InventoryView
     * #getItem(int)} This slot number is unique for the view.
     *
     * @return the slot number
     */
    @Param(6)
    int rawSlot();

    /**
     * Gets the ItemStack currently in the clicked slot.
     *
     * @return the item in the clicked slot
     */
    @Param(7)
    ItemStack current();

    /**
     * If the ClickType is NUMBER_KEY, this method will return the index of
     * the pressed key (0-8).
     *
     * @return the number on the key minus 1 (range 0-8); or -1 if not
     *     a NUMBER_KEY action
     */
    @Param(8)
    int hotbarKey();
}
