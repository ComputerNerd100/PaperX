package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a player interacts with an armor stand and will either swap, retrieve or
 * place an item.
 */
public interface PlayerArmorStandManipulateEvent extends PlayerInteractEntityEvent {

    /**
     * Returns the item held by the player.
     * <p>
     * If this item is empty and the armor stand item is also empty, there will be no
     * transaction between the player and the armor stand. If the player's item is empty
     * but the armor stand item is not, the player's item will be placed on the armor
     * stand. If both items are not empty, the items will be swapped.
     * <p>
     * In the case that this event is cancelled, the original items will remain the same.
     * @return the item held by the player.
     */
    @Param(3)
    ItemStack playerItem();

    /**
     * Returns the item held by the armor stand.
     * <p>
     * If this item is empty and the player's item is also empty, there will be no
     * transaction between the player and the armor stand. If the player's item is empty
     * but the armor stand item is not, then the player will obtain the armor stand item.
     * In the case that the player's item is not empty but the armor stand item is empty,
     * the player's item will be placed on the armor stand. If both items are not empty,
     * the items will be swapped.
     * <p>
     * In the case that the event is cancelled the original items will remain the same.
     * @return the item held by the armor stand.
     */
    @Param(4)
    ItemStack armorStandItem();

    /**
     * Returns the raw item slot of the armor stand in this event.
     *
     * @return the index of the item obtained or placed of the armor stand.
     */
    @Param(5)
    EquipmentSlot slot();
}
