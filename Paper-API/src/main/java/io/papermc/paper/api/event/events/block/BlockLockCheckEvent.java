package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.tilestate.LockableTileState;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;

/**
 * Called when the server tries to check the lock on a lockable tile entity.
 */
public interface BlockLockCheckEvent extends BlockResultEvent {

    /**
     * Gets the snapshot {@link LockableTileState} of the tile entity
     * whose lock is being checked.
     *
     * @return the snapshot block state.
     */
    @Param(0)
    LockableTileState state();

    /**
     * Get the player involved this lock check.
     *
     * @return the player
     */
    @Param(1)
    Player player();

    /**
     * Gets the itemstack that will be used as the key itemstack. Initially
     * this will be the item in the player's main hand but an override can be set.
     *
     * @return the item being used as the key item
     */
    @Param(2)
    ItemStack customKey();

    /**
    * Gets the result of this event.
    *
    * @return the result
    */
    @Param(3)
    Result eventResult();

    /**
     * Gets the locked message that will be sent if the
     * player cannot open the block.
     *
     * @return the locked message (or null if none)
     */
    @Param(4)
    Component lockedMessage();

    /**
     * Gets the locked sound that will play if the
     * player cannot open the block.
     *
     * @return the locked sound (or null if none)
     */
    @Param(5)
    Sound lockedSound();
}
