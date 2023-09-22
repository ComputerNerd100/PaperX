package io.papermc.paper.api.block.container;

import io.papermc.paper.api.block.tilestate.Lidded;
import io.papermc.paper.api.block.color.DyeColor;
import io.papermc.paper.api.inventory.LootableBlockInventory;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a captured state of a ShulkerBox.
 */
public interface ShulkerBox extends Container, LootableBlockInventory, Lidded { // Paper

    /**
     * Get the {@link DyeColor} corresponding to this ShulkerBox
     *
     * @return the {@link DyeColor} of this ShulkerBox, or null if default
     */
    @Nullable DyeColor getColor();
}
