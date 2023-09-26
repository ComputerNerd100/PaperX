package io.papermc.paper.api.command.cloud.commandframework.paper.arguments.selector;

import io.papermc.paper.api.entity.Entity;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public class MultipleEntitySelector extends EntitySelector {

    /**
     * @param selector The input string used to create this selector
     * @param entities The List of Bukkit {@link Entity}s to construct the {@link EntitySelector} from
     */
    public MultipleEntitySelector(
            final @NonNull String selector,
            final @NonNull List<@NonNull Entity> entities
    ) {
        super(selector, entities);
    }
}

