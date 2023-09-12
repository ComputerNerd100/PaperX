package io.papermc.paper.api.command;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.ApiStatus;

import java.net.SocketAddress;

public interface RemoteConsoleCommandSender extends CommandSender {

    /**
     * Gets the socket address of this remote sender.
     *
     * @return the remote sender's address
     */
    @NonNull
    @ApiStatus.Experimental
    SocketAddress getAddress();
}

