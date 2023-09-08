package io.papermc.paper.api.block.tilestate;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a captured state of a command block.
 */
public interface CommandBlock extends TileState, CommandBlockHolder { // Paper

    /**
     * Gets the command that this CommandBlock will run when powered.
     * This will never return null.  If the CommandBlock does not have a
     * command, an empty String will be returned instead.
     *
     * @return Command that this CommandBlock will run when powered.
     */
    @NotNull
    public String getCommand();

    /**
     * Sets the command that this CommandBlock will run when powered.
     * Setting the command to null is the same as setting it to an empty
     * String.
     *
     * @param command Command that this CommandBlock will run when powered.
     */
    void setCommand(@Nullable String command);

    /**
     * Gets the name of this CommandBlock.  The name is used with commands
     * that this CommandBlock executes.  This name will never be null, and
     * by default is a {@link net.kyori.adventure.text.TextComponent} containing {@code @}.
     *
     * @return Name of this CommandBlock.
     */
    @NotNull Component name();

    /**
     * Sets the name of this CommandBlock.  The name is used with commands
     * that this CommandBlock executes.  Setting the name to null is the
     * same as setting it to a {@link net.kyori.adventure.text.TextComponent} containing {@code @}.
     *
     * @param name New name for this CommandBlock.
     */
   void name(@Nullable Component name);
}

