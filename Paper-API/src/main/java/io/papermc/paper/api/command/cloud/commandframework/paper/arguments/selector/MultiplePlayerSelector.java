package io.papermc.paper.api.command.cloud.commandframework.paper.arguments.selector;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.EntityType;
import io.papermc.paper.api.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiplePlayerSelector extends MultipleEntitySelector {

    private final List<Player> players = new ArrayList<>();

    /**
     * Construct a new selector
     *
     * @param selector The input string used to create this selector
     * @param entities The List of Bukkit {@link Entity}s to construct the {@link EntitySelector} from
     */
    public MultiplePlayerSelector(
            final @NonNull String selector,
            final @NonNull List<@NonNull Entity> entities
    ) {
        super(selector, entities);
        entities.forEach(e -> {
            if (e.getType() != EntityType.PLAYER) {
                throw new IllegalArgumentException("Non-players selected in player selector.");
            } else {
                this.players.add((Player) e);
            }
        });
    }

    /**
     * Get the resulting players
     *
     * @return Immutable views of the list of Bukkit {@link Player players} parsed from the selector
     */
    public final @NonNull List<@NonNull Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }
}
