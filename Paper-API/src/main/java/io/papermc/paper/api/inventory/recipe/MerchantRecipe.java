package io.papermc.paper.api.inventory.recipe;

import io.papermc.paper.api.entity.Villager;
import io.papermc.paper.api.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

/**
 * Represents a merchant's trade.
 * <p>
 * Trades can take one or two ingredients, and provide one result. The
 * ingredients' ItemStack amounts are respected in the trade.
 * <p>
 * A trade has a maximum number of uses. A {@link Villager} may periodically
 * replenish its trades by resetting the {@link #getUses uses} of its merchant
 * recipes to <code>0</code>, allowing them to be used again.
 * <p>
 * A trade may or may not reward experience for being completed.
 * <p>
 * During trades, the {@link MerchantRecipe} dynamically adjusts the amount of
 * its first ingredient based on the following criteria:
 * <ul>
 * <li>{@link #getDemand() Demand}: This value is periodically updated by the
 * villager that owns this merchant recipe based on how often the recipe has
 * been used since it has been last restocked in relation to its
 * {@link #getMaxUses maximum uses}. The amount by which the demand influences
 * the amount of the first ingredient is scaled by the recipe's
 * {@link #getPriceMultiplier price multiplier}, and can never be below zero.
 * <li>{@link #getSpecialPrice() Special price}: This value is dynamically
 * updated whenever a player starts and stops trading with a villager that owns
 * this merchant recipe. It is based on the player's individual reputation with
 * the villager, and the player's currently active status effects (see
 * {@link PotionEffectType#HERO_OF_THE_VILLAGE}). The influence of the player's
 * reputation on the special price is scaled by the recipe's
 * {@link #getPriceMultiplier price multiplier}.
 * </ul>
 * The adjusted amount of the first ingredient is calculated by adding up the
 * original amount of the first ingredient, the demand scaled by the recipe's
 * {@link #getPriceMultiplier price multiplier} and truncated to the next lowest
 * integer value greater than or equal to 0, and the special price, and then
 * constraining the resulting value between <code>1</code> and the item stack's
 * {@link io.papermc.paper.api.inventory.ItemStack#getMaxStackSize() maximum stack size}.
 */
public interface MerchantRecipe extends Recipe {

    @Override
    @NonNull ItemStack getResult();
    void addIngredient(@NonNull ItemStack ingredient);
    void removeIngredient(@NonNull ItemStack ingredient);
    void setIngredients(@NonNull List<ItemStack> ingredients);
    @NonNull List<ItemStack> getIngredients();

    /**
     * Gets the {@link #adjust(ItemStack) adjusted} first ingredient.
     *
     * @return the adjusted first ingredient, or <code>null</code> if this
     * recipe has no ingredients
     * @see #adjust(ItemStack)
     */
    @Nullable ItemStack getAdjustedIngredient1();

    /**
     * Modifies the amount of the given {@link ItemStack} in the same way as
     * MerchantRecipe dynamically adjusts the amount of the first ingredient
     * during trading.
     * <br>
     * This is calculated by adding up the original amount of the item, the
     * demand scaled by the recipe's
     * {@link #getPriceMultiplier price multiplier} and truncated to the next
     * lowest integer value greater than or equal to 0, and the special price,
     * and then constraining the resulting value between <code>1</code> and the
     * {@link ItemStack}'s {@link ItemStack#getMaxStackSize()
     * maximum stack size}.
     *
     * @param itemStack the item to adjust
     */
    void adjust(@Nullable ItemStack itemStack);

    /**
     * Get the demand for this trade.
     *
     * @return the demand
     */
    int getDemand();

    /**
     * Set the demand for this trade.
     *
     * @param demand the new demand
     */
    void setDemand(int demand);

    /**
     * Get the special price for this trade.
     *
     * @return special price value
     */
    int getSpecialPrice();

    /**
     * Set the special price for this trade.
     *
     * @param specialPrice special price value
     */
    void setSpecialPrice(int specialPrice);

    /**
     * Get the number of times this trade has been used.
     *
     * @return the number of uses
     */
    int getUses();

    /**
     * Set the number of times this trade has been used.
     *
     * @param uses the number of uses
     */
    void setUses(int uses);

    /**
     * Get the maximum number of uses this trade has.
     *
     * @return the maximum number of uses
     */
    int getMaxUses();

    /**
     * Set the maximum number of uses this trade has.
     *
     * @param maxUses the maximum number of times this trade can be used
     */
    void setMaxUses(int maxUses);

    /**
     * Whether to reward experience to the player for the trade.
     *
     * @return whether to reward experience to the player for completing this
     * trade
     */
    boolean hasExperienceReward();

    /**
     * Set whether to reward experience to the player for the trade.
     *
     * @param flag whether to reward experience to the player for completing
     * this trade
     */
    void setExperienceReward(boolean flag);

    /**
     * Gets the amount of experience the villager earns from this trade.
     *
     * @return villager experience
     */
    int getVillagerExperience();

    /**
     * Sets the amount of experience the villager earns from this trade.
     *
     * @param villagerExperience new experience amount
     */
    void setVillagerExperience(int villagerExperience);

    /**
     * Gets the price multiplier for the cost of this trade.
     *
     * @return price multiplier
     */
    float getPriceMultiplier();

    /**
     * Sets the price multiplier for the cost of this trade.
     *
     * @param priceMultiplier new price multiplier
     */
    void setPriceMultiplier(float priceMultiplier);

    /**
     * @return Whether all discounts on this trade should be ignored.
     */
    boolean shouldIgnoreDiscounts();

    /**
     * @param ignoreDiscounts Whether all discounts on this trade should be ignored.
     */
    void setIgnoreDiscounts(boolean ignoreDiscounts);
}
