package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

import java.util.UUID;


/**
 * This event is fired during a player handshake.
 *
 * <p>If there are no listeners listening to this event, the logic default
 * to your server platform will be ran.</p>
 *
 * <p>WARNING: TAMPERING WITH THIS EVENT CAN BE DANGEROUS</p>
 */
public interface PlayerHandshakeEvent extends Event, Cancellable {

    /**
     * Gets the original handshake string.
     *
     * @return the original handshake string
     */
    @Param(0)
    String originalHandshake();

    /**
     * Gets the original socket address hostname.
     *
     * <p>This does not include the port.</p>
     * <p>In cases where this event is manually fired and the plugin wasn't updated yet, the default is {@code "127.0.0.1"}.</p>
     *
     * @return the original socket address hostname
     */
    @Param(1)
    String originalSocketAddressHostname();

    /**
     * Gets the server hostname string.
     *
     * <p>This should not include the port.</p>
     *
     * @return the server hostname string
     */
    @Param(2)
    String serverHostname();

    /**
     * Gets the socket address hostname string.
     *
     * <p>This should not include the port.</p>
     *
     * @return the socket address hostname string
     */
    @Param(3)
    String socketAddressHostname();

    /**
     * Gets the unique id.
     *
     * @return the unique id
     */
    @Param(4)
    UUID uniqueId();

    /**
     * Gets the profile properties.
     *
     * <p>This should be a valid JSON string.</p>
     *
     * @return the profile properties, as JSON
     */
    @Param(5)
    String propertiesJson();

    /**
     * Determines if authentication failed.
     *
     * <p>When {@code true}, the client connecting will be disconnected
     * with the {@link #failMessage() fail message}.</p>
     *
     * @return {@code true} if authentication failed, {@code false} otherwise
     */
    @Param(6)
    boolean failed();

    /**
     * Gets the message to display to the client when authentication fails.
     *
     * @return the message to display to the client
     */
    @Param(7)
    Component failMessage();
}
