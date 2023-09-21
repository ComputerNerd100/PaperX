package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.ItemFrame;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when an {@link ItemFrame} is having an item rotated, added, or removed from it.
 */
public interface PlayerItemFrameChangeEvent extends CancellablePlayerEvent {

    /**
     * Gets the {@link ItemFrame} involved in this event.
     * @return the {@link ItemFrame}
     */
    @Param(1)
    ItemFrame itemFrame();

    /**
     * Gets the {@link ItemStack} involved in this event.
     * This is the item being added, rotated, or removed from the {@link ItemFrame}.
     * <p>If this method returns air, then the resulting item in the ItemFrame will be empty.</p>
     * @return the {@link ItemStack} being added, rotated, or removed
     */
    @Param(2)
    ItemStack itemStack();

    /**
     * Gets the action that was performed on this {@link ItemFrame}.
     * @see ItemFrameChangeAction
     * @return action performed on the item frame in this event
     */
    @Param(3)
    ItemFrameChangeAction action();

    enum ItemFrameChangeAction {
        PLACE,
        REMOVE,
        ROTATE
    }
}
