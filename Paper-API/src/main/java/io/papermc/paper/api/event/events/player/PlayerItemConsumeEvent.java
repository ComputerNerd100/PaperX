package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * This event will fire when a player is finishing consuming an item (food,
 * potion, milk bucket).
 * <br>
 * If the ItemStack is modified the server will use the effects of the new
 * item and not remove the original one from the player's inventory.
 * <br>
 * If the event is cancelled the effect will not be applied and the item will
 * not be removed from the player's inventory.
 */
public interface PlayerItemConsumeEvent extends CancellablePlayerEvent {

    /**
     * Gets the item that is being consumed. Modifying the returned item will
     * have no effect.
     *
     * @return an ItemStack for the item being consumed
     */
    @Param(1)
    ItemStack item();

    /**
     * Gets the hand used to consume the item.
     *
     * @return the hand used to consume the item
     */
    @Param(2)
    EquipmentSlot hand();

    /**
     * Return the custom item stack that will replace the consumed item, or null if no
     * custom replacement has been set (which means the default replacement will be used).
     *
     * @return The custom item stack that will replace the consumed item or null
     */
    @Param(3)
    ItemStack replacement();
}
