package io.papermc.paper.api.event.events.inventory;

import io.papermc.paper.api.entity.HumanEntity;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.Inventory;
import io.papermc.paper.api.inventory.InventoryView;
import io.papermc.paper.api.location.Location;

/**
 * This event is called when a player closes an inventory.
 * <p>
 * Because InventoryCloseEvent occurs within a modification of the Inventory,
 * not all Inventory related methods are safe to use.
 * <p>
 * Methods that change the view a player is looking at should never be invoked
 * by an EventHandler for InventoryCloseEvent using the HumanEntity or
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
 */
public interface InventoryCloseEvent extends InventoryResultEvent {

    /**
     * Gets the reason for the inventory closing
     * @return the reason
     */
    @Param(0)
    Reason reason();

    enum Reason {
        /**
         * Unknown reason
         */
        UNKNOWN,
        /**
         * Player is teleporting
         */
        TELEPORT,
        /**
         * Player is no longer permitted to use this inventory
         */
        CANT_USE,
        /**
         * The chunk the inventory was in was unloaded
         */
        UNLOADED,
        /**
         * Opening new inventory instead
         */
        OPEN_NEW,
        /**
         * Closed
         */
        PLAYER,
        /**
         * Closed due to disconnect
         */
        DISCONNECT,
        /**
         * The player died
         */
        DEATH,
        /**
         * Closed by Bukkit API
         */
        PLUGIN,
    }
}
