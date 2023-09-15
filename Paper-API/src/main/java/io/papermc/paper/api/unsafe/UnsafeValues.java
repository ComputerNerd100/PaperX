package io.papermc.paper.api.unsafe;

import com.google.common.collect.Multimap;
import io.papermc.paper.api.Paper;
import io.papermc.paper.api.Server;
import io.papermc.paper.api.advancement.Advancement;
import io.papermc.paper.api.attribute.Attributable;
import io.papermc.paper.api.attribute.Attribute;
import io.papermc.paper.api.attribute.AttributeModifier;
import io.papermc.paper.api.block.data.BlockData;
import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.EntityType;
import io.papermc.paper.api.inventory.CreativeCategory;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemRarity;
import io.papermc.paper.api.inventory.ItemStack;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.namespace.NamespacedKey;
import io.papermc.paper.api.util.FeatureFlag;
import io.papermc.paper.api.util.Statistic;
import io.papermc.paper.api.util.VersionFetcher;
import io.papermc.paper.api.world.RegionAccessor;
import io.papermc.paper.api.world.World;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.flattener.ComponentFlattener;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * This interface provides value conversions that may be specific to a
 * runtime, or have arbitrary meaning (read: magic values).
 * <p>
 * Their existence and behavior is not guaranteed across future versions. They
 * may be poorly named, throw exceptions, have misleading parameters, or any
 * other bad programming practice.
 */
@Deprecated
public interface UnsafeValues {

    ComponentFlattener componentFlattener();
    Component resolveWithContext(net.kyori.adventure.text.Component component, CommandSender context, Entity scoreboardSubject, boolean bypassPermissions) throws java.io.IOException;
    void reportTimings();
    Material toLegacy(Material material);

    Material fromLegacy(Material material);

    Material fromLegacy(MaterialData material);

    Material fromLegacy(MaterialData material, boolean itemPriority);

    BlockData fromLegacy(Material material, byte data);

    Material getMaterial(String material, int version);

    int getDataVersion();

    ItemStack modifyItemStack(ItemStack stack, String arguments);

    void checkSupported(PluginDescriptionFile pdf) throws InvalidPluginException;

    byte[] processClass(PluginDescriptionFile pdf, String path, byte[] clazz);

    /**
     * Load an advancement represented by the specified string into the server.
     * The advancement format is governed by Minecraft and has no specified
     * layout.
     * <br>
     * It is currently a JSON object, as described by the Minecraft Wiki:
     * http://minecraft.gamepedia.com/Advancements
     * <br>
     * Loaded advancements will be stored and persisted across server restarts
     * and reloads.
     * <br>
     * Callers should be prepared for {@link Exception} to be thrown.
     *
     * @param key the unique advancement key
     * @param advancement representation of the advancement
     * @return the loaded advancement or null if an error occurred
     */
    Advancement loadAdvancement(NamespacedKey key, String advancement);

    /**
     * Delete an advancement which was loaded and saved by
     * {@link #loadAdvancement(NamespacedKey, java.lang.String)}.
     * <br>
     * This method will only remove advancement from persistent storage. It
     * should be accompanied by a call to {@link Server#reloadData()} in order
     * to fully remove it from the running instance.
     *
     * @param key the unique advancement key
     * @return true if a file matching this key was found and deleted
     */
    boolean removeAdvancement(NamespacedKey key);

    Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(Material material, EquipmentSlot slot);

    CreativeCategory getCreativeCategory(Material material);

    String getBlockTranslationKey(Material material);

    String getItemTranslationKey(Material material);

    String getTranslationKey(EntityType entityType);

    String getTranslationKey(ItemStack itemStack);

    @Nullable
    FeatureFlag getFeatureFlag(@NonNull NamespacedKey key);
    /**
     * Server name to report to timings v2
     * @return name
     */
    String getTimingsServerName();

    /**
     * Called once by the version command on first use, then cached.
     */
    default VersionFetcher getVersionFetcher() {
        return new VersionFetcher.DummyVersionFetcher();
    }

    byte[] serializeItem(ItemStack item);

    ItemStack deserializeItem(byte[] data);

    byte[] serializeEntity(Entity entity);

    default Entity deserializeEntity(byte[] data, World world) {
        return deserializeEntity(data, world, false);
    }

    Entity deserializeEntity(byte[] data, World world, boolean preserveUUID);

    /**
     * Creates and returns the next EntityId available.
     * <p>
     * Use this when sending custom packets, so that there are no collisions on the client or server.
     */
    int nextEntityId();

    /**
     * Just don't use it.
     */
    @NonNull String getMainLevelName();

    /**
     * Gets the item rarity of a material. The material <b>MUST</b> be an item.
     * Use {@link Material#isItem()} before this.
     *
     * @param material the material to get the rarity of
     * @return the item rarity
     */
    ItemRarity getItemRarity(Material material);

    /**
     * Gets the item rarity of the itemstack. The rarity can change based on enchantements.
     *
     * @param itemStack the itemstack to get the rarity of
     * @return the itemstack rarity
     */
    ItemRarity getItemStackRarity(ItemStack itemStack);

    /**
     * Checks if an itemstack can be repaired with another itemstack.
     * Returns false if either argument's type is not an item ({@link Material#isItem()}).
     *
     * @param itemToBeRepaired the itemstack to be repaired
     * @param repairMaterial the repair material
     * @return true if valid repair, false if not
     */
    boolean isValidRepairItemStack(@NonNull ItemStack itemToBeRepaired, @NonNull ItemStack repairMaterial);

    /**
     * Returns an immutable multimap of attributes for the material and slot.
     * {@link Material#isItem()} must be true for this material.
     *
     * @param material the material
     * @param equipmentSlot the slot to get the attributes for
     * @throws IllegalArgumentException if {@link Material#isItem()} is false
     * @return an immutable multimap of attributes
     */
    @NonNull Multimap<Attribute, AttributeModifier> getItemAttributes(@NonNull Material material, @NonNull EquipmentSlot equipmentSlot);

    /**
     * Returns the server's protocol version.
     *
     * @return the server's protocol version
     */
    int getProtocolVersion();

    /**
     * Checks if the entity represented by the namespaced key has default attributes.
     *
     * @param entityKey the entity's key
     * @return true if it has default attributes
     */
    boolean hasDefaultEntityAttributes(@NonNull NamespacedKey entityKey);

    /**
     * Gets the default attributes for the entity represented by the namespaced key.
     *
     * @param entityKey the entity's key
     * @return an unmodifiable instance of Attributable for reading default attributes.
     * @throws IllegalArgumentException if the entity does not exist of have default attributes (use {@link #hasDefaultEntityAttributes(NamespacedKey)} first)
     */
    @NonNull Attributable getDefaultEntityAttributes(@NonNull NamespacedKey entityKey);

    /**
     * Checks if this material is collidable.
     *
     * @param material the material to check
     * @return true if collidable
     * @throws IllegalArgumentException if {@link Material#isBlock()} is false
     */
    boolean isCollidable(@NonNull Material material);

    /**
     * Gets the {@link NamespacedKey} for the biome at the given location.
     *
     * @param accessor The {@link RegionAccessor} of the provided coordinates
     * @param x X-coordinate of the block
     * @param y Y-coordinate of the block
     * @param z Z-coordinate of the block
     * @return the biome's {@link NamespacedKey}
     */
    @NonNull
    NamespacedKey getBiomeKey(RegionAccessor accessor, int x, int y, int z);

    /**
     * Sets the biome at the given location to a biome registered
     * to the given {@link NamespacedKey}. If no biome by the given
     * {@link NamespacedKey} exists, an {@link IllegalStateException}
     * will be thrown.
     *
     * @param accessor The {@link RegionAccessor} of the provided coordinates
     * @param x X-coordinate of the block
     * @param y Y-coordinate of the block
     * @param z Z-coordinate of the block
     * @param biomeKey Biome key
     * @throws IllegalStateException if no biome by the given key is registered.
     */
    void setBiomeKey(RegionAccessor accessor, int x, int y, int z, NamespacedKey biomeKey);

    String getStatisticCriteriaKey(@NonNull Statistic statistic);
}

