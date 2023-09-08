package io.papermc.paper.api.inventory;

import io.papermc.paper.api.block.container.DoubleChest;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;


/**
 * Interface to the inventory of a Double Chest.
 */
public interface DoubleChestInventory extends Inventory {

    /**
     * Get the left half of this double chest.
     *
     * @return The left side inventory
     */
    @NonNull
    Inventory getLeftSide();

    /**
     * Get the right side of this double chest.
     *
     * @return The right side inventory
     */
    @NonNull
    Inventory getRightSide();

    @Override
    @Nullable
    DoubleChest getHolder();
}

