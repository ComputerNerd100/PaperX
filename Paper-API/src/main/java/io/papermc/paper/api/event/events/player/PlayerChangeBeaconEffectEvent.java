package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a player sets the effect for a beacon
 */
public interface PlayerChangeBeaconEffectEvent extends CancellablePlayerEvent {

    /**
     * @return the primary effect
     */
    @Param(1)
    PotionEffectType primary();

    /**
     * @return the secondary effect
     */
    @Param(2)
    PotionEffectType secondary();

    /**
     * @return the beacon block associated with this event, or null if not found
     */
    @Param(3)
    Block beacon();

    /**
     * Gets if the item used to change the beacon will be consumed.
     * <p>
     * Independent of {@link #isCancelled()}. If the event is cancelled
     * the item will <b>NOT</b> be consumed.
     *
     * @return true if item will be consumed
     */
    @Param(4)
    boolean consumeItem();
}
