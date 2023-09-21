package io.papermc.paper.api.event.events.raid;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.util.Raid;

import java.util.List;

/**
 * This event is called when a {@link Raid} was complete with a clear result.
 */
public interface RaidFinishEvent extends RaidEvent {

    /**
     * Returns an immutable list contains all winners.
     * <br>
     * <b>Note: Players who are considered as heroes but were not online at the
     * end would not be included in this list.</b>
     *
     * @return winners
     */
    @Param(2)
    List<Player> winners();
}
