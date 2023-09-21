package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.event.util.Param;

/**
 * Called when a block tries to dispense an item, but its inventory is empty.
 */
public interface BlockFailedDispenseEvent extends BlockResultEvent {

    /**
     * @return if the effect should be played
     */
    @Param(0)
    boolean shouldPlayEffect();

}
