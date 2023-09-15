package io.papermc.paper.api.scoreboard;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.player.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

/**
 * A scoreboard
 */
public interface Scoreboard {

    /**
     * Registers an Objective on this Scoreboard
     *
     * @param name Name of the Objective
     * @param criteria Criteria for the Objective
     * @param displayName Name displayed to players for the Objective.
     * @return The registered Objective
     * @throws IllegalArgumentException if name is longer than 32767
     *     characters.
     * @throws IllegalArgumentException if an objective by that name already
     *     exists
     */
    @NotNull
    Objective registerNewObjective(@NotNull String name, @NotNull Criteria criteria, net.kyori.adventure.text.@Nullable Component displayName) throws IllegalArgumentException;
    /**
     * Registers an Objective on this Scoreboard
     *
     * @param name Name of the Objective
     * @param criteria Criteria for the Objective
     * @param displayName Name displayed to players for the Objective.
     * @param renderType Manner of rendering the Objective
     * @return The registered Objective
     * @throws IllegalArgumentException if name is longer than 32767
     *     characters.
     * @throws IllegalArgumentException if an objective by that name already
     *     exists
     */
    @NotNull
    Objective registerNewObjective(@NotNull String name, @NotNull Criteria criteria, net.kyori.adventure.text.@Nullable Component displayName, @NotNull RenderType renderType) throws IllegalArgumentException;

    /**
     * Gets an Objective on this Scoreboard by name
     *
     * @param name Name of the Objective
     * @return the Objective or null if it does not exist
     */
    @Nullable
    Objective getObjective(@NotNull String name);

    /**
     * Gets all Objectives of a Criteria on the Scoreboard
     *
     * @param criteria Criteria to search by
     * @return an immutable set of Objectives using the specified Criteria
     */
    @NotNull
    Set<Objective> getObjectivesByCriteria(@NotNull Criteria criteria);

    /**
     * Gets all Objectives on this Scoreboard
     *
     * @return An immutable set of all Objectives on this Scoreboard
     */
    @NotNull
    Set<Objective> getObjectives();

    /**
     * Gets the Objective currently displayed in a DisplaySlot on this
     * Scoreboard
     *
     * @param slot The DisplaySlot
     * @return the Objective currently displayed or null if nothing is
     *     displayed in that DisplaySlot
     */
    @Nullable
    Objective getObjective(@NotNull DisplaySlot slot);

    /**
     * Gets all scores for a player on this Scoreboard
     *
     * @param player the player whose scores are being retrieved
     * @return immutable set of all scores tracked for the player
     * @see #getScores(String)
     */
    @NotNull
    Set<Score> getScores(@NotNull OfflinePlayer player);

    /**
     * Gets all scores for an entry on this Scoreboard
     *
     * @param entry the entry whose scores are being retrieved
     * @return immutable set of all scores tracked for the entry
     */
    @NotNull
    Set<Score> getScores(@NotNull String entry);

    /**
     * Removes all scores for a player on this Scoreboard
     *
     * @param player the player to drop all current scores for
     * @see #resetScores(String)
     */
    void resetScores(@NotNull OfflinePlayer player);

    /**
     * Removes all scores for an entry on this Scoreboard
     *
     * @param entry the entry to drop all current scores for
     */
    void resetScores(@NotNull String entry);

    /**
     * Gets a player's Team on this Scoreboard
     *
     * @param player the player to search for
     * @return the player's Team or null if the player is not on a team
     * @see #getEntryTeam(String)
     */
    // @Deprecated // Paper
    @Nullable
    Team getPlayerTeam(@NotNull OfflinePlayer player);

    /**
     * Gets a entries Team on this Scoreboard
     *
     * @param entry the entry to search for
     * @return the entries Team or null if the entry is not on a team
     */
    @Nullable
    Team getEntryTeam(@NotNull String entry);

    /**
     * Gets a Team by name on this Scoreboard
     *
     * @param teamName Team name
     * @return the matching Team or null if no matches
     */
    @Nullable
    Team getTeam(@NotNull String teamName);

    /**
     * Gets all teams on this Scoreboard
     *
     * @return an immutable set of Teams
     */
    @NotNull
    Set<Team> getTeams();

    /**
     * Registers a Team on this Scoreboard
     *
     * @param name Team name
     * @return registered Team
     * @throws IllegalArgumentException if team by that name already exists
     */
    @NonNull
    Team registerNewTeam(@NonNull String name);

    /**
     * Gets all entries tracked by this Scoreboard
     *
     * @return immutable set of all tracked entries
     */
    @NotNull
    Set<String> getEntries();

    /**
     * Clears any objective in the specified slot.
     *
     * @param slot the slot to remove objectives
     */
    void clearSlot(@NotNull DisplaySlot slot);

    /**
     * Gets all scores for an entity on this Scoreboard
     *
     * @param entity the entity whose scores are being retrieved
     * @return immutable set of all scores tracked for the entity
     * @throws IllegalArgumentException if entity is null
     * @see #getScores(String)
     */
    @NotNull Set<Score> getScoresFor(@NotNull Entity entity) throws IllegalArgumentException;

    /**
     * Removes all scores for an entity on this Scoreboard
     *
     * @param entity the entity to drop all current scores for
     * @throws IllegalArgumentException if entity is null
     * @see #resetScores(String)
     */
    void resetScoresFor(@NotNull Entity entity) throws IllegalArgumentException;

    /**
     * Gets an entity's Team on this Scoreboard
     *
     * @param entity the entity to search for
     * @return the entity's Team or null if the entity is not on a team
     * @throws IllegalArgumentException if entity is null
     * @see #getEntryTeam(String)
     */
    @Nullable Team getEntityTeam(@NotNull Entity entity) throws IllegalArgumentException;
}

