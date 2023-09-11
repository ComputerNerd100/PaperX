package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.inventory.meta.PotionMeta;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;

/**
 * Represents a thrown potion bottle
 */
public interface ThrownPotion extends ThrowableProjectile {

    /**
     * Returns the effects that are applied by this potion.
     *
     * @return The potion effects
     */
    @NonNull
    public Collection<PotionEffect> getEffects();

    /**
     * Returns a copy of the ItemStack for this thrown potion.
     * <p>
     * Altering this copy will not alter the thrown potion directly. If you want
     * to alter the thrown potion, you must use the {@link
     * #setItem(ItemStack) setItemStack} method.
     *
     * @return A copy of the ItemStack for this thrown potion.
     */
    @NonNull
    public ItemStack getItem();

    /**
     * Set the ItemStack for this thrown potion.
     *
     * @param item New ItemStack
     */
    public void setItem(@NonNull ItemStack item);

    /**
     * Gets a copy of the PotionMeta for this thrown potion.
     * This includes what effects will be applied by this potion.
     *
     * @return potion meta
     */
    @NonNull
    PotionMeta getPotionMeta();

    /**
     * Sets the PotionMeta of this thrown potion.
     * This will modify the effects applied by this potion.
     * <p>
     * Note that the type of {@link #getItem()} is irrelevant
     *
     * @param meta potion meta
     */
    void setPotionMeta(@NonNull PotionMeta meta);

    /**
     * Splashes the potion at its current location.
     */
    void splash();
}
