package io.papermc.paper.api.block.tilestate;


import io.papermc.paper.api.block.container.Container;
import io.papermc.paper.api.inventory.BlockInventoryHolder;
import io.papermc.paper.api.inventory.Inventory;
import org.checkerframework.checker.nullness.qual.NonNull;


/**
 * Represents a captured state of a lectern.
 */
public interface Lectern extends TileState, BlockInventoryHolder {

    /**
     * Get the current lectern page.
     *
     * @return current page
     */
    int getPage();

    /**
     * Set the current lectern page.
     *
     * If the page is greater than the number of pages of the book currently in
     * the inventory, then behavior is undefined.
     *
     * @param page new page
     */
    void setPage(int page);

    /**
     * @return inventory
     * @see Container#getInventory()
     */
    @NonNull
    @Override
    Inventory getInventory();

    /**
     * @return snapshot inventory
     * @see Container#getSnapshotInventory()
     */
    @NonNull
    Inventory getSnapshotInventory();
}