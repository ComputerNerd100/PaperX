package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.tilestate.Lectern;
import io.papermc.paper.api.event.util.Param;

/**
 * This event is called when a player clicks the button to take a book of a
 * Lectern. If this event is cancelled the book remains on the lectern.
 */
public interface PlayerTakeLecternBookEvent extends CancellablePlayerEvent {

    /**
     * Gets the lectern involved.
     *
     * @return the Lectern
     */
    @Param(1)
    Lectern lectern();

}
