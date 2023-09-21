package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;

/**
 * Runs when a player attempts to move, but is prevented from doing so by the server
 */
public interface PlayerFailMoveEvent extends PlayerResultEvent {

    /**
     * Gets the reason this movement was prevented by the server
     * @return The reason the movement was prevented
     */
    @Param(0)
    FailReason failReason();

    /**
     * Gets if the check should be bypassed, allowing the movement
     * @return whether to bypass the check
     */
    @Param(1)
    boolean allowed();

    /**
     * Gets if warnings will be printed to console. eg. "Player123 moved too quickly!"
     * @return whether to log warnings
     */
    @Param(2)
    boolean logWarning();

    /**
     * Gets the location this player moved from
     * @return Location the player moved from
     */
    @Param(3)
    Location from();

    /**
     * Gets the location this player tried to move to
     * @return Location the player tried to move to
     */
    @Param(4)
    Location to();

    enum FailReason {
        MOVED_INTO_UNLOADED_CHUNK, // Only fired if the world setting prevent-moving-into-unloaded-chunks is true
        MOVED_TOO_QUICKLY,
        MOVED_WRONGLY,
        CLIPPED_INTO_BLOCK
    }
}
