package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a Witch
 */
public interface Witch extends Raider, RangedEntity {

    /**
     * Gets whether the witch is drinking a potion
     *
     * @return whether the witch is drinking a potion
     */
    boolean isDrinkingPotion();

    /**
     * Get time remaining (in ticks) the Witch is drinking a potion
     *
     * @return Time remaining (in ticks)
     */
    int getPotionUseTimeLeft();

    /**
     * Set time remaining (in ticks) that the Witch is drinking a potion.
     * <p>
     * This only has an effect while the Witch is drinking a potion.
     *
     * @param ticks Time in ticks remaining
     * @see #isDrinkingPotion
     */
    void setPotionUseTimeLeft(int ticks);

    /**
     * Get the potion the Witch is drinking
     *
     * @return The potion the witch is drinking
     */
    @Nullable ItemStack getDrinkingPotion();

    /**
     * Set the potion the Witch should drink
     *
     * @param potion Potion to drink
     */
    void setDrinkingPotion(@Nullable ItemStack potion);
}
