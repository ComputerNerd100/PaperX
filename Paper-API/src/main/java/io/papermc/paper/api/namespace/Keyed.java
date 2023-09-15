package io.papermc.paper.api.namespace;

import net.kyori.adventure.key.Key;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents an object which has a {@link NamespacedKey} attached to it.
 */
public interface Keyed extends net.kyori.adventure.key.Keyed {

    /**
     * Return the namespaced identifier for this object.
     *
     * @return this object's key
     */
    @NonNull
    NamespacedKey getKey();

    /**
     * Returns the unique identifier for this object.
     *
     * @return this object's key
     */
    @Override
    default @NonNull Key key() {
        return this.getKey();
    }
}
