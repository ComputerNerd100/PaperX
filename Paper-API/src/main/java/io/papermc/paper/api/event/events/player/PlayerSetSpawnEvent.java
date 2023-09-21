package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.location.Location;
import net.kyori.adventure.text.Component;

/**
 * Called when a player's spawn is set, either by themselves or otherwise.<br>
 * Cancelling this event will prevent the spawn from being set.
 */
public interface PlayerSetSpawnEvent extends CancellablePlayerEvent {

    /**
     * Gets the cause of this event.
     *
     * @return the cause
     */
    @Param(1)
    Cause cause();

    /**
     * Gets the location that the spawn is set to. The yaw
     * of this location is the spawn angle. Mutating this location
     * will change the resulting spawn point of the player. Use
     * {@link Location#clone()} to get a copy of this location.
     *
     * @return the spawn location, or null if removing the location
     */
    @Param(2)
    Location location();

    /**
     * Gets if this is a force spawn location
     *
     * @return true if forced
     */
    @Param(3)
    boolean forced();

    /**
     * Gets if this action will notify the player their spawn
     * has been set.
     *
     * @return true to notify
     */
    @Param(4)
    boolean notifyPlayer();

    /**
     * Gets the notification message that will be sent to the player
     * if {@link #notifyPlayer()} returns true.
     *
     * @return null if no notification
     */
    @Param(5)
    Component notification();

    enum Cause {
        /**
         * When a player interacts successfully with a bed.
         */
        BED,
        /**
         * When a player interacts successfully with a respawn anchor.
         */
        RESPAWN_ANCHOR,
        /**
         * When a player respawns.
         */
        PLAYER_RESPAWN,
        /**
         * When the {@code /spawnpoint} command is used on a player.
         */
        COMMAND,
        /**
         * When a plugin uses {@link Player#setBedSpawnLocation(Location)} or
         * {@link Player#setBedSpawnLocation(Location, boolean)}.
         */
        PLUGIN,
        /**
         * Fallback cause.
         */
        UNKNOWN,
    }
}
