package io.papermc.paper.api.inventory;

import io.papermc.paper.api.annotation.Utility;
import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.inventory.meta.ItemMeta;
import io.papermc.paper.api.material.Material;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEventSource;
import net.kyori.adventure.translation.Translatable;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public interface  ItemStack extends Cloneable, ConfigurationSerializable, Translatable, HoverEventSource<HoverEvent.ShowItem> {

    /**
     * Gets the type of this item
     *
     * @return Type of the items in this stack
     */
    @Utility
    @NonNull
    Material getType();

    /**
     * Sets the type of this item
     * <p>
     * Note that in doing so you will reset the MaterialData for this stack.
     * <p>
     * <b>IMPORTANT: An <i>Item</i>Stack is only designed to contain
     * <i>items</i>. Do not use this class to encapsulate Materials for which
     * {@link Material#isItem()} returns false.</b>
     *
     * @param type New type to set the items in this stack to
     */
    @Utility
    void setType(@NonNull Material type);

    /**
     * Gets the amount of items in this stack
     *
     * @return Amount of items in this stack
     */
    int getAmount();

    /**
     * Sets the amount of items in this stack
     *
     * @param amount New amount of items in this stack
     */
    void setAmount(int amount);

    /**
     * Get the maximum stacksize for the material hold in this ItemStack.
     * (Returns -1 if it has no idea)
     *
     * @return The maximum you can stack this material to.
     */
    @Utility
    int getMaxStackSize();
    void createData(final byte data);

    /**
     * This method is the same as equals, but does not consider stack size
     * (amount).
     *
     * @param stack the item stack to compare to
     * @return true if the two stacks are equal, ignoring the amount
     */
    @Utility
    boolean isSimilar(@NonNull ItemStack stack);
    @NonNull ItemStack clone();

    /**
     * Checks if this ItemStack contains the given {@link Enchantment}
     *
     * @param enchantment Enchantment to test
     * @return True if this has the given enchantment
     */
    boolean containsEnchantment(@NonNull Enchantment enchantment);

    /**
     * Gets the level of the specified enchantment on this item stack
     *
     * @param enchantment Enchantment to check
     * @return Level of the enchantment, or 0
     */
    int getEnchantmentLevel(@NonNull Enchantment enchantment);

    /**
     * Gets a map containing all enchantments and their levels on this item.
     *
     * @return Map of enchantments.
     */
    Map<Enchantment, Integer> getEnchantments();

    /**
     * Adds the specified {@link Enchantment} to this item stack.
     * <p>
     * If this item stack already contained the given enchantment (at any
     * level), it will be replaced.
     *
     * @param enchantment Enchantment to add
     * @param level Level of the enchantment
     * @throws IllegalArgumentException if enchantment null, or enchantment is
     *     not applicable
     */
    @Utility
    void addEnchantment(@NonNull Enchantment enchantment, int level);

    /**
     * Adds the specified enchantments to this item stack.
     * <p>
     * This method is the same as calling {@link
     * #addEnchantment(Enchantment, int)} for each
     * element of the map.
     *
     * @param enchantments Enchantments to add
     * @throws IllegalArgumentException if the specified enchantments is null
     * @throws IllegalArgumentException if any specific enchantment or level
     *     is null. <b>Warning</b>: Some enchantments may be added before this
     *     exception is thrown.
     */
    @Utility
    void addEnchantments(@NonNull Map<Enchantment, Integer> enchantments);

    /**
     * Adds the specified {@link Enchantment} to this item stack.
     * <p>
     * If this item stack already contained the given enchantment (at any
     * level), it will be replaced.
     * <p>
     * This method is unsafe and will ignore level restrictions or item type.
     * Use at your own discretion.
     *
     * @param enchantment Enchantment to add
     * @param level Level of the enchantment
     */
    void addUnsafeEnchantment(@NonNull Enchantment enchantment, int level);

    /**
     * Adds the specified enchantments to this item stack in an unsafe manner.
     * <p>
     * This method is the same as calling {@link
     * #addUnsafeEnchantment(Enchantment, int)} for
     * each element of the map.
     *
     * @param enchantments Enchantments to add
     */
    void addUnsafeEnchantments(@NonNull Map<Enchantment, Integer> enchantments);

    /**
     * Removes the specified {@link Enchantment} if it exists on this
     * ItemStack
     *
     * @param enchantment Enchantment to remove
     * @return Previous level, or 0
     */
    int removeEnchantment(@NonNull Enchantment enchantment);

    /**
     * Edits the {@link ItemMeta} of this stack.
     * <p>
     * The {@link java.util.function.Consumer} must only interact
     * with this stack's {@link ItemMeta} through the provided {@link ItemMeta} instance.
     * Calling this method or any other meta-related method of the {@link ItemStack} class
     * (such as {@link #getItemMeta()}, {@link #addItemFlags(ItemFlag...)}, {@link #lore()}, etc.)
     * from inside the consumer is disallowed and will produce undefined results or exceptions.
     * </p>
     *
     * @param metaConsumer the meta consumer
     * @return {@code true} if the edit was successful, {@code false} otherwise
     */
    boolean editMeta(final @NonNull Consumer<? super ItemMeta> metaConsumer);

    /**
     * Edits the {@link ItemMeta} of this stack if the meta is of the specified type.
     * <p>
     * The {@link java.util.function.Consumer} must only interact
     * with this stack's {@link ItemMeta} through the provided {@link ItemMeta} instance.
     * Calling this method or any other meta-related method of the {@link ItemStack} class
     * (such as {@link #getItemMeta()}, {@link #addItemFlags(ItemFlag...)}, {@link #lore()}, etc.)
     * from inside the consumer is disallowed and will produce undefined results or exceptions.
     * </p>
     *
     * @param metaClass the type of meta to edit
     * @param metaConsumer the meta consumer
     * @param <M> the meta type
     * @return {@code true} if the edit was successful, {@code false} otherwise
     */
    <M extends ItemMeta> boolean editMeta(final @NonNull Class<M> metaClass, final @NonNull Consumer<@NonNull ? super M> metaConsumer);

    /**
     * Get a copy of this ItemStack's {@link ItemMeta}.
     *
     * @return a copy of the current ItemStack's ItemData
     */
    @Nullable ItemMeta getItemMeta();

    /**
     * Checks to see if any meta data has been defined.
     *
     * @return Returns true if some meta data has been set for this item
     */
    boolean hasItemMeta();

    /**
     * Set the ItemMeta of this ItemStack.
     *
     * @param itemMeta new ItemMeta, or null to indicate meta data be cleared.
     * @return True if successfully applied ItemMeta, see {@link
     *     ItemFactory#isApplicable(ItemMeta, ItemStack)}
     * @throws IllegalArgumentException if the item meta was not created by
     *     the {@link ItemFactory}
     */
    void setItemMeta(@Nullable ItemMeta itemMeta);


    boolean setItemMeta0(@Nullable ItemMeta itemMeta, @NonNull Material material);

    /**
     * Randomly enchants a copy of this {@link ItemStack} using the given experience levels.
     *
     * <p>If this ItemStack is already enchanted, the existing enchants will be removed before enchanting.</p>
     *
     * <p>Levels must be in range {@code [1, 30]}.</p>
     *
     * @param levels levels to use for enchanting
     * @param allowTreasure whether to allow enchantments where {@link org.bukkit.enchantments.Enchantment#isTreasure()} returns true
     * @param random {@link java.util.Random} instance to use for enchanting
     * @return enchanted copy of the provided ItemStack
     * @throws IllegalArgumentException on bad arguments
     */
    ItemStack enchantWithLevels(final @Range(from = 1, to = 30) int levels, final boolean allowTreasure, final @NonNull Random random);
    @Override
    @NotNull HoverEvent<HoverEvent.ShowItem> asHoverEvent(@NotNull UnaryOperator<HoverEvent.ShowItem> op);

    /**
     * Get the formatted display name of the {@link ItemStack}.
     *
     * @return display name of the {@link ItemStack}
     */
    @NonNull Component displayName();

    /**
     * Minecraft updates are converting simple item stacks into more complex NBT oriented Item Stacks.
     *
     * Use this method to ensure any desired data conversions are processed.
     * The input itemstack will not be the same as the returned itemstack.
     *
     * @return A potentially Data Converted ItemStack
     */
    ItemStack ensureServerConversions();

    /**
     * Deserializes this itemstack from raw NBT bytes. NBT is safer for data migrations as it will
     * use the built in data converter instead of bukkits dangerous serialization system.
     *
     * This expects that the DataVersion was stored on the root of the Compound, as saved from
     * the {@link #serializeAsBytes()} API returned.
     * @param bytes bytes representing an item in NBT
     * @return ItemStack migrated to this version of Minecraft if needed.
     */
    ItemStack deserializeBytes(@NonNull byte[] bytes);

    /**
     * Serializes this itemstack to raw bytes in NBT. NBT is safer for data migrations as it will
     * use the built in data converter instead of bukkits dangerous serialization system.
     * @return bytes representing this item in NBT.
     */
    byte[] serializeAsBytes();
    int getMaxItemUseDuration();

    /**
     * Clones the itemstack and returns it a single quantity.
     * @return The new itemstack with 1 quantity
     */
    @NonNull ItemStack asOne();

    /**
     * Clones the itemstack and returns it as the specified quantity
     * @param quantity The quantity of the cloned item
     * @return The new itemstack with specified quantity
     */
    @NonNull ItemStack asQuantity(int quantity);

    /**
     * Adds 1 to this itemstack. Will not go over the items max stack size.
     * @return The same item (not a clone)
     */
    @NonNull ItemStack add();

    /**
     * Adds quantity to this itemstack. Will not go over the items max stack size.
     *
     * @param amount The amount to add
     * @return The same item (not a clone)
     */
    @NonNull ItemStack add(int amount);

    /**
     * Subtracts 1 to this itemstack.  Going to 0 or less will invalidate the item.
     * @return The same item (not a clone)
     */
    @NonNull ItemStack subtract();

    /**
     * Subtracts quantity to this itemstack. Going to 0 or less will invalidate the item.
     *
     * @param amount The amount to add
     * @return The same item (not a clone)
     */
    @NonNull ItemStack subtract(int amount);

    /**
     * If the item has lore, returns it, else it will return null
     * @return The lore, or null
     */
    @Nullable List<Component> lore();

    /**
     * Sets the lore for this item.
     * Removes lore when given null.
     *
     * @param lore the lore that will be set
     */
    void lore(@Nullable List<Component> lore);

    /**
     * Set itemflags which should be ignored when rendering a ItemStack in the Client. This Method does silently ignore double set itemFlags.
     *
     * @param itemFlags The hideflags which shouldn't be rendered
     */
    void addItemFlags(@NonNull ItemFlag... itemFlags);

    /**
     * Remove specific set of itemFlags. This tells the Client it should render it again. This Method does silently ignore double removed itemFlags.
     *
     * @param itemFlags Hideflags which should be removed
     */
    void removeItemFlags(@NonNull ItemFlag... itemFlags);

    /**
     * Get current set itemFlags. The collection returned is unmodifiable.
     *
     * @return A set of all itemFlags set
     */
    Set<ItemFlag> getItemFlags();

    /**
     * Check if the specified flag is present on this item.
     *
     * @param flag the flag to check
     * @return if it is present
     */
    boolean hasItemFlag(@NonNull ItemFlag flag);

    /**
     * {@inheritDoc}
     * <p>
     * This is not the same as getting the translation key
     * for the material of this itemstack.
     */
    @Override
    @NotNull String translationKey();

    /**
     * Gets the item rarity of the itemstack. The rarity can change based on enchantements.
     *
     * @return the itemstack rarity
     */
    ItemRarity getRarity();

    /**
     * Checks if an itemstack can repair this itemstack.
     * Returns false if {@code this} or {@code repairMaterial}'s type is not an item ({@link Material#isItem()}).
     *
     * @param repairMaterial the repair material
     * @return true if it is repairable by, false if not
     */
    boolean isRepairableBy(@NonNull ItemStack repairMaterial);

    /**
     * Checks if this itemstack can repair another.
     * Returns false if {@code this} or {@code toBeRepaired}'s type is not an item ({@link Material#isItem()}).
     *
     * @param toBeRepaired the itemstack to be repaired
     * @return true if it can repair, false if not
     */
    boolean canRepair(@NonNull ItemStack toBeRepaired);

    /**
     * Damages this itemstack by the specified amount. This
     * runs all logic associated with damaging an itemstack like
     * events and stat changes.
     *
     * @param amount the amount of damage to do
     * @param livingEntity the entity related to the damage
     * @return the damaged itemstack or an empty one if it broke. May return the same instance of ItemStack
     * @see LivingEntity#damageItemStack(EquipmentSlot, int) to damage itemstacks in equipment slots
     */
    @NonNull ItemStack damage(int amount, @NonNull LivingEntity livingEntity);
}
