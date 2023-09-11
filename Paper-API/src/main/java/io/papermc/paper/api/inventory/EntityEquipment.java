package io.papermc.paper.api.inventory;


import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.Mob;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An interface to a creatures inventory
 */
public interface EntityEquipment {

    /**
     * Stores the ItemStack at the given equipment slot in the inventory.
     *
     * @param slot the slot to put the ItemStack
     * @param item the ItemStack to set
     */
    public void setItem(@NonNull EquipmentSlot slot, @Nullable ItemStack item);

    /**
     * Stores the ItemStack at the given equipment slot in the inventory.
     *
     * @param slot the slot to put the ItemStack
     * @param item the ItemStack to set
     * @param silent whether or not the equip sound should be silenced
     */
    public void setItem(@NonNull EquipmentSlot slot, @Nullable ItemStack item, boolean silent);

    /**
     * Gets the ItemStack at the given equipment slot in the inventory.
     *
     * @param slot the slot to get the ItemStack
     * @return the ItemStack in the given slot
     */
    @NonNull
    public ItemStack getItem(@NonNull EquipmentSlot slot);

    /**
     * Gets the item the entity is currently holding
     * in their main hand.
     *
     * <p>
     * This returns a copy if this equipment instance is from a non-player,
     * or it's an empty stack (has AIR as its type).
     * For non-empty stacks from players, this returns a live mirror. You can check if this
     * will return a mirror with
     * <pre>{@code
     * EntityEquipment equipment = entity.getEquipment();
     * if (equipment instanceof PlayerInventory) {
     *     equipment.getItemInMainHand(); // will return a mirror
     * } else {
     *     equipment.getItemInMainHand(); // will return a copy
     * }
     * }</pre>
     *
     * @return the currently held item
     */
    @NonNull
    ItemStack getItemInMainHand();

    /**
     * Sets the item the entity is holding in their main hand.
     *
     * @param item The item to put into the entities hand
     */
    void setItemInMainHand(@Nullable ItemStack item);

    /**
     * Sets the item the entity is holding in their main hand.
     *
     * @param item The item to put into the entities hand
     * @param silent whether or not the equip sound should be silenced
     */
    void setItemInMainHand(@Nullable ItemStack item, boolean silent);

    /**
     * Gets the item the entity is currently holding
     * in their off hand.
     *
     * <p>
     * This returns a copy if this equipment instance is from a non-player,
     * or it's an empty stack (has AIR as its type).
     * For non-empty stacks from players, this returns a live mirror. You can check if this
     * will return a mirror with
     * <pre>{@code
     * EntityEquipment equipment = entity.getEquipment();
     * if (equipment instanceof PlayerInventory) {
     *     equipment.getItemInOffHand(); // will return a mirror
     * } else {
     *     equipment.getItemInOffHand(); // will return a copy
     * }
     * }</pre>
     *
     * @return the currently held item
     */
    @NonNull
    ItemStack getItemInOffHand();

    /**
     * Sets the item the entity is holding in their off hand.
     *
     * @param item The item to put into the entities hand
     */
    void setItemInOffHand(@Nullable ItemStack item);

    /**
     * Sets the item the entity is holding in their off hand.
     *
     * @param item The item to put into the entities hand
     * @param silent whether or not the equip sound should be silenced
     */
    void setItemInOffHand(@Nullable ItemStack item, boolean silent);

    /**
     * Gets the item the entity is currently holding
     *
     * <p>
     * This returns a copy if this equipment instance is from a non-player,
     * or it's an empty stack (has AIR as its type).
     * For non-empty stacks from players, this returns a live mirror. You can check if this
     * will return a mirror with
     * <pre>{@code
     * EntityEquipment equipment = entity.getEquipment();
     * if (equipment instanceof PlayerInventory) {
     *     equipment.getItemInHand(); // will return a mirror
     * } else {
     *     equipment.getItemInHand(); // will return a copy
     * }
     * }</pre>
     *
     * @return the currently held item
     * @see #getItemInMainHand()
     * @see #getItemInOffHand()
     * @deprecated entities can duel wield now use the methods for the
     *      specific hand instead
     */
    @Deprecated
    @NonNull
    ItemStack getItemInHand();

    /**
     * Sets the item the entity is holding
     *
     * @param stack The item to put into the entities hand
     * @see #setItemInMainHand(ItemStack)
     * @see #setItemInOffHand(ItemStack)
     * @deprecated entities can duel wield now use the methods for the
     *      specific hand instead
     */
    @Deprecated
    void setItemInHand(@Nullable ItemStack stack);

    /**
     * Gets the helmet currently being worn by the entity
     *
     * <p>
     * This returns a copy if this equipment instance is from a non-player.
     * For stacks from players, this returns a live mirror (or null). You can check if this
     * will return a mirror with
     * <pre>{@code
     * EntityEquipment equipment = entity.getEquipment();
     * if (equipment instanceof PlayerInventory) {
     *     equipment.getHelmet(); // will return a mirror
     * } else {
     *     equipment.getHelmet(); // will return a copy
     * }
     * }</pre>
     *
     * @return The helmet being worn
     */
    @Nullable
    ItemStack getHelmet();

    /**
     * Sets the helmet worn by the entity
     *
     * @param helmet The helmet to put on the entity
     */
    void setHelmet(@Nullable ItemStack helmet);

    /**
     * Sets the helmet worn by the entity
     *
     * @param helmet The helmet to put on the entity
     * @param silent whether or not the equip sound should be silenced
     */
    void setHelmet(@Nullable ItemStack helmet, boolean silent);

    /**
     * Gets the chest plate currently being worn by the entity
     *
     * <p>
     * This returns a copy if this equipment instance is from a non-player.
     * For stacks from players, this returns a live mirror (or null). You can check if this
     * will return a mirror with
     * <pre>{@code
     * EntityEquipment equipment = entity.getEquipment();
     * if (equipment instanceof PlayerInventory) {
     *     equipment.getChestplate(); // will return a mirror
     * } else {
     *     equipment.getChestplate(); // will return a copy
     * }
     * }</pre>
     *
     * @return The chest plate being worn
     */
    @Nullable
    ItemStack getChestplate();

    /**
     * Sets the chest plate worn by the entity
     *
     * @param chestplate The chest plate to put on the entity
     */
    void setChestplate(@Nullable ItemStack chestplate);

    /**
     * Sets the chest plate worn by the entity
     *
     * @param chestplate The chest plate to put on the entity
     * @param silent whether or not the equip sound should be silenced
     */
    void setChestplate(@Nullable ItemStack chestplate, boolean silent);

    /**
     * Gets the leggings currently being worn by the entity
     *
     * <p>
     * This returns a copy if this equipment instance is from a non-player.
     * For stacks from players, this returns a live mirror (or null). You can check if this
     * will return a mirror with
     * <pre>{@code
     * EntityEquipment equipment = entity.getEquipment();
     * if (equipment instanceof PlayerInventory) {
     *     equipment.getLeggings(); // will return a mirror
     * } else {
     *     equipment.getLeggings(); // will return a copy
     * }
     * }</pre>
     *
     * @return The leggings being worn
     */
    @Nullable
    ItemStack getLeggings();

    /**
     * Sets the leggings worn by the entity
     *
     * @param leggings The leggings to put on the entity
     */
    void setLeggings(@Nullable ItemStack leggings);

    /**
     * Sets the leggings worn by the entity
     *
     * @param leggings The leggings to put on the entity
     * @param silent whether or not the equip sound should be silenced
     */
    void setLeggings(@Nullable ItemStack leggings, boolean silent);

    /**
     * Gets the boots currently being worn by the entity
     *
     * <p>
     * This returns a copy if this equipment instance is from a non-player.
     * For stacks from players, this returns a live mirror (or null). You can check if this
     * will return a mirror with
     * <pre>{@code
     * EntityEquipment equipment = entity.getEquipment();
     * if (equipment instanceof PlayerInventory) {
     *     equipment.getBoots(); // will return a mirror
     * } else {
     *     equipment.getBoots(); // will return a copy
     * }
     * }</pre>
     *
     * @return The boots being worn
     */
    @Nullable
    ItemStack getBoots();

    /**
     * Sets the boots worn by the entity
     *
     * @param boots The boots to put on the entity
     */
    void setBoots(@Nullable ItemStack boots);

    /**
     * Sets the boots worn by the entity
     *
     * @param boots The boots to put on the entity
     * @param silent whether or not the equip sound should be silenced
     */
    void setBoots(@Nullable ItemStack boots, boolean silent);

    /**
     * Gets all worn armor
     *
     * <p>
     * This returns a copy if this equipment instance is from a non-player,
     * or it's an empty stack (has AIR as its type).
     * For non-empty stacks from players, this returns a live mirror. You can check if this
     * will return a mirror with
     * <pre>{@code
     * EntityEquipment equipment = entity.getEquipment();
     * if (equipment instanceof PlayerInventory) {
     *     equipment.getArmorContents(); // will return an array of mirror
     * } else {
     *     equipment.getArmorContents(); // will return an array of copies
     * }
     * }</pre>
     *
     * @return The array of worn armor. Individual items may be null.
     */
    @Nullable ItemStack @NonNull [] getArmorContents();

    /**
     * Sets the entities armor to the provided array of ItemStacks
     *
     * @param items The items to set the armor as. Individual items may be null.
     */
    void setArmorContents(@NonNull ItemStack[] items);

    /**
     * Clears the entity of all armor and held items
     */
    void clear();

    /**
     * Gets the chance of the main hand item being dropped upon this creature's
     * death.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @return chance of the currently held item being dropped (1 for non-{@link Mob})
     */
    float getItemInMainHandDropChance();

    /**
     * Sets the chance of the item this creature is currently holding in their
     * main hand being dropped upon this creature's death.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @param chance the chance of the main hand item being dropped
     * @throws UnsupportedOperationException when called on non-{@link Mob}
     */
    void setItemInMainHandDropChance(float chance);

    /**
     * Gets the chance of the off hand item being dropped upon this creature's
     * death.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @return chance of the off hand item being dropped (1 for non-{@link Mob})
     */
    float getItemInOffHandDropChance();

    /**
     * Sets the chance of the off hand item being dropped upon this creature's
     * death.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @param chance the chance of off hand item being dropped
     * @throws UnsupportedOperationException when called on non-{@link Mob}
     */
    void setItemInOffHandDropChance(float chance);

    /**
     * Gets the chance of the helmet being dropped upon this creature's death.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @return the chance of the helmet being dropped (1 for non-{@link Mob})
     */
    float getHelmetDropChance();

    /**
     * Sets the chance of the helmet being dropped upon this creature's death.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @param chance of the helmet being dropped
     * @throws UnsupportedOperationException when called on non-{@link Mob}
     */
    void setHelmetDropChance(float chance);

    /**
     * Gets the chance of the chest plate being dropped upon this creature's
     * death.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @return the chance of the chest plate being dropped (1 for non-{@link Mob})
     */
    float getChestplateDropChance();

    /**
     * Sets the chance of the chest plate being dropped upon this creature's
     * death.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @param chance of the chest plate being dropped
     * @throws UnsupportedOperationException when called on non-{@link Mob}
     */
    void setChestplateDropChance(float chance);

    /**
     * Gets the chance of the leggings being dropped upon this creature's
     * death.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @return the chance of the leggings being dropped (1 for non-{@link Mob})
     */
    float getLeggingsDropChance();

    /**
     * Sets the chance of the leggings being dropped upon this creature's
     * death.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @param chance chance of the leggings being dropped
     * @throws UnsupportedOperationException when called on non-{@link Mob}
     */
    void setLeggingsDropChance(float chance);

    /**
     * Gets the chance of the boots being dropped upon this creature's death.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @return the chance of the boots being dropped (1 for non-{@link Mob})
     */
    float getBootsDropChance();

    /**
     * Sets the chance of the boots being dropped upon this creature's death.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @param chance of the boots being dropped
     * @throws UnsupportedOperationException when called on non-{@link Mob}
     */
    void setBootsDropChance(float chance);

    /**
     * Get the entity this EntityEquipment belongs to
     *
     * @return the entity this EntityEquipment belongs to
     */
    @NonNull
    Entity getHolder();

    /**
     * Gets the drop chance of specified slot.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @param slot the slot to get the drop chance of
     * @return the drop chance for the slot
     */
    float getDropChance(@NonNull EquipmentSlot slot);

    /**
     * Sets the drop chance of the specified slot.
     *
     * <ul>
     * <li>A drop chance of 0.0F will never drop
     * <li>A drop chance of 1.0F will always drop
     * </ul>
     *
     * @param slot the slot to set the drop chance of
     * @param chance the drop chance for the slot
     * @throws UnsupportedOperationException when called on non-{@link Mob} entities
     */
    void setDropChance(@NonNull EquipmentSlot slot, float chance);
}

