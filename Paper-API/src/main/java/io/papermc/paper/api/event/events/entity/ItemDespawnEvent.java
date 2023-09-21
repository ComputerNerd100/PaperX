package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Item;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * This event is called when a {@link Item} is removed from
 * the world because it has existed for 5 minutes.
 * <p>
 * Cancelling the event results in the item being allowed to exist for 5 more
 * minutes. This behavior is not guaranteed and may change in future versions.
 */
public interface ItemDespawnEvent extends CancellableEntityEvent {
    default Item despawnee() {
        return (Item) entity();
    }

    /**
     * Gets the location at which the item is despawning.
     *
     * @return The location at which the item is despawning
     */
    @Param(1)
    Location location();
}
