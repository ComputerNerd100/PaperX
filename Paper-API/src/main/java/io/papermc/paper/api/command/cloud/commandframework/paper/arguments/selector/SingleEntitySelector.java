package io.papermc.paper.api.command.cloud.commandframework.paper.arguments.selector;

import io.papermc.paper.api.entity.Entity;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

public final class SingleEntitySelector extends MultipleEntitySelector {

    /**
     * Construct a new selector
     *
     * @param selector The input string used to create this selector
     * @param entities The List of Bukkit {@link Entity entities} to construct the {@link EntitySelector} from
     */
    public SingleEntitySelector(
            final @NonNull String selector,
            final @NonNull List<@NonNull Entity> entities
    ) {
        super(selector, entities);
        if (entities.size() > 1) {
            throw new IllegalArgumentException("More than 1 entity selected in single entity selector.");
        }
    }

    /**
     * Get the selected entity or null if no entity matched
     *
     * @return Gets the single Bukkit Entity parsed by the selector
     */
    public @Nullable Entity getEntity() {
        if (this.getEntities().isEmpty()) {
            return null;
        }
        return this.getEntities().get(0);
    }
}

