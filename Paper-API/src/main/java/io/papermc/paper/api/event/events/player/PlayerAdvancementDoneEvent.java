package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.advancement.Advancement;
import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

/**
 * Called when a player has completed all criteria in an advancement.
 */
public interface PlayerAdvancementDoneEvent extends PlayerResultEvent {

    /**
     * Get the advancement which has been completed.
     *
     * @return completed advancement
     */
    @Param(0)
    Advancement advancement();

    /**
     * Gets the message to send to all online players.
     * <p>
     * Will be null if the advancement does not announce to chat, for example if
     * it is a recipe unlock or a root advancement.
     *
     * @return The announcement message, or null
     */
    @Param(1)
    Component message();
}
