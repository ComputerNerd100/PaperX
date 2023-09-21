package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.game.GameMode;
import net.kyori.adventure.text.Component;

/**
 * Called when the GameMode of the player is changed.
 * <p>
 * <b>NOTE:</b> When {@link #cause()} is {@link Cause#DEFAULT_GAMEMODE},
 * the Player from {@link #player()} might not be fully online at
 * the time this event is fired. Plugins should use {@link Player#isOnline()}
 * to check before changing player state.
 */
public interface PlayerGameModeChangeEvent extends CancellablePlayerEvent {

    /**
     * Gets the GameMode the player is switched to.
     *
     * @return  player's new GameMode
     */
    @Param(1)
    GameMode newGameMode();

    /**
     * Gets the cause of this gamemode change.
     *
     * @return the cause
     */
    @Param(2)
    Cause cause();

    /**
     * <b>Only valid if the cause of the gamemode change was directly due to a command.</b>.
     * Gets the message shown to the command user if the event is cancelled
     * as a notification that a player's gamemode was not changed.
     * <p>
     * This returns {@code null} if the gamemode change was due to a plugin, or a
     * player joining the game with a gamemode not equal to the server default gamemode
     * and {@code force-gamemode} is set to true.
     *
     * @return the error message shown to the command user, null if not directly caused by a command
     */
    @Param(3)
    Component cancelMessage();

    enum Cause {

        /**
         * A plugin changed the player's gamemode with
         * {@link Player#setGameMode(GameMode)}.
         */
        PLUGIN,

        /**
         * The {@code /gamemode} command was used.
         */
        COMMAND,

        /**
         * A player had their gamemode changed as a result of
         * the {@code /defaultgamemode} command, or they joined
         * with a gamemode that was not the default gamemode and
         * {@code force-gamemode} in {@code server.properties} is set to true.
         */
        DEFAULT_GAMEMODE,

        /**
         * When the player dies in a hardcore world and has their gamemode
         * changed to {@link GameMode#SPECTATOR}.
         */
        HARDCORE_DEATH,

        /**
         * This cause is only used if a plugin fired their own
         * {@link PlayerGameModeChangeEvent} and did not include a
         * cause. Can usually be ignored.
         */
        UNKNOWN,
    }
}
