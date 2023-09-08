package io.papermc.paper.api.inventory;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a category in the creative inventory.
 */
public enum CreativeCategory implements net.kyori.adventure.translation.Translatable {

    /**
     * An assortment of building blocks including dirt, bricks, planks, ores
     * slabs, etc.
     */
    BUILDING_BLOCKS("buildingBlocks"),
    /**
     * Blocks and items typically used for decorative purposes including
     * candles, saplings, flora, fauna, fences, walls, carpets, etc.
     */
    DECORATIONS("decorations"),
    /**
     * Blocks used and associated with redstone contraptions including buttons,
     * levers, pressure plates, redstone components, pistons, etc.
     */
    REDSTONE("redstone"),
    /**
     * Items pertaining to transportation including minecarts, rails, boats,
     * elytra, etc.
     */
    TRANSPORTATION("transportation"),
    /**
     * Miscellaneous items and blocks that do not fit into other categories
     * including gems, dyes, spawn eggs, discs, banner patterns, etc.
     */
    MISC("misc"),
    /**
     * Food items consumable by the player including meats, berries, edible
     * drops from creatures, etc.
     */
    FOOD("food"),
    /**
     * Equipment items meant for general utility including pickaxes, axes, hoes,
     * flint and steel, and useful enchantment books for said tools.
     */
    TOOLS("tools"),
    /**
     * Equipment items meant for combat including armor, swords, bows, tipped
     * arrows, and useful enchantment books for said equipment.
     */
    COMBAT("combat"),
    /**
     * All items related to brewing and potions including all types of potions,
     * their variants, and ingredients to brew them.
     */
    BREWING("brewing");

    private final String translationKey;

    CreativeCategory(String translationKey) {
        this.translationKey = "itemGroup." + translationKey;
    }

    @Override
    public @NonNull String translationKey() {
        return this.translationKey;
    }
}