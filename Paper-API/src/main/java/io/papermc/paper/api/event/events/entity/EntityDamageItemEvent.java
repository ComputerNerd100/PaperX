package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when an item on or used by an entity takes durability damage as a result of being hit/used.
 * <p>
 * NOTE: default vanilla behaviour dictates that armor/tools picked up by
 * mobs do not take damage (except via Thorns).
 */
public interface EntityDamageItemEvent extends CancellableEntityEvent {

    /**
     * Gets the item being damaged.
     *
     * @return the item
     */
    @Param(1)
    ItemStack item();

    /**
     * Gets the amount of durability damage this item will be taking.
     *
     * @return durability change
     */
    @Param(2)
    int damage();
}
