package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.block.sign.Side;
import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

import java.util.List;

/**
 * Called when a sign is changed by a player.
 * <p>
 * If a Sign Change event is cancelled, the sign will not be changed.
 */
public interface SignChangeEvent extends CancellableBlockEvent {

    /**
     * Gets the player changing the sign involved in this event.
     *
     * @return the Player involved in this event
     */
    @Param(1)
    Player player();

    /**
     * Gets all of the lines of text from the sign involved in this event.
     *
     * @return the String array for the sign's lines new text
     */
    @Param(2)
    List<Component> adventureLines();

    /**
     * Returns which side is changed.
     *
     * @return the affected side of the sign
     */
    @Param(3)
    Side side();

}
