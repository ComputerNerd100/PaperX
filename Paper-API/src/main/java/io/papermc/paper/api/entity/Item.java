package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

/**
 * Represents a dropped item.
 */
public interface Item extends Entity, Frictional { 

    /**
     * Gets the item stack associated with this item drop.
     *
     * @return An item stack.
     */
    @NonNull ItemStack getItemStack();

    /**
     * Sets the item stack associated with this item drop.
     *
     * @param stack An item stack.
     */
    void setItemStack(@NonNull ItemStack stack);

    /**
     * Gets the delay before this Item is available to be picked up by players
     *
     * @return Remaining delay
     */
    int getPickupDelay();

    /**
     * Sets the delay before this Item is available to be picked up by players
     *
     * @param delay New delay
     */
    void setPickupDelay(int delay);

    /**
     * Sets if this Item should live forever
     *
     * @param unlimited true if the lifetime is unlimited
     */
    void setUnlimitedLifetime(boolean unlimited);

    /**
     * Gets if this Item lives forever
     *
     * @return true if the lifetime is unlimited
     */
    boolean isUnlimitedLifetime();

    /**
     * Sets the owner of this item.
     *
     * Other entities will not be able to pickup this item when an owner is set.
     *
     * @param owner UUID of new owner
     */
    void setOwner(@Nullable UUID owner);

    /**
     * Get the owner of this item.
     *
     * @return UUID of owner
     */
    @Nullable UUID getOwner();

    /**
     * Set the thrower of this item.
     *
     * The thrower is the entity which dropped the item. This affects the
     * trigger criteria for item pickups, for things such as advancements.
     *
     * @param uuid UUID of thrower
     */
    void setThrower(@Nullable UUID uuid);

    /**
     * Get the thrower of this item.
     *
     * The thrower is the entity which dropped the item.
     *
     * @return UUID of thrower
     */
    @Nullable UUID getThrower();

    /**
     * Gets if non-player entities can pick this Item up
     *
     * @return True if non-player entities can pickup
     */
    boolean canMobPickup();

    /**
     * Sets if non-player entities can pick this Item up
     *
     * @param canMobPickup True to allow non-player entity pickup
     */
    void setCanMobPickup(boolean canMobPickup);

    /**
     * Gets whether the player can pickup the item or not
     *
     * @return True if a player can pickup the item
     */
    boolean canPlayerPickup();

    /**
     * Sets whether the item can be picked up or not. Modifies the pickup delay value to do so.
     *
     * @param canPlayerPickup True if the player can pickup the item
     */
    void setCanPlayerPickup(boolean canPlayerPickup);

    /**
     * Gets whether the item will age and despawn from being on the ground too long
     *
     * @return True if the item will age
     */
    boolean willAge();

    /**
     * Sets whether the item will age or not. If the item is not ageing, it will not despawn
     * by being on the ground for too long.
     *
     * @param willAge True if the item should age
     */
    void setWillAge(boolean willAge);

    /**
     * Gets the health of item stack.
     * <p>
     * Currently the default max health is 5.
     *
     * @return the health
     */
    int getHealth();

    /**
     * Sets the health of the item stack. If the value is non-positive
     * the itemstack's normal "on destroy" functionality will be run.
     * <p>
     * Currently, the default max health is 5.
     *
     * @param health the health, a non-positive value will destroy the entity
     */
    void setHealth(int health);
}
