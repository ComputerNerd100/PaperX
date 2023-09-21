package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.network.StatusClient;
import io.papermc.paper.api.profile.PlayerProfile;
import io.papermc.paper.api.util.CachedServerIcon;

import java.util.List;

/**
 * Extended version of {@link ServerListPingEvent} that allows full control
 * of the response sent to the client.
 */
public interface PaperServerListPingEvent extends ServerListPingEvent, Cancellable {

    /**
     * Returns the {@link StatusClient} pinging the server.
     *
     * @return The client
     */
    @Param(0)
    StatusClient client();

    /**
     * {@inheritDoc}
     *
     * <p>Returns {@code -1} if players are hidden using
     * {@link #hidePlayers()}.</p>
     */
    @Param(1)
    int numPlayers();

    /**
     * Returns whether all player related information is hidden in the server
     * list. This will cause {@link #numPlayers()}, {@link #maxPlayers()}
     * and {@link #playerSample()} to be skipped in the response.
     *
     * <p>The Vanilla Minecraft client will display the player count as {@code ???}
     * when this option is enabled.</p>
     *
     * @return {@code true} if the player count is hidden
     */
    @Param(2)
    boolean hidePlayers();

    /**
     * Returns a mutable list of {@link PlayerProfile} that will be displayed
     * as online players on the client.
     *
     * <p>The Vanilla Minecraft client will display them when hovering the
     * player count with the mouse.</p>
     *
     * @return The mutable player sample list
     */
    @Param(3)
    List<PlayerProfile> playerSample();

    /**
     * Returns the version that will be sent as server version on the client.
     *
     * @return The server version
     */
    @Param(4)
    String version();

    /**
     * Returns the protocol version that will be sent as the protocol version
     * of the server to the client.
     *
     * @return The protocol version of the server, or {@code -1} if the server
     * has not finished initialization yet
     */
    @Param(5)
    int protocolVersion();

    /**
     * Gets the server icon sent to the client.
     *
     * @return The icon to send to the client, or {@code null} for none
     */
    @Param(6)
    CachedServerIcon favicon();

    /**
     * Returns whether the original player count should be sent to the client.
     * @return {@code true} if the original player count should be sent
     */
    @Param(7)
    boolean originalPlayerCount();

    /**
     * Returns an array of players that will be displayed on the client.
     * @return The array of players
     */
    @Param(8)
    Object[] players();
}
