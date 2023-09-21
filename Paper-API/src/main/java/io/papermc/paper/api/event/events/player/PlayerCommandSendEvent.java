package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;

import java.util.Collection;

/**
 * This event is called when the list of available server commands is sent to
 * the player.
 * <br>
 * Commands may be removed from display using this event, but implementations
 * are not required to securely remove all traces of the command. If secure
 * removal of commands is required, then the command should be assigned a
 * permission which is not granted to the player.
 */
public interface PlayerCommandSendEvent extends PlayerResultEvent {

    /**
     * Returns a mutable collection of all top level commands to be sent.
     * <br>
     * It is not legal to add entries to this collection, only remove them.
     * Behaviour of adding entries is undefined.
     *
     * @return collection of all commands
     */
    @Param(0)
    Collection<String> commands();
}
