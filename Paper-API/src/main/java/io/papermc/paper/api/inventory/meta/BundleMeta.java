package io.papermc.paper.api.inventory.meta;

import io.papermc.paper.api.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

public interface BundleMeta extends ItemMeta {

    /**
     * Returns whether the item has any items.
     *
     * @return whether items are present
     */
    boolean hasItems();

    /**
     * Returns an immutable list of the items stored in this item.
     *
     * @return items
     */
    @NonNull
    List<ItemStack> getItems();

    /**
     * Sets the items stored in this item.
     *
     * Removes all items when given null.
     *
     * @param items the items to set
     */
    void setItems(@Nullable List<ItemStack> items);

    /**
     * Adds an item to this item.
     *
     * @param item item to add
     */
    void addItem(@NonNull ItemStack item);
}

