package io.papermc.paper.api.command.cloud.commandframework.paper.arguments.selector;

import io.papermc.paper.api.entity.Entity;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collections;
import java.util.List;

/**
 * A class to represent the result of parsing a Minecraft Entity/Target Selector argument
 */
public abstract class EntitySelector {

    private final String selector;
    private final List<Entity> entities;

    /**
     * Construct a new entity selector
     *
     * @param selector The input string used to create this selector
     * @param entities The List of Bukkit {@link Entity entities} to construct the {@link EntitySelector} from
     */
    protected EntitySelector(
            final @NonNull String selector,
            final @NonNull List<@NonNull Entity> entities
    ) {
        this.selector = selector;
        this.entities = entities;
    }

    /**
     * Get the resulting entities
     *
     * @return Immutable view of the list list of entities resulting from parsing the entity selector
     */
    public @NonNull List<@NonNull Entity> getEntities() {
        return Collections.unmodifiableList(this.entities);
    }

    /**
     * Get the input String for this selector
     *
     * @return The input String for this selector
     */
    public @NonNull String getSelector() {
        return this.selector;
    }

    /**
     * Check whether the selector selected at least one entity
     *
     * @return {@code true} if at least one entity was selected, else {@code false}
     */
    public boolean hasAny() {
        return !this.entities.isEmpty();
    }
}

