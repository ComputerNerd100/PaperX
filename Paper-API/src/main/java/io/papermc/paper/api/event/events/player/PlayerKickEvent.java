package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

/**
 * Called when a player gets kicked from the server
 */
public interface PlayerKickEvent extends CancellablePlayerEvent {

    /**
     * Gets the leave message send to all online players
     *
     * @return string kick reason
     */
    @Param(1)
    Component leaveMessage();

    /**
     * Gets the reason why the player is getting kicked
     *
     * @return string kick reason
     */
    @Param(2)
    Component kickReason();
    @Param(3)
    Cause cause();

    enum Cause {

        PLUGIN,

        WHITELIST,

        BANNED,

        IP_BANNED,

        KICK_COMMAND,

        FLYING_PLAYER,

        FLYING_VEHICLE,

        TIMEOUT,

        IDLING,

        INVALID_VEHICLE_MOVEMENT,

        INVALID_PLAYER_MOVEMENT,

        INVALID_ENTITY_ATTACKED,

        INVALID_PAYLOAD,

        SPAM,

        ILLEGAL_ACTION,

        ILLEGAL_CHARACTERS,

        OUT_OF_ORDER_CHAT,

        UNSIGNED_CHAT,

        CHAT_VALIDATION_FAILED,

        EXPIRED_PROFILE_PUBLIC_KEY,

        INVALID_PUBLIC_KEY_SIGNATURE,

        TOO_MANY_PENDING_CHATS,

        SELF_INTERACTION,

        DUPLICATE_LOGIN,

        RESOURCE_PACK_REJECTION,

        /**
         * Spigot's restart command
         */
        RESTART_COMMAND,
        /**
         * Fallback cause
         */
        UNKNOWN,
    }
}
