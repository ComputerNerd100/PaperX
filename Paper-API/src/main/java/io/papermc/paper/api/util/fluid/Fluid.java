package io.papermc.paper.api.util.fluid;

import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Locale;

/**
 * Represents a fluid type.
 */
public enum Fluid implements Keyed {

    // Paper start
    /**
     * No fluid.
     */
    EMPTY,
    // Paper end
    /**
     * Stationary water.
     */
    WATER,
    /**
     * Flowing water.
     */
    FLOWING_WATER,
    /**
     * Stationary lava.
     */
    LAVA,
    /**
     * Flowing lava.
     */
    FLOWING_LAVA;

    private final NamespacedKey key;

    private Fluid() {
        this.key = NamespacedKey.minecraft(this.name().toLowerCase(Locale.ROOT));
    }

    @NonNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }
}

