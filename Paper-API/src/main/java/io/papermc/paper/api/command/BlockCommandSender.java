package io.papermc.paper.api.command;

import io.papermc.paper.api.block.Block;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface BlockCommandSender extends CommandSender {

    /**
     * Returns the block this command sender belongs to
     *
     * @return Block for the command sender
     */
    @NonNull
    Block getBlock();
}
