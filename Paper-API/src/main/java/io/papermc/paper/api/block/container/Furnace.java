package io.papermc.paper.api.block.container;

import io.papermc.paper.api.namespace.NamespacedKey;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Represents a captured state of a furnace.
 */
public interface Furnace extends Container {

    /**
     * Get burn time.
     *
     * @return Burn time
     */
    short getBurnTime();

    /**
     * Set burn time.
     *
     * A burn time greater than 0 will cause this block to be lit, whilst a time
     * less than 0 will extinguish it.
     *
     * @param burnTime Burn time
     */
    void setBurnTime(short burnTime);

    /**
     * Get cook time.
     *
     * This is the amount of time the item has been cooking for.
     *
     * @return Cook time
     */
    short getCookTime();

    /**
     * Set cook time.
     *
     * This is the amount of time the item has been cooking for.
     *
     * @param cookTime Cook time
     */
    void setCookTime(short cookTime);

    /**
     * Get cook time total.
     *
     * This is the amount of time the item is required to cook for.
     *
     * @return Cook time total
     */
    int getCookTimeTotal();

    /**
     * Set cook time.
     *
     * This is the amount of time the item is required to cook for.
     *
     * @param cookTimeTotal Cook time total
     */
    void setCookTimeTotal(int cookTimeTotal);

    /**
     * Get the recipes used in this furnace.
     *
     * <b>Note:</b> These recipes used are reset when the result item is
     * manually taken from the furnace.
     *
     * @return An immutable map with the recipes used and the times used
     */
    @NotNull
    Map<CookingRecipe<?>, Integer> getRecipesUsed();

    // Paper start
    /**
     * Gets the cook speed multiplier that this {@link Furnace} will cook
     * compared to vanilla.
     *
     * @return the multiplier, a value between 0 and 200
     */
    double getCookSpeedMultiplier();

    /**
     * Sets the speed multiplier that this {@link Furnace} will cook
     * compared to vanilla.
     *
     * @param multiplier the multiplier to set, a value between 0 and 200
     * @throws IllegalArgumentException if value is less than 0
     * @throws IllegalArgumentException if value is more than 200
     */
    void setCookSpeedMultiplier(double multiplier);

    /**
     * Gets the number of times a recipe has been used since the
     * last player removed items from the result slot. This is used
     * to calculate experience rewards when withdrawing items from furnaces.
     *
     * @param furnaceRecipe the recipe to query the count for
     * @return the count or 0 if none found
     */
    int getRecipeUsedCount(@NotNull NamespacedKey furnaceRecipe);

    /**
     * Checks if the recipe has a used count present on this furnace.
     *
     * @param furnaceRecipe the recipe to check if a count exists for
     * @return true if there is a positive count, else false
     */
    boolean hasRecipeUsedCount(@NotNull NamespacedKey furnaceRecipe);

    /**
     * Sets the number of times a recipe has been used. This is used
     * to calculate experience rewards when withdrawing items from furnaces.
     *
     * @param furnaceRecipe the recipe to set the count for
     * @param count the count, a non-positive number will remove the recipe
     */
    void setRecipeUsedCount(@NotNull CookingRecipe<?> furnaceRecipe, int count);

    /**
     * Sets all recipes used by this furnace.
     *
     * @param recipesUsed the recipes used
     */
    void setRecipesUsed(@NotNull Map<CookingRecipe<?>, Integer> recipesUsed);
    // Paper end

    @NotNull
    @Override
    FurnaceInventory getInventory();

    @NotNull
    @Override
    FurnaceInventory getSnapshotInventory();
}

