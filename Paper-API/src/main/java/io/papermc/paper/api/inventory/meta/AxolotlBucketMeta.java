package io.papermc.paper.api.inventory.meta;

import io.papermc.paper.api.entity.Axolotl;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a bucket of axolotl.
 */
public interface AxolotlBucketMeta extends ItemMeta {

    /**
     * Get the variant of the axolotl in the bucket.
     * <p>
     * Plugins should check that hasVariant() returns <code>true</code> before
     * calling this method.
     * @return axolotl variant
     */
    Axolotl.@NonNull Variant getVariant();

    /**
     * Set the variant of this axolotl in the bucket.
     *
     * @param variant axolotl variant
     */
    void setVariant(Axolotl.@NonNull Variant variant);

    /**
     * Checks for existence of a variant tag indicating a specific axolotl will be
     * spawned.
     *
     * @return if there is a variant
     */
    boolean hasVariant();

    @Override
    @NonNull
    AxolotlBucketMeta clone();
}

