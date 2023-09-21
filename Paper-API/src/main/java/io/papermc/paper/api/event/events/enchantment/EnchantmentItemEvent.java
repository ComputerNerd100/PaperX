package io.papermc.paper.api.event.events.enchantment;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.events.inventory.CancellableInventoryEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

import java.util.Map;

/**
 * Called when an ItemStack is successfully enchanted (currently at
 * enchantment table)
 */
public interface EnchantmentItemEvent extends CancellableInventoryEvent {

    /**
     * Gets the block being used to enchant the item
     *
     * @return the block used for enchanting
     */
    @Param(1)
    Block table();

    /**
     * Gets the item to be enchanted (can be modified)
     *
     * @return ItemStack of item
     */
    @Param(2)
    ItemStack item();

    /**
     * Gets the cost (minimum level) which is displayed as a number on the right
     * hand side of the enchantment offer.
     *
     * @return experience level cost
     */
    @Param(3)
    int level();

    /**
     * Get map of enchantment (levels, keyed by type) to be added to item
     * (modify map returned to change values). Note: Any enchantments not
     * allowed for the item will be ignored
     *
     * @return map of enchantment levels, keyed by enchantment
     */
    @Param(4)
    Map<Enchantment, Integer> enchants();

    /**
     * Get the {@link Enchantment} that was displayed as a hint to the player
     * on the selected enchantment offer.
     *
     * @return the hinted enchantment
     */
    @Param(5)
    Enchantment enchantmentHint();

    /**
     * Get the level of the enchantment that was displayed as a hint to the
     * player on the selected enchantment offer.
     *
     * @return the level of the hinted enchantment
     */
    @Param(6)
    int levelHint();

    /**
     * Gets the player enchanting the item
     *
     * @return enchanting player
     */
    @Param(7)
    Player enchanter();

    /**
     * Which button was pressed to initiate the enchanting.
     *
     * @return The button index (0, 1, or 2).
     */
    @Param(8)
    int button();
}
