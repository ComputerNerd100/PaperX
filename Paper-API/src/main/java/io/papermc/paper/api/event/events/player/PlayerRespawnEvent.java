package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Called when a player respawns.
 * <p>
 * If changing player state, see {@link PlayerPostRespawnEvent}
 * because the player is "reset" between this event and that event and some changes won't persist.
 */
public interface PlayerRespawnEvent extends PlayerResultEvent {

    /**
     * Gets the current respawn location
     *
     * @return Location current respawn location
     */
    @Param(0)
    Location respawnLocation();

    /**
     * Gets whether the respawn location is the player's bed.
     *
     * @return true if the respawn location is the player's bed.
     */
    @Param(1)
    boolean isBedSpawn();

    /**
     * Gets whether the respawn location is the player's respawn anchor.
     *
     * @return true if the respawn location is the player's respawn anchor.
     */
    @Param(2)
    boolean isAnchorSpawn();

    /**
     * Gets the reason this respawn event was called.
     *
     * @return the reason the event was called.
     */
    @Param(3)
    RespawnReason respawnReason();

    /**
     * Gets the flags that were set for this respawn event.
     * @return the flags that were set for this respawn event.
     */
    @Param(4)
    Set<RespawnFlag> respawnFlags();

    /**
     * An enum to specify the reason a respawn event was called.
     */
    enum RespawnReason {

        /**
         * When the player dies and presses the respawn button.
         */
        DEATH,
        /**
         * When the player exits the end through the end portal.
         */
        END_PORTAL,
        /**
         * When a plugin respawns the player.
         */
        PLUGIN;
    }

    enum RespawnFlag {
        /**
         * Will use the bed spawn location
         */
        BED_SPAWN,
        /**
         * Will use the respawn anchor location
         */
        ANCHOR_SPAWN,
        /**
         * Is caused by going to the end portal in the end.
         */
        END_PORTAL,
    }
}
