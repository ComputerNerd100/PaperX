package io.papermc.paper.api.event.events.world;

import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.game.GameRule;

/**
 * Called when a world's gamerule is changed, either by command or by api.
 */
public interface WorldGameRuleChangeEvent extends CancellableWorldEvent {

    /**
     * Gets the command sender associated with this event.
     *
     * @return {@code null} if the gamerule was changed via api, otherwise the {@link CommandSender}.
     */
    @Param(1)
    CommandSender commandSender();

    /**
     * Gets the game rule associated with this event.
     *
     * @return the gamerule being changed.
     */
    @Param(2)
    GameRule<?> gameRule();

    /**
     * Gets the new value of the gamerule.
     *
     * @return the new value of the gamerule.
     */
    @Param(3)
    String value();
}
