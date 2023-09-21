package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.profile.PlayerProfile;
import net.kyori.adventure.text.Component;

import java.net.InetAddress;

/**
 * Stores details for players attempting to log in.
 * <p>
 * This event is asynchronous, and not run using main thread.
 */
public interface AsyncPlayerPreLoginEvent extends Event {

    /**
     * Gets the current result of the login, as an enum
     *
     * @return Current Result of the login
     */
    @Param(0)
    Result result();

    /**
     * Gets the message to be displayed to the user
     * @return The message
     */
    @Param(1)
    Component message();

    /**
     * Gets the player IP address.
     *
     * @return The IP address
     */
    @Param(2)
    InetAddress ipAddress();

    /**
     * Gets the raw address of the player logging in
     * @return The address
     */
    @Param(3)
    InetAddress rawAddress();

    /**
     * Gets the hostname that the player used to connect to the server, or
     * blank if unknown
     *
     * @return The hostname
     */
    @Param(4)
    String hostname();

    /**
     * Gets the PlayerProfile of the player logging in
     * @return The Profile
     */
    @Param(5)
    PlayerProfile profile();

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
        KICK_OTHER;
    }
}
