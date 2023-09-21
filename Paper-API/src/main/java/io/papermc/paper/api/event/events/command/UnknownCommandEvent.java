package io.papermc.paper.api.event.events.command;

import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

/**
 * Thrown when a player executes a command that is not defined
 */
public interface UnknownCommandEvent extends Event {

    /**
     * Gets the CommandSender or ConsoleCommandSender
     * <p>
     *
     * @return Sender of the command
     */
    @Param(0)
    CommandSender sender();

    /**
     * Gets the command that was send
     * <p>
     *
     * @return Command sent
     */
    @Param(1)
    String commandLine();

    /**
     * Gets message that will be returned
     * <p>
     *
     * @return Unknown command message
     */
    @Param(2)
    Component message();
}
