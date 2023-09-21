package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

import java.net.InetAddress;

/**
 * Called when a server list ping is coming in. Displayed players can be
 * checked and removed by {@link #iterator() iterating} over this event.
 * <br>
 * <b>Note:</b> The players in {@link #iterator()} will not be shown in the
 * server info if {@link Paper#hideOnlinePlayers()} is true.
 */
public interface ServerListPingEvent extends ServerEvent, Iterable<Player> {
    int MAGIC_PLAYER_COUNT = Integer.MIN_VALUE;

    /**
     * Gets the hostname that the player used to connect to the server, or
     * blank if unknown
     *
     * @return The hostname
     */
    @Param(0)
    String hostname();

    /**
     * Get the address the ping is coming from.
     *
     * @return the address
     */
    @Param(1)
    InetAddress address();

    /**
     * Get the message of the day message.
     *
     * @return the message of the day
     */
    @Param(2)
    Component motd();

    /**
     * Get the number of players sent.
     *
     * @return the number of players
     */
    @Param(3)
    int numPlayers();

    /**
     * Get the maximum number of players sent.
     *
     * @return the maximum number of players
     */
    @Param(4)
    int maxPlayers();
}
