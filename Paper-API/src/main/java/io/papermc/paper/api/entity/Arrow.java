package io.papermc.paper.api.entity;

import io.papermc.paper.api.block.color.Color;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

public interface Arrow extends AbstractArrow {

    /**
     * Sets the underlying potion data
     *
     * @param data PotionData to set the base potion state to
     */
    void setBasePotionData(@NonNull PotionData data);

    /**
     * Returns the potion data about the base potion
     *
     * @return a PotionData object
     */
    @NonNull
    PotionData getBasePotionData();

    /**
     * Gets the color of this arrow.
     *
     * @return arrow {@link Color} or null if not color is set
     */
    @Nullable
    Color getColor();

    /**
     * Sets the color of this arrow. Will be applied as a tint to its particles.
     *
     * @param color arrow color, null to clear the color
     */
    void setColor(@Nullable Color color);

    /**
     * Checks for the presence of custom potion effects.
     *
     * @return true if custom potion effects are applied
     */
    boolean hasCustomEffects();

    /**
     * Gets an immutable list containing all custom potion effects applied to
     * this arrow.
     * <p>
     * Plugins should check that hasCustomEffects() returns true before calling
     * this method.
     *
     * @return the immutable list of custom potion effects
     */
    @NonNull
    List<PotionEffect> getCustomEffects();

    /**
     * Adds a custom potion effect to this arrow.
     *
     * @param effect the potion effect to add
     * @param overwrite true if any existing effect of the same type should be
     * overwritten
     * @return true if the effect was added as a result of this call
     */
    boolean addCustomEffect(@NonNull PotionEffect effect, boolean overwrite);

    /**
     * Removes a custom potion effect from this arrow.
     *
     * @param type the potion effect type to remove
     * @return true if the effect was removed as a result of this call
     * @throws IllegalArgumentException if this operation would leave the Arrow
     * in a state with no Custom Effects and PotionType.UNCRAFTABLE
     */
    boolean removeCustomEffect(@NonNull PotionEffectType type);

    /**
     * Checks for a specific custom potion effect type on this arrow.
     *
     * @param type the potion effect type to check for
     * @return true if the potion has this effect
     */
    boolean hasCustomEffect(@Nullable PotionEffectType type);

    /**
     * Removes all custom potion effects from this arrow.
     *
     * @throws IllegalArgumentException if this operation would leave the Arrow
     * in a state with no Custom Effects and PotionType.UNCRAFTABLE
     */
    void clearCustomEffects();
}

