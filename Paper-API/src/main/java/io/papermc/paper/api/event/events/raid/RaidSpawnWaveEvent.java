package io.papermc.paper.api.event.events.raid;

import io.papermc.paper.api.entity.Raider;
import io.papermc.paper.api.event.util.Param;

import java.util.List;

/**
 * Called when a raid wave spawns.
 */
public interface RaidSpawnWaveEvent extends RaidEvent {

    /**
     * Returns all {@link Raider} that spawned in this wave.
     *
     * @return an immutable list of raiders
     */
    @Param(2)
    List<Raider> raiders();

    /**
     * Returns the patrol leader.
     *
     * @return {@link Raider}
     */
    @Param(3)
    Raider leader();
}
