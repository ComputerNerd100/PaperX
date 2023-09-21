package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * This event is fired when the player activates the riptide enchantment, using
 * their trident to propel them through the air.
 * <br>
 * N.B. the riptide action is currently performed client side, so manipulating
 * the player in this event may have undesired effects.
 */
public interface PlayerRiptideEvent extends PlayerResultEvent {

    /**
     * Gets the item containing the used enchantment.
     *
     * @return held enchanted item
     */
    @Param(0)
    ItemStack item();
}
