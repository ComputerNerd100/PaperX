package io.papermc.paper.api.command.cloud.commandframework.paper.data;

import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Intermediary result for an argument which parses a {@link Material} and optional NBT data.
 *
 * @since 1.5.0
 */
public interface ProtoItemStack {

    /**
     * Get the {@link Material} of this {@link ProtoItemStack}.
     *
     * @return the {@link Material}
     * @since 1.5.0
     */
    @NonNull Material material();

    /**
     * Get whether this {@link ProtoItemStack} contains extra data besides the {@link Material}.
     *
     * @return whether there is extra data
     * @since 1.5.0
     */
    boolean hasExtraData();

    /**
     * Create a new {@link ItemStack} from the state of this {@link ProtoItemStack}.
     *
     * @param stackSize               stack size
     * @param respectMaximumStackSize whether to respect the maximum stack size for the material
     * @return the created {@link ItemStack}
     * @throws IllegalArgumentException if the {@link ItemStack} could not be created, due to max stack size or other reasons
     * @since 1.5.0
     */
    @NonNull ItemStack createItemStack(int stackSize, boolean respectMaximumStackSize)
            throws IllegalArgumentException;
}

