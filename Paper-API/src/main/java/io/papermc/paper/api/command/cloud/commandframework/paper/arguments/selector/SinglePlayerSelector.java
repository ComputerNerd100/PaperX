package io.papermc.paper.api.command.cloud.commandframework.paper.arguments.selector;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

public final class SinglePlayerSelector extends MultiplePlayerSelector {

    /**
     * Construct a new selector
     *
     * @param selector The input string used to create this selector
     * @param entities The List of Bukkit {@link Entity entities} to construct the {@link EntitySelector} from
     */
    public SinglePlayerSelector(
            final @NonNull String selector,
            final @NonNull List<@NonNull Entity> entities
    ) {
        super(selector, entities);
        if (getPlayers().size() > 1) {
            throw new IllegalArgumentException("More than 1 player selected in single player selector.");
        }
    }

    /**
     * Get the selected player or null if no player matched
     *
     * @return Gets the single player parsed by the selector
     */
    public @Nullable Player getPlayer() {
        if (this.getPlayers().isEmpty()) {
            return null;
        }
        return this.getPlayers().get(0);
    }
}

