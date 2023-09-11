package io.papermc.paper.api.boss;

import io.papermc.paper.api.entity.EnderCrystal;
import io.papermc.paper.api.entity.EnderDragon;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.math.Position;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collection;
import java.util.List;

/**
 * Represents a dragon battle state for a world with an end environment.
 */
public interface DragonBattle {

    /**
     * Get the {@link EnderDragon} active in this battle.
     * <br>
     * Will return null if the dragon has been slain.
     *
     * @return the ender dragon. null if dead
     */
    @Nullable EnderDragon getEnderDragon();

    /**
     * Get the boss bar to be displayed for this dragon battle.
     *
     * @return the boss bar
     */
    @NonNull BossBar getBossBar();

    /**
     * Get the location of the end portal.
     * <br>
     * This location will be at the center of the base (bottom) of the portal.
     *
     * @return the end portal location or null if not generated
     */
    @Nullable Location getEndPortalLocation();

    /**
     * Generate the end portal.
     *
     * @param withPortals whether end portal blocks should be generated
     *
     * @return true if generated, false if already present
     */
    boolean generateEndPortal(boolean withPortals);

    /**
     * Check whether the first dragon has been killed already.
     *
     * @return true if killed before, false otherwise
     */
    boolean hasBeenPreviouslyKilled();

    /**
     * Try to initiate a respawn sequence to summon the dragon as though a player has
     * placed 4 end crystals on the portal.
     */
    void initiateRespawn();

    /**
     * Try to initiate a respawn sequence to summon the dragon.
     *
     * @param enderCrystals the {@link EnderCrystal EnderCrystals} to use in the
     * respawn, or a null or empty list to render the respawn sequence
     * uncancellable. null entries or crystals that do not reside in the same
     * world as this dragon battle will be ignored.
     *
     * @return true if the respawn was initiated, false otherwise.
     */
    boolean initiateRespawn(@Nullable Collection<EnderCrystal> enderCrystals);

    /**
     * Get this battle's current respawn phase.
     *
     * @return the current respawn phase.
     */
    @NonNull RespawnPhase getRespawnPhase();

    /**
     * Set the dragon's respawn phase.
     * <br>
     * This method will is unsuccessful if a dragon respawn is not in progress.
     *
     * @param phase the phase to set
     *
     * @return true if successful, false otherwise
     *
     * @see #initiateRespawn()
     */
    boolean setRespawnPhase(@NonNull RespawnPhase phase);

    /**
     * Reset the crystals located on the obsidian pillars (remove their beam
     * targets and invulnerability).
     */
    void resetCrystals();

    /**
     * Represents a phase in the dragon respawn process.
     */
    enum RespawnPhase {

        /**
         * The crystal beams are directed upwards into the sky.
         */
        START,
        /**
         * The crystal beams remain directed upwards.
         */
        PREPARING_TO_SUMMON_PILLARS,
        /**
         * The crystal beams are directed from pillar to pillar, regenerating
         * their crystals if necessary.
         */
        SUMMONING_PILLARS,
        /**
         * All crystals (including those from the pillars) are aimed towards the
         * sky. Shortly thereafter summoning the dragon and destroying the
         * crystals used to initiate the dragon's respawn.
         */
        SUMMONING_DRAGON,
        /**
         * The end of the respawn sequence. The dragon is actually summoned.
         */
        END,
        /**
         * No respawn is in progress.
         */
        NONE
    }
    // Paper start
    /**
     * Gets the number of gateways tracked by this DragonBattle.
     * This starts out at 0 and will increase to 20, once for each
     * kill of the {@link EnderDragon}.
     *
     * @return the number of gateways around the end island tracked by this
     */
    int getGatewayCount();

    /**
     * Tries to spawn a new end gateway using default game mechanics.
     *
     * @return true if successful, false if there is already the maximum.
     */
    boolean spawnNewGateway();

    /**
     * Spawns a new end gateway at the specified position. This will
     * spawn regardless of the number of gateways already present.
     *
     * @param position position for the new gateway
     */
    void spawnNewGateway(@NonNull Position position);

    /**
     * Gets the {@link EnderCrystal}s being used to respawn the dragon. If no respawn
     * is ongoing, the list will be empty.
     *
     * @return the respawn crystals
     */
    @NonNull @Unmodifiable List<EnderCrystal> getRespawnCrystals();

    /**
     * Gets the {@link EnderCrystal}s on top of the pillars that heal the dragon.
     *
     * @return the healing crystals
     */
    @NonNull @Unmodifiable List<EnderCrystal> getHealingCrystals();
}
// Paper end
