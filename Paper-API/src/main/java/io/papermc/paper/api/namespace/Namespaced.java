package io.papermc.paper.api.namespace;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a namespaced resource, see {@link NamespacedKey} for single elements
 * or {@link NamespacedTag} for a collection of elements
 * Namespaces may only contain lowercase alphanumeric characters, periods,
 * underscores, and hyphens.
 * <p>
 * Keys may only contain lowercase alphanumeric characters, periods,
 * underscores, hyphens, and forward slashes.
 * <p>
 * You should not be implementing this interface yourself, use {@link NamespacedKey}
 * or {@link NamespacedTag} as needed instead.
 */
public interface Namespaced {
    /**
     * Gets the namespace this resource is a part of
     * <p>
     * This is contractually obligated to only contain lowercase alphanumeric characters,
     * periods, underscores, and hyphens.
     *
     * @return resource namespace
     */
    @NonNull
    String getNamespace();

    /**
     * Gets the key corresponding to this resource
     * <p>
     * This is contractually obligated to only contain lowercase alphanumeric characters,
     * periods, underscores, hyphens, and forward slashes.
     *
     * @return resource key
     */
    @NonNull
    String getKey();
}
