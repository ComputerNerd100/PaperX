package io.papermc.paper.api.event.events.profile;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.profile.PlayerProfile;
import net.kyori.adventure.text.Component;

/**
 * Fires when the server needs to verify if a player is whitelisted.
 *
 * Plugins may override/control the servers whitelist with this event,
 * and dynamically change the kick message.
 */
public interface ProfileWhitelistVerifyEvent extends Event {

    /**
     * @return The profile of the player trying to connect
     */
    @Param(0)
    PlayerProfile profile();

    /**
     * @return if the server even has whitelist on
     */
    @Param(1)
    boolean whitelistEnabled();

    /**
     * @return Whether the player is whitelisted to play on this server (whitelist may be off is why its true)
     */
    @Param(2)
    boolean whitelisted();

    /**
     * @return if the player obtained whitelist status by having op
     */
    @Param(3)
    boolean isOp();

    /**
     * @return the currently planned message to send to the user if they are not whitelisted
     */
    @Param(4)
    Component kickMessage();
}
