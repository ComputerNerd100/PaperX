package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Called when the server detects the player is jumping.
 * <p>
 * Added to avoid the overhead and special case logic that many plugins use
 * when checking for jumps via PlayerMoveEvent, this event is fired whenever
 * the server detects that the player is jumping.
 */
public interface PlayerJumpEvent extends CancellablePlayerEvent {

    /**
     * Gets the location this player jumped from
     *
     * @return Location the player jumped from
     */
    @Param(1)
    Location from();

    /**
     * Gets the location this player jumped to
     *
     * This information is based on what the client sends, it typically
     * has little relation to the arc of the jump at any given point.
     *
     * @return Location the player jumped to
     */
    @Param(2)
    Location to();
}
