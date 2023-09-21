package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

import java.net.InetAddress;

/**
 * Stores details for players attempting to log in.
 * <br>
 * Note that this event is called <i>early</i> in the player initialization
 * process. It is recommended that most options involving the Player
 * <i>entity</i> be postponed to the {@link PlayerJoinEvent} instead.
 */
public interface PlayerLoginEvent extends PlayerResultEvent {

    /**
     * Gets the {@link InetAddress} for the Player associated with this event.
     * This method is provided as a workaround for player.getAddress()
     * returning null during PlayerLoginEvent.
     *
     * @return The address for this player. For legacy compatibility, this may
     *     be null.
     */
    @Param(0)
    InetAddress address();

    /**
     * Gets the hostname that the player used to connect to the server, or
     * blank if unknown
     *
     * @return The hostname
     */
    @Param(1)
    String hostname();

    /**
     * Gets the current result of the login, as an enum
     *
     * @return Current Result of the login
     */
    @Param(2)
    Result eventResult();

    /**
     * Gets the current kick message that will be used if getResult() !=
     * Result.ALLOWED
     *
     * @return Current kick message
     */
    @Param(3)
    Component message();

    /**
     * Gets the connection address of this player, regardless of whether it has been spoofed or not.
     *
     * @return the player's connection address
     */
    @Param(4)
    InetAddress realAddress();

    /**
     * Basic kick reasons for communicating to plugins
     */
    enum Result {
        /**
         * The player is allowed to log in
         */
        ALLOWED,
        /**
         * The player is not allowed to log in, due to the server being full
         */
        KICK_FULL,
        /**
         * The player is not allowed to log in, due to them being banned
         */
        KICK_BANNED,
        /**
         * The player is not allowed to log in, due to them not being on the
         * white list
         */
        KICK_WHITELIST,
        /**
         * The player is not allowed to log in, for reasons undefined
         */
        KICK_OTHER
    }
}
