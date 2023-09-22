package io.papermc.paper.api.entity;

import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Locale;

/**
 * A Frog.
 */
public interface Frog extends Animals {

    /**
     * Gets the tongue target of this frog.
     *
     * @return tongue target or null if not set
     */
    @Nullable
    Entity getTongueTarget();

    /**
     * Sets the tongue target of this frog.
     *
     * @param target tongue target or null to clear
     */
    void setTongueTarget(@Nullable Entity target);

    /**
     * Get the variant of this frog.
     *
     * @return frog variant
     */
    @NonNull
    Variant getVariant();

    /**
     * Set the variant of this frog.
     *
     * @param variant frog variant
     */
    void setVariant(@NonNull Variant variant);

    /**
     * Represents the variant of a frog - ie its color.
     */
    enum Variant implements Keyed {

        /**
         * Temperate (brown-orange) frog.
         */
        TEMPERATE,
        /**
         * Warm (gray) frog.
         */
        WARM,
        /**
         * Cold (green) frog.
         */
        COLD;
        private final NamespacedKey key;

        Variant() {
            this.key = NamespacedKey.minecraft(name().toLowerCase(Locale.ROOT));
        }

        @NonNull
        @Override
        public NamespacedKey getKey() {
            return key;
        }
    }
}

