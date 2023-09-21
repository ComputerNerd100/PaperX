package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a block is broken by a player.
 * <p>
 * If you wish to have the block drop experience, you must set the experience
 * value above 0. By default, experience will be set in the event if:
 * <ol>
 * <li>The player is not in creative or adventure mode
 * <li>The player can loot the block (ie: does not destroy it completely, by
 *     using the correct tool)
 * <li>The player does not have silk touch
 * <li>The block drops experience in vanilla Minecraft
 * </ol>
 * <p>
 * Note:
 * Plugins wanting to simulate a traditional block drop should set the block
 * to air and utilize their own methods for determining what the default drop
 * for the block being broken is and what to do about it, if anything.
 * <p>
 * If a Block Break event is cancelled, the block will not break and
 * experience will not drop.
 */
public interface BlockBreakEvent extends BlockExpEvent, Cancellable {

    /**
     * Gets the Player that is breaking the block involved in this event.
     *
     * @return The Player that is breaking the block involved in this event
     */
    @Param(2)
    Player player();

    /**
     * Gets whether or not the block will attempt to drop items.
     *
     * If and only if this is false then {@link BlockDropItemEvent} will not be
     * called after this event.
     *
     * @return Whether or not the block will attempt to drop items
     */
    @Param(3)
    boolean dropItems();

}
