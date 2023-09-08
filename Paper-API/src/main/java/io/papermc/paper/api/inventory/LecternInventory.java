package io.papermc.paper.api.inventory;

import io.papermc.paper.api.block.tilestate.Lectern;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Interface to the inventory of a Lectern.
 */
public interface LecternInventory extends Inventory {

    @Nullable
    @Override
    Lectern getHolder();

    /**
     * Gets the lectern's held book.
     *
     * @return book set in the lectern
     */
    @Nullable
    default ItemStack getBook() {
        return getItem(0);
    }

    /**
     * Sets the lectern's held book.
     *
     * @param book the new book
     */
    default void setBook(@Nullable ItemStack book) {
        setItem(0, book);
    }
}

