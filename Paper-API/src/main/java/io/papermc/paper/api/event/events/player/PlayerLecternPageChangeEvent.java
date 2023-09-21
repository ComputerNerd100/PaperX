package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.tilestate.Lectern;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.ItemStack;

/**
 * Called when a player changes the page of a lectern
 */
public interface PlayerLecternPageChangeEvent extends CancellablePlayerEvent {

    /**
     * Gets the lectern involved.
     *
     * @return the Lectern
     */
    @Param(1)
    Lectern lectern();

    /**
     * Gets the current ItemStack on the lectern.
     *
     * @return the ItemStack on the Lectern
     */
    @Param(2)
    ItemStack book();

    /**
     * Gets the page change direction. This is essentially returns which button the player clicked, left or right.
     *
     * @return the page change direction
     */
    @Param(3)
    PageChangeDirection pageChangeDirection();

    /**
     * Gets the page changed from. <i>Pages are 0-indexed.</i>
     *
     * @return the page changed from
     */
    @Param(4)
    int oldPage();

    /**
     * Gets the page changed to. <i>Pages are 0-indexed.</i>
     *
     * @return the page changed to
     */
    @Param(5)
    int newPage();

    enum PageChangeDirection {
        LEFT,
        RIGHT,
    }
}
