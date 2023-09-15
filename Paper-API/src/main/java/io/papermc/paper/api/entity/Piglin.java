package io.papermc.paper.api.entity;

import io.papermc.paper.api.inventory.InventoryHolder;
import io.papermc.paper.api.material.Material;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Set;

/**
 * Represents a Piglin.
 */
public interface Piglin extends PiglinAbstract, InventoryHolder, RangedEntity {

    /**
     * Get whether the piglin is able to hunt hoglins.
     *
     * @return Whether the piglin is able to hunt hoglins
     */
    public boolean isAbleToHunt();

    /**
     * Sets whether the piglin is able to hunt hoglins.
     *
     * @param flag Whether the piglin is able to hunt hoglins.
     */
    public void setIsAbleToHunt(boolean flag);

    /**
     * Adds a material to the allowed list of materials to barter with.
     *
     * @param material The material to add
     *
     * @return true if the item has been added successfully, false otherwise
     */
    public boolean addBarterMaterial(@NonNull Material material);

    /**
     * Removes a material from the allowed list of materials to barter with.
     *
     * <strong>Note:</strong> It's not possible to override the default
     * bartering item gold_ingots as payment. To block gold_ingots see
     * {@link PiglinBarterEvent}.
     *
     * @param material The material to remove
     *
     * @return true if the item has been removed successfully, false otherwise
     */
    public boolean removeBarterMaterial(@NonNull Material material);

    /**
     * Adds a material the piglin will pickup and store in his inventory.
     *
     * @param material The material you want the piglin to be interested in
     *
     * @return true if the item has been added successfully, false otherwise
     */
    public boolean addMaterialOfInterest(@NonNull Material material);

    /**
     * Removes a material from the list of materials the piglin will pickup.
     *
     * <strong>Note:</strong> It's not possible to override the default list of
     * item the piglin will pickup. To cancel pickup see
     * {@link EntityPickupItemEvent}.
     *
     * @param material The material you want removed from the interest list
     * @return true if the item has been removed successfully, false otherwise
     */
    public boolean removeMaterialOfInterest(@NonNull Material material);

    /**
     * Returns a immutable set of materials the piglins will pickup.
     * <br>
     * <strong>Note:</strong> This set will not include the items that are set
     * by default. To interact with those items see
     * {@link EntityPickupItemEvent}.
     *
     * @return An immutable materials set
     */
    @NonNull
    public Set<Material> getInterestList();

    /**
     * Returns a immutable set of materials the piglins will barter with.
     *
     * <strong>Note:</strong> This set will not include the items that are set
     * by default. To interact with those items see
     * {@link PiglinBarterEvent}.
     *
     * @return An immutable materials set
     */
    @NonNull
    public Set<Material> getBarterList();

    // Paper start
    /**
     * Causes the piglin to appear as if they are charging
     * a crossbow.
     * <p>
     * This works with any item currently held in the piglin's hand.
     *
     * @param chargingCrossbow is charging
     */
    void setChargingCrossbow(boolean chargingCrossbow);

    /**
     * Gets if the piglin is currently charging the
     * item in their hand.
     *
     * @return is charging
     */
    boolean isChargingCrossbow();
}

