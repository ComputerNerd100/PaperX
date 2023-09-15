package io.papermc.paper.api.inventory.meta;

import io.papermc.paper.api.block.color.Color;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

/**
 * Represents a potion or item that can have custom effects.
 */
public interface PotionMeta extends ItemMeta {

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
     * Checks for the presence of custom potion effects.
     *
     * @return true if custom potion effects are applied
     */
    boolean hasCustomEffects();

    /**
     * Gets an immutable list containing all custom potion effects applied to
     * this potion.
     * <p>
     * Plugins should check that hasCustomEffects() returns true before calling
     * this method.
     *
     * @return the immutable list of custom potion effects
     */
    @NonNull
    List<PotionEffect> getCustomEffects();

    /**
     * Adds a custom potion effect to this potion.
     *
     * @param effect the potion effect to add
     * @param overwrite true if any existing effect of the same type should be
     * overwritten
     * @return true if the potion meta changed as a result of this call
     */
    boolean addCustomEffect(@NonNull PotionEffect effect, boolean overwrite);

    /**
     * Removes a custom potion effect from this potion.
     *
     * @param type the potion effect type to remove
     * @return true if the potion meta changed as a result of this call
     */
    boolean removeCustomEffect(@NonNull PotionEffectType type);

    /**
     * Checks for a specific custom potion effect type on this potion.
     *
     * @param type the potion effect type to check for
     * @return true if the potion has this effect
     */
    boolean hasCustomEffect(@NonNull PotionEffectType type);

    /**
     * Removes all custom potion effects from this potion.
     *
     * @return true if the potion meta changed as a result of this call
     */
    boolean clearCustomEffects();

    /**
     * Checks for existence of a potion color.
     *
     * @return true if this has a custom potion color
     */
    boolean hasColor();

    /**
     * Gets the potion color that is set. A custom potion color will alter the
     * display of the potion in an inventory slot.
     * <p>
     * Plugins should check that hasColor() returns <code>true</code> before
     * calling this method.
     *
     * @return the potion color that is set
     */
    @Nullable
    Color getColor();

    /**
     * Sets the potion color. A custom potion color will alter the display of
     * the potion in an inventory slot.
     *
     * @param color the color to set
     */
    void setColor(@Nullable Color color);

    @Override
    PotionMeta clone();
}
