package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.block.sign.Side;
import io.papermc.paper.api.block.tilestate.Sign;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a {@link Player} clicks a side on a sign that causes a command to run.
 * <p>
 * This command is run with elevated permissions which allows players to access commands on signs they wouldn't
 * normally be able to run.
 */
public interface PlayerSignCommandPreprocessEvent extends PlayerCommandPreprocessEvent {

    /**
     * Gets the sign that the command originated from.
     *
     * @return the sign
     */
    @Param(3)
    Sign sign();

    /**
     * Gets the side of the sign that the command originated from.
     *
     * @return the sign side
     */
    @Param(4)
    Side side();
}
