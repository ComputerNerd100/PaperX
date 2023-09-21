package io.papermc.paper.api.event.events.server;

import io.papermc.paper.api.Server;
import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.event.events.player.AsyncChatEvent;
import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

import java.util.Set;

/**
 * Event triggered for server broadcast messages such as from
 * {@link Server#broadcast(net.kyori.adventure.text.Component)} (String, String)}.
 *
 * <b>This event behaves similarly to {@link AsyncChatEvent} in that it
 * should be async if fired from an async thread. Please see that event for
 * further information.</b>
 */
public interface BroadcastMessageEvent extends CancellableServerEvent {

    /**
     * Get the broadcast message.
     *
     * @return Message to broadcast
     */
    @Param(0)
    Component message();

    /**
     * Gets a set of recipients that this chat message will be displayed to.
     * <p>
     * The set returned is not guaranteed to be mutable and may auto-populate
     * on access. Any listener accessing the returned set should be aware that
     * it may reduce performance for a lazy set implementation.
     * <p>
     * Listeners should be aware that modifying the list may throw {@link
     * UnsupportedOperationException} if the event caller provides an
     * unmodifiable set.
     *
     * @return All CommandSenders who will see this chat message
     */
    @Param(1)
    Set<CommandSender> recipients();
}
