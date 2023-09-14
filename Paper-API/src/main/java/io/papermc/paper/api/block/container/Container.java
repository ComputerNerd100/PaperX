package io.papermc.paper.api.block.container;

import io.papermc.paper.api.block.tilestate.LockableTileState;
import io.papermc.paper.api.inventory.BlockInventoryHolder;
import io.papermc.paper.api.inventory.Inventory;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a captured state of a container block.
 */
public interface Container extends LockableTileState, BlockInventoryHolder {

    /**
     * Gets the inventory of the block represented by this block state.
     * <p>
     * If the block was changed to a different type in the meantime, the
     * returned inventory might no longer be valid.
     * <p>
     * If this block state is not placed this will return the captured inventory
     * snapshot instead.
     *
     * @return the inventory
     */
    @NonNull
    @Override
    Inventory getInventory();

    /**
     * Gets the captured inventory snapshot of this container.
     * <p>
     * The returned inventory is not linked to any block. Any modifications to
     * the returned inventory will not be applied to the block represented by
     * this block state up until {@link #update(boolean, boolean)} has been
     * called.
     *
     * @return the captured inventory snapshot
     */
    @NonNull
    Inventory getSnapshotInventory();
}
