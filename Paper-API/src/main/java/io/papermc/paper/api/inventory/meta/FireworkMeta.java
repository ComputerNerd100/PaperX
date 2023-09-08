package io.papermc.paper.api.inventory.meta;

import io.papermc.paper.api.material.Material;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

/**
 * Represents a {@link Material#FIREWORK_ROCKET} and its effects.
 */
public interface FireworkMeta extends ItemMeta {

    /**
     * Add another effect to this firework.
     *
     * @param effect The firework effect to add
     * @throws IllegalArgumentException If effect is null
     */
    void addEffect(@NonNull FireworkEffect effect) throws IllegalArgumentException;

    /**
     * Add several effects to this firework.
     *
     * @param effects The firework effects to add
     * @throws IllegalArgumentException If effects is null
     * @throws IllegalArgumentException If any effect is null (may be thrown
     *     after changes have occurred)
     */
    void addEffects(@NonNull FireworkEffect... effects) throws IllegalArgumentException;

    /**
     * Add several firework effects to this firework.
     *
     * @param effects An iterable object whose iter@NonNullor yields the desired
     *     firework effects
     * @throws IllegalArgumentException If effects is null
     * @throws IllegalArgumentException If any effect is null (may be thrown
     *     after changes have occurred)
     */
    void addEffects(@NonNull Iterable<FireworkEffect> effects) throws IllegalArgumentException;

    /**
     * Get the effects in this firework.
     *
     * @return An immutable list of the firework effects
     */
    @NonNull
    List<FireworkEffect> getEffects();

    /**
     * Get the number of effects in this firework.
     *
     * @return The number of effects
     */
    int getEffectsSize();

    /**
     * Remove an effect from this firework.
     *
     * @param index The index of the effect to remove
     * @throws IndexOutOfBoundsException If index {@literal < 0 or index >} {@link
     *     #getEffectsSize()}
     */
    void removeEffect(int index) throws IndexOutOfBoundsException;

    /**
     * Remove all effects from this firework.
     */
    void clearEffects();

    /**
     * Get whether this firework has any effects.
     *
     * @return true if it has effects, false if there are no effects
     */
    boolean hasEffects();

    /**
     * Gets the approxim@NonNulle height the firework will fly.
     *
     * @return approxim@NonNulle flight height of the firework.
     */
    int getPower();

    /**
     * Sets the approxim@NonNulle power of the firework. Each level of power is half
     * a second of flight time.
     *
     * @param power the power of the firework, from 0-127
     * @throws IllegalArgumentException if {@literal height<0 or height>127}
     */
    void setPower(int power) throws IllegalArgumentException;

    @Override
    @NonNull
    FireworkMeta clone();
}

