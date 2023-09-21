package io.papermc.paper.api.event.events.raid;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.type.Cancellable;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.Raid;

/**
 * Called when a {@link Raid} is triggered (e.g: a player with Bad Omen effect
 * enters a village).
 */
public interface RaidTriggerEvent extends RaidEvent, Cancellable {

    /**
     * Returns the player who triggered the raid.
     *
     * @return triggering player
     */
    @Param(2)
    Player player();
}
