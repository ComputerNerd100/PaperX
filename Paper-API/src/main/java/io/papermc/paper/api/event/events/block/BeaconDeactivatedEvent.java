package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.tilestate.Beacon;
import io.papermc.paper.api.material.Material;

/**
 * Called when a beacon is deactivated, either because its base block(s) or itself were destroyed.
 */
public interface BeaconDeactivatedEvent extends BlockResultEvent {
    /**
     * Returns the beacon that was deactivated.
     * This will return null if the beacon does not exist.
     * (which can occur after the deactivation of a now broken beacon)
     *
     * @return The beacon that got deactivated, or null if it does not exist.
     */
    default Beacon beacon() {
        return block().getType() == Material.BEACON ? (Beacon) block().getState() : null;
    }
}
