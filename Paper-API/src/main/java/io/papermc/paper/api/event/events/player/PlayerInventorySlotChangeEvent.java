package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.Inventory;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a slot contents change in a player's inventory.
 */
public interface PlayerInventorySlotChangeEvent extends PlayerResultEvent {

    /**
     * The raw slot number that was changed.
     *
     * @return The raw slot number.
     */
    @Param(0)
    int rawSlot();

    /**
     * The slot number that was changed, ready for passing to
     * {@link Inventory#getItem(int)}. Note that there may be two slots with
     * the same slot number, since a view links two different inventories.
     * <p>
     * If no inventory is opened, internal crafting view is used for conversion.
     *
     * @return The slot number.
     */
    @Param(1)
    int slot();

    /**
     * Clone of ItemStack that was in the slot before the change.
     *
     * @return The old ItemStack in the slot.
     */
    @Param(2)
    ItemStack oldItemStack();

    /**
     * Clone of ItemStack that is in the slot after the change.
     *
     * @return The new ItemStack in the slot.
     */
    @Param(3)
    ItemStack newItemStack();

    /**
     * Gets whether the slot change advancements will be triggered.
     *
     * @return Whether the slot change advancements will be triggered.
     */
    @Param(4)
    boolean triggerAdvancements();
}
