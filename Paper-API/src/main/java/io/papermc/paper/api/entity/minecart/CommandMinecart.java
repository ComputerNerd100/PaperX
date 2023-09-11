package io.papermc.paper.api.entity.minecart;

import io.papermc.paper.api.entity.Minecart;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface CommandMinecart extends Minecart, CommandBlockHolder { 

    /**
     * Gets the command that this CommandMinecart will run when activated.
     * This will never return null.  If the CommandMinecart does not have a
     * command, an empty String will be returned instead.
     *
     * @return Command that this CommandMinecart will run when powered.
     */
    @NonNull
    String getCommand();

    /**
     * Sets the command that this CommandMinecart will run when activated.
     * Setting the command to null is the same as setting it to an empty
     * String.
     *
     * @param command Command that this CommandMinecart will run when
     *     activated.
     */
    void setCommand(@Nullable String command);
}
