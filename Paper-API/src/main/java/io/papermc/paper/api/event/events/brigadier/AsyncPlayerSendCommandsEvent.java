package io.papermc.paper.api.event.events.brigadier;

import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.tree.RootCommandNode;
import io.papermc.paper.api.brigadier.PaperBrigadierCommandSource;
import io.papermc.paper.api.event.events.player.PlayerResultEvent;
import io.papermc.paper.api.event.events.server.AsyncTabCompleteEvent;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when sending {@link Suggestions} to the client. Will be called asynchronously if a plugin
 * marks the {@link AsyncTabCompleteEvent} event handled asynchronously,
 * otherwise called synchronously.
 */
public interface AsyncPlayerSendCommandsEvent<S extends PaperBrigadierCommandSource> extends PlayerResultEvent {

    /**
     * Gets the full Root Command Node being sent to the client, which is mutable.
     *
     * @return the root command node
     */
    @Param(0)
    RootCommandNode<S> commandNode();
}
