package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.tilestate.Beacon;

/**
 * Called when a beacon is activated.
 * Activation occurs when the beacon beam becomes visible.
 */
public interface BeaconActivatedEvent extends BlockResultEvent {
    /**
     * Returns the beacon that was activated.
     *
     * @return the beacon that was activated.
     */
    default Beacon beacon() {
        return (Beacon) block();
    }
}
