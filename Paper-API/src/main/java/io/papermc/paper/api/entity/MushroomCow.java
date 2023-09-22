package io.papermc.paper.api.entity;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a mushroom {@link Cow}
 */
public interface MushroomCow extends Cow, Shearable {

    /**
     * Get the variant of this cow.
     *
     * @return cow variant
     */
    @NonNull Variant getVariant();

    /**
     * Set the variant of this cow.
     *
     * @param variant cow variant
     */
    void setVariant(@NonNull Variant variant);

    /**
     * Represents the variant of a cow - ie its color.
     */
    enum Variant {
        /**
         * Red mushroom cow.
         */
        RED,
        /**
         * Brown mushroom cow.
         */
        BROWN
    }

    /**
     * Gets how long the effect applied to stew
     * from this mushroom cow is.
     *
     * @return duration of the effect (in ticks)
     */
    int getStewEffectDuration();

    /**
     * Sets how long the effect applied to stew
     * from this mushroom cow is.
     *
     * @param duration duration of the effect (in ticks)
     */
    void setStewEffectDuration(int duration);

    /**
     * Gets the type of effect applied to stew
     * from this mushroom cow is.
     *
     * @return effect type, or null if an effect is currently not set
     */
    @Nullable
    PotionEffectType getStewEffectType();

    /**
     * Sets the type of effect applied to stew
     * from this mushroom cow is.
     *
     * @param type new effect type
     *             or null if this cow does not give effects
     */
    void setStewEffect(@Nullable PotionEffectType type);
}

