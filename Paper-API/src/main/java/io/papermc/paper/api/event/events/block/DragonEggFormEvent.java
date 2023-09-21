package io.papermc.paper.api.event.events.block;

import io.papermc.paper.api.boss.DragonBattle;
import io.papermc.paper.api.entity.EnderDragon;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.material.Material;

/**
 * Called when the {@link EnderDragon} is defeated (killed) in a {@link DragonBattle},
 * causing a {@link Material#DRAGON_EGG} (more formally: {@link #newState()})
 * to possibly appear depending on {@link #isCancelled()}.
 * <b>This event might be cancelled by default depending on
 * eg. {@link DragonBattle#hasBeenPreviouslyKilled()} and server configuration.</b>
 */
public interface DragonEggFormEvent extends BlockFormEvent {

    /**
     * Gets the {@link DragonBattle} associated with this event.
     * Keep in mind that the {@link EnderDragon} is already dead
     * when this event is called.
     *
     * @return the dragon battle
     */
    @Param(2)
    DragonBattle dragonBattle();
}
