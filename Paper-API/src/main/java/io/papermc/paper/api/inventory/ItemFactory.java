package io.papermc.paper.api.inventory;

import io.papermc.paper.api.Server;
import io.papermc.paper.api.block.color.Color;
import io.papermc.paper.api.entity.EntityType;
import io.papermc.paper.api.inventory.meta.BookMeta;
import io.papermc.paper.api.inventory.meta.ItemMeta;
import io.papermc.paper.api.inventory.meta.SkullMeta;
import io.papermc.paper.api.material.Material;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.ApiStatus;

import java.util.Random;
import java.util.function.UnaryOperator;

/**
 * An instance of the ItemFactory can be obtained with {@link
 * Server#getItemFactory()}.
 * <p>
 * The ItemFactory is solely responsible for creating item meta containers to
 * apply on item stacks.
 */
public interface ItemFactory {

    /**
     * This creates a new item meta for the material.
     *
     * @param material The material to consider as base for the meta
     * @return a new ItemMeta that could be applied to an item stack of the
     *     specified material
     */
    @Nullable
    ItemMeta getItemMeta(@NonNull final Material material);

    /**
     * This method checks the item meta to confirm that it is applicable (no
     * data lost if applied) to the specified ItemStack.
     * <p>
     * A {@link SkullMeta} would not be valid for a sword, but a normal {@link
     * ItemMeta} from an enchanted dirt block would.
     *
     * @param meta Meta to check
     * @param stack Item that meta will be applied to
     * @return true if the meta can be applied without losing data, false
     *     otherwise
     * @throws IllegalArgumentException if the meta was not created by this
     *     factory
     */
    boolean isApplicable(@Nullable final ItemMeta meta, @Nullable final ItemStack stack) throws IllegalArgumentException;

    /**
     * This method checks the item meta to confirm that it is applicable (no
     * data lost if applied) to the specified Material.
     * <p>
     * A {@link SkullMeta} would not be valid for a sword, but a normal {@link
     * ItemMeta} from an enchanted dirt block would.
     *
     * @param meta Meta to check
     * @param material Material that meta will be applied to
     * @return true if the meta can be applied without losing data, false
     *     otherwise
     * @throws IllegalArgumentException if the meta was not created by this
     *     factory
     */
    boolean isApplicable(@Nullable final ItemMeta meta, @Nullable final Material material) throws IllegalArgumentException;

    /**
     * This method is used to compare two item meta data objects.
     *
     * @param meta1 First meta to compare, and may be null to indicate no data
     * @param meta2 Second meta to compare, and may be null to indicate no
     *     data
     * @return false if one of the meta has data the other does not, otherwise
     *     true
     * @throws IllegalArgumentException if either meta was not created by this
     *     factory
     */
    boolean equals(@Nullable final ItemMeta meta1, @Nullable final ItemMeta meta2) throws IllegalArgumentException;

    /**
     * Returns an appropriate item meta for the specified stack.
     * <p>
     * The item meta returned will always be a valid meta for a given
     * ItemStack of the specified material. It may be a more or less specific
     * meta, and could also be the same meta or meta type as the parameter.
     * The item meta returned will also always be the most appropriate meta.
     * <p>
     * Example, if a {@link SkullMeta} is being applied to a book, this method
     * would return a {@link BookMeta} containing all information in the
     * specified meta that is applicable to an {@link ItemMeta}, the highest
     * common interface.
     *
     * @param meta the meta to convert
     * @param stack the stack to convert the meta for
     * @return An appropriate item meta for the specified item stack. No
     *     guarantees are made as to if a copy is returned. This will be null
     *     for a stack of air.
     * @throws IllegalArgumentException if the specified meta was not created
     *     by this factory
     */
    @Nullable
    ItemMeta asMetaFor(@NonNull final ItemMeta meta, @NonNull final ItemStack stack) throws IllegalArgumentException;

    /**
     * Returns an appropriate item meta for the specified material.
     * <p>
     * The item meta returned will always be a valid meta for a given
     * ItemStack of the specified material. It may be a more or less specific
     * meta, and could also be the same meta or meta type as the parameter.
     * The item meta returned will also always be the most appropriate meta.
     * <p>
     * Example, if a {@link SkullMeta} is being applied to a book, this method
     * would return a {@link BookMeta} containing all information in the
     * specified meta that is applicable to an {@link ItemMeta}, the highest
     * common interface.
     *
     * @param meta the meta to convert
     * @param material the material to convert the meta for
     * @return An appropriate item meta for the specified item material. No
     *     guarantees are made as to if a copy is returned. This will be null for air.
     * @throws IllegalArgumentException if the specified meta was not created
     *     by this factory
     */
    @Nullable
    ItemMeta asMetaFor(@NonNull final ItemMeta meta, @NonNull final Material material) throws IllegalArgumentException;

    /**
     * Returns the default color for all leather armor.
     *
     * @return the default color for leather armor
     */
    @NonNull
    Color getDefaultLeatherColor();

    /**
     * Create a new {@link ItemStack} given the supplied input.
     * <p>
     * The input should match the same input as expected by Minecraft's {@code /give}
     * command. For example, "minecraft:diamond_sword{Enchantments:[{id:"minecraft:sharpness", lvl:3}]}"
     * would yield an ItemStack of {@link Material#DIAMOND_SWORD} with an {@link ItemMeta}
     * containing a level 3 {@link Enchantment#DAMAGE_ALL}
     * enchantment.
     *
     * @param input the item input string
     * @return the created ItemStack
     * @throws IllegalArgumentException if the input string was provided in an
     * invalid or unsupported format
     */
    @NonNull
    ItemStack createItemStack(@NonNull String input) throws IllegalArgumentException;

    /**
     * Apply a material change for an item meta. Do not use under any
     * circumstances.
     *
     * @param meta meta
     * @param material material
     * @return updated material
     * @throws IllegalArgumentException if bad material or data
     * @deprecated for internal use only
     */
    @Deprecated
    @ApiStatus.Internal
    @NonNull
    Material updateMaterial(@NonNull final ItemMeta meta, @NonNull final Material material) throws IllegalArgumentException;

    /**
     * Gets a {@link Material} representing the spawn egg for the provided
     * {@link EntityType}. <br>
     * Will return null for EntityTypes that do not have a corresponding spawn egg.
     *
     * @param type the entity type
     * @return the Material of this EntityTypes spawn egg or null
     */
    @Nullable
    Material getSpawnEgg(@NonNull EntityType type);

    /**
     * Randomly enchants a copy of the provided {@link ItemStack} using the given experience levels.
     *
     * <p>If the provided ItemStack is already enchanted, the existing enchants will be removed before enchanting.</p>
     *
     * <p>Levels must be in range {@code [1, 30]}.</p>
     *
     * @param itemStack ItemStack to enchant
     * @param levels levels to use for enchanting
     * @param allowTreasure whether to allow enchantments where {@link org.bukkit.enchantments.Enchantment#isTreasure()} returns true
     * @param random {@link java.util.Random} instance to use for enchanting
     * @return enchanted copy of the provided ItemStack
     * @throws IllegalArgumentException on bad arguments
     */
    @NonNull ItemStack enchantWithLevels(@NonNull ItemStack itemStack, @org.jetbrains.annotations.Range(from = 1, to = 30) int levels, boolean allowTreasure, @NonNull Random random);

    /**
     * Creates a hover event for the given item.
     *
     * @param item The item
     * @return A hover event
     */
    @NonNull
    HoverEvent<HoverEvent.ShowItem> asHoverEvent(final @NonNull ItemStack item, final @NonNull UnaryOperator<HoverEvent.ShowItem> op);

    /**
     * Get the formatted display name of the {@link ItemStack}.
     *
     * @param itemStack the {@link ItemStack}
     * @return display name of the {@link ItemStack}
     */
    @NonNull
    Component displayName(@NonNull ItemStack itemStack);

    /**
     * Minecraft's updates are converting simple item stacks into more complex NBT oriented Item Stacks.
     *
     * Use this method to ensure any desired data conversions are processed.
     * The input itemstack will not be the same as the returned itemstack.
     *
     * @param item The item to process conversions on
     * @return A potentially Data-Converted-ItemStack
     */
    @NonNull
    ItemStack ensureServerConversions(@NonNull ItemStack item);
}

