package io.papermc.paper.api.event.events.brigadier;

import cloud.commandframework.Command;
import com.mojang.brigadier.tree.ArgumentCommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import io.papermc.paper.api.brigadier.PaperBrigadierCommand;
import io.papermc.paper.api.brigadier.PaperBrigadierCommandSource;
import io.papermc.paper.api.command.cloud.commandframework.paper.PaperCommand;
import io.papermc.paper.api.event.events.server.CancellableServerEvent;
import io.papermc.paper.api.event.util.Param;

public interface CommandRegisteredEvent<S extends PaperBrigadierCommandSource> extends CancellableServerEvent {
    @Param(0)
    String commandLabel();
    @Param(1)
    PaperCommand<?> command();
    @Param(2)
    PaperBrigadierCommand<S> brigadierCommand();
    @Param(3)
    RootCommandNode<S> commandNode();
    @Param(4)
    ArgumentCommandNode<S, String> argumentNode();
    @Param(5)
    LiteralCommandNode<S> literalNode();
    @Param(6)
    boolean rawCommand();
}
