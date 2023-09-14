package io.papermc.paper.api.util.text;

import io.papermc.paper.api.Paper;
import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.entity.Entity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.flattener.ComponentFlattener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

/**
 * Paper API-specific methods for working with {@link Component}s and related.
 */
public final class PaperComponents {
    private PaperComponents() {
        throw new RuntimeException("PaperComponents is not to be instantiated!");
    }

    /**
     * Resolves a component with a specific command sender and subject.
     * <p>
     * Note that in Vanilla, elevated permissions are usually required to use
     * '@' selectors in various component types, but this method should not
     * check such permissions from the sender.
     * <p>
     * A {@link CommandSender} argument is required to resolve:
     * <ul>
     *     <li>{@link net.kyori.adventure.text.NBTComponent}</li>
     *     <li>{@link net.kyori.adventure.text.ScoreComponent}</li>
     *     <li>{@link net.kyori.adventure.text.SelectorComponent}</li>
     * </ul>
     * A {@link Entity} argument is optional to help resolve:
     * <ul>
     *     <li>{@link net.kyori.adventure.text.ScoreComponent}</li>
     * </ul>
     * {@link net.kyori.adventure.text.TranslatableComponent}s don't require any extra arguments.
     *
     * @param input the component to resolve
     * @param context the command sender to resolve with
     * @param scoreboardSubject the scoreboard subject to use (for use with {@link net.kyori.adventure.text.ScoreComponent}s)
     * @return the resolved component
     * @throws IOException if a syntax error tripped during resolving
     */
    public static @NotNull Component resolveWithContext(@NotNull Component input, @Nullable CommandSender context, @Nullable Entity scoreboardSubject) throws IOException {
        return resolveWithContext(input, context, scoreboardSubject, true);
    }

    /**
     * Resolves a component with a specific command sender and subject.
     * <p>
     * Note that in Vanilla, elevated permissions are required to use
     * '@' selectors in various component types. If the boolean {@code bypassPermissions}
     * argument is {@code false}, the {@link CommandSender} argument will be used to query
     * those permissions.
     * <p>
     * A {@link CommandSender} argument is required to resolve:
     * <ul>
     *     <li>{@link net.kyori.adventure.text.NBTComponent}</li>
     *     <li>{@link net.kyori.adventure.text.ScoreComponent}</li>
     *     <li>{@link net.kyori.adventure.text.SelectorComponent}</li>
     * </ul>
     * A {@link Entity} argument is optional to help resolve:
     * <ul>
     *     <li>{@link net.kyori.adventure.text.ScoreComponent}</li>
     * </ul>
     * {@link net.kyori.adventure.text.TranslatableComponent}s don't require any extra arguments.
     *
     * @param input the component to resolve
     * @param context the command sender to resolve with
     * @param scoreboardSubject the scoreboard subject to use (for use with {@link net.kyori.adventure.text.ScoreComponent}s)
     * @param bypassPermissions true to bypass permissions checks for resolving components
     * @return the resolved component
     * @throws IOException if a syntax error tripped during resolving
     */
    public static @NotNull Component resolveWithContext(@NotNull Component input, @Nullable CommandSender context, @Nullable Entity scoreboardSubject, boolean bypassPermissions) throws IOException {
        return Paper.getUnsafe().resolveWithContext(input, context, scoreboardSubject, bypassPermissions);
    }

    /**
     * Return a component flattener that can use game data to resolve extra information about components.
     *
     * @return a component flattener
     */
    public static @NotNull ComponentFlattener flattener() {
        return Paper.getUnsafe().componentFlattener();
    }
}

