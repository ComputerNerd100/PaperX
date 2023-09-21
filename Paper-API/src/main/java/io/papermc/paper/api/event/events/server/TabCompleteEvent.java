package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.events.player.PlayerCommandSendEvent;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;

import java.util.List;

/**
 * Called when a {@link CommandSender} of any description (ie: player or
 * console) attempts to tab complete.
 * <br>
 * Note that due to client changes, if the sender is a Player, this event will
 * only begin to fire once command arguments are specified, not commands
 * themselves. Plugins wishing to remove commands from tab completion are
 * advised to ensure the client does not have permission for the relevant
 * commands, or use {@link PlayerCommandSendEvent}.
 */
public interface TabCompleteEvent extends Event, Cancellable {

    /**
     * Get the sender completing this command.
     *
     * @return the {@link CommandSender} instance
     */
    @Param(0)
    CommandSender sender();

    /**
     * Return the entire buffer which formed the basis of this completion.
     *
     * @return command buffer, as entered
     */
    @Param(1)
    String buffer();

    /**
     * The list of completions which will be offered to the sender, in order.
     * This list is mutable and reflects what will be offered.
     *
     * @return a list of offered completions
     */
    @Param(2)
    List<String> completions();
}
