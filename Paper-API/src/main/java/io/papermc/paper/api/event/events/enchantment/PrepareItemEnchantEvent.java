package io.papermc.paper.api.event.events.enchantment;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.events.inventory.CancellableInventoryEvent;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when an ItemStack is inserted in an enchantment table - can be
 * called multiple times
 */
public interface PrepareItemEnchantEvent extends CancellableInventoryEvent {

    /**
     * Gets the block being used to enchant the item
     *
     * @return the block used for enchanting
     */
    @Param(1)
    Block table();

    /**
     * Gets the item to be enchanted.
     *
     * @return ItemStack of item
     */
    @Param(2)
    ItemStack item();

    /**
     * Gets the enchantment offers for the item.
     *
     * @return EnchantmentOffer array
     */
    @Param(3)
    EnchantmentOffer[] offers();

    /**
     * Get enchantment bonus in effect - corresponds to number of bookshelves
     *
     * @return enchantment bonus
     */
    @Param(4)
    int bonus();

    /**
     * Gets the player enchanting the item
     *
     * @return enchanting player
     */
    @Param(5)
    Player enchanter();
}
