package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when an item used by the player takes durability damage as a result of
 * being used.
 */
public interface PlayerItemDamageEvent extends CancellablePlayerEvent {

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

    /**
     * Gets the amount of durability damage this item would have taken before
     * the Unbreaking reduction. If the item has no Unbreaking level then
     * this value will be the same as the {@link #damage()} value.
     *
     * @return pre-reduction damage amount
     */
    @Param(3)
    int originalDamage();
}
