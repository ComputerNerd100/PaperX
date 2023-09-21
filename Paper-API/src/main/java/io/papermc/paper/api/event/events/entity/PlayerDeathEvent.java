package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;
import net.kyori.adventure.text.Component;

/**
 * Thrown whenever a {@link Player} dies
 */
public interface PlayerDeathEvent extends EntityDeathEvent {
    default Player player() {
        return (Player) entity();
    }

    /**
     * Gets how much EXP the Player should have at respawn.
     * <p>
     * This does not indicate how much EXP should be dropped, please see
     * {@link #dropExp()} for that.
     *
     * @return New EXP of the respawned player
     */
    @Param(9)
    int newExp();

    /**
     * Get the death message that will appear to everyone on the server.
     *
     * @return Message to appear to other players on the server.
     */
    @Param(10)
    Component adventureDeathMessage();

    /**
     * Gets the Level the Player should have at respawn.
     *
     * @return New Level of the respawned player
     */
    @Param(11)
    int newLevel();

    /**
     * Gets the Total EXP the Player should have at respawn.
     *
     * @return New Total EXP of the respawned player
     */
    @Param(12)
    int newTotalExp();

    /**
     * Gets if the Player should keep all EXP at respawn.
     * <p>
     * This flag overrides other EXP settings
     *
     * @return True if Player should keep all pre-death exp
     */
    @Param(13)
    boolean keepLevel();

    /**
     * Gets if the Player keeps inventory on death.
     *
     * @return True if the player keeps inventory on death
     */
    @Param(14)
    boolean keepInventory();

    /**
     * Gets if the Player should drop EXP on death.
     * @return True if the player should drop exp on death
     */
    @Param(15)
    boolean doExpDrop();
}
