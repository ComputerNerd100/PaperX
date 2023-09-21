package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;

import java.net.InetAddress;
import java.util.UUID;

/**
 * <p>
 * This event is invoked when a player has disconnected. It is guaranteed that,
 * if the server is in online-mode, that the provided uuid and username have been
 * validated.
 * </p>
 *
 * <p>
 * The event is invoked for players who have not yet logged into the world, whereas
 * {@link PlayerQuitEvent} is only invoked on players who have logged into the world.
 * </p>
 *
 * <p>
 * The event is invoked for players who have already logged into the world,
 * although whether or not the player exists in the world at the time of
 * firing is undefined. (That is, whether the plugin can retrieve a Player object
 * using the event parameters is undefined). However, it is guaranteed that this
 * event is invoked AFTER {@link PlayerQuitEvent}, if the player has already logged into the world.
 * </p>
 *
 * <p>
 * This event is guaranteed to never fire unless {@link AsyncPlayerPreLoginEvent} has
 * been fired beforehand, and this event may not be called in parallel with
 * {@link AsyncPlayerPreLoginEvent} for the same connection.
 * </p>
 *
 * <p>
 * Cancelling the {@link AsyncPlayerPreLoginEvent} guarantees the corresponding
 * {@code PlayerConnectionCloseEvent} is never called.
 * </p>
 */
public interface PlayerConnectionCloseEvent extends Event {

    /**
     * Returns the {@code UUID} of the player disconnecting.
     */
    @Param(0)
    UUID playerUniqueId();

    /**
     * Returns the name of the player disconnecting.
     */
    @Param(1)
    String playerName();

    /**
     * Returns the player's IP address.
     */
    @Param(2)
    InetAddress ipAddress();
}
