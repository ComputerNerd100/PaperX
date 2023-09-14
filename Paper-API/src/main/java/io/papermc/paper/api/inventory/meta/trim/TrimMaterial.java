package io.papermc.paper.api.inventory.meta.trim;

import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import io.papermc.paper.api.registry.Registry;

/**
 * Represents a material that may be used in an {@link ArmorTrim}.
 */
public interface TrimMaterial extends Keyed {

    /**
     * {@link Material#QUARTZ}.
     */
    TrimMaterial QUARTZ = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("quartz"));
    /**
     * {@link Material#IRON_INGOT}.
     */
    TrimMaterial IRON = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("iron"));
    /**
     * {@link Material#NETHERITE_INGOT}.
     */
    TrimMaterial NETHERITE = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("netherite"));
    /**
     * {@link Material#REDSTONE}.
     */
    TrimMaterial REDSTONE = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("redstone"));
    /**
     * {@link Material#COPPER_INGOT}.
     */
    TrimMaterial COPPER = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("copper"));
    /**
     * {@link Material#GOLD_INGOT}.
     */
    TrimMaterial GOLD = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("gold"));
    /**
     * {@link Material#EMERALD}.
     */
    TrimMaterial EMERALD = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("emerald"));
    /**
     * {@link Material#DIAMOND}.
     */
    TrimMaterial DIAMOND = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("diamond"));
    /**
     * {@link Material#LAPIS_LAZULI}.
     */
    TrimMaterial LAPIS = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("lapis"));
    /**
     * {@link Material#AMETHYST_SHARD}.
     */
    TrimMaterial AMETHYST = Registry.TRIM_MATERIAL.get(NamespacedKey.minecraft("amethyst"));
}
