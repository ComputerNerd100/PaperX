package io.papermc.paper.api.inventory;


import io.papermc.paper.api.block.container.ChiseledBookshelf;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Interface to the inventory of a chiseled bookshelf.
 */
public interface ChiseledBookshelfInventory extends Inventory {

    @Nullable
    @Override
    ChiseledBookshelf getHolder();
}
