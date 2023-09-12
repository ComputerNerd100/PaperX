package io.papermc.paper.api.scoreboard;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.player.OfflinePlayer;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An objective on a scoreboard that can show scores specific to entries. This
 * objective is only relevant to the display of the associated {@link
 * #getScoreboard() scoreboard}.
 */
public interface Objective {

    /**
     * Gets the name of this Objective
     *
     * @return this objective's name
     * @throws IllegalStateException if this objective has been unregistered
     */
    @NonNull
    String getName();

    
    /**
     * Gets the display name for this objective
     *
     * @return this objective's display name
     * @throws IllegalStateException if this objective has been unregistered
     */
    @NonNull Component displayName();
    /**
     * Sets the name displayed to players for this objective.
     *
     * @param displayName Display name to set
     * @throws IllegalStateException if this objective has been unregistered
     * @throws IllegalArgumentException if displayName is null
     * @throws IllegalArgumentException if displayName is longer than 128
     *     characters.
     */
    void displayName(@Nullable Component displayName);
    
    /**
     * Gets the criteria this objective tracks.
     *
     * @return this objective's criteria
     * @throws IllegalStateException if this objective has been unregistered
     */
    @NonNull
    Criteria getTrackedCriteria();

    /**
     * Gets if the objective's scores can be modified directly by a plugin.
     *
     * @return true if scores are modifiable
     * @throws IllegalStateException if this objective has been unregistered
     * @see Criteria#HEALTH
     */
    boolean isModifiable();

    /**
     * Gets the scoreboard to which this objective is attached.
     *
     * @return Owning scoreboard, or null if it has been {@link #unregister()
     *     unregistered}
     */
    @Nullable
    Scoreboard getScoreboard();

    /**
     * Unregisters this objective from the {@link Scoreboard scoreboard.}
     *
     * @throws IllegalStateException if this objective has been unregistered
     */
    void unregister();

    /**
     * Sets this objective to display on the specified slot for the
     * scoreboard, removing it from any other display slot.
     *
     * @param slot display slot to change, or null to not display
     * @throws IllegalStateException if this objective has been unregistered
     */
    void setDisplaySlot(@Nullable DisplaySlot slot);

    /**
     * Gets the display slot this objective is displayed at.
     *
     * @return the display slot for this objective, or null if not displayed
     * @throws IllegalStateException if this objective has been unregistered
     */
    @Nullable
    DisplaySlot getDisplaySlot();

    /**
     * Sets manner in which this objective will be rendered.
     *
     * @param renderType new render type
     * @throws IllegalStateException if this objective has been unregistered
     */
    void setRenderType(@NonNull RenderType renderType);

    /**
     * Sets manner in which this objective will be rendered.
     *
     * @return the render type
     * @throws IllegalStateException if this objective has been unregistered
     */
    @NonNull
    RenderType getRenderType();

    /**
     * Gets a player's Score for an Objective on this Scoreboard
     *
     * @param player Player for the Score
     * @return Score tracking the Objective and player specified
     * @throws IllegalStateException if this objective has been unregistered
     * @see #getScore(String)
     */
    @NonNull
    Score getScore(@NonNull OfflinePlayer player);

    /**
     * Gets an entry's Score for an Objective on this Scoreboard.
     *
     * @param entry Entry for the Score
     * @return Score tracking the Objective and entry specified
     * @throws IllegalStateException if this objective has been unregistered
     * @throws IllegalArgumentException if entry is longer than 32767 characters.
     */
    @NonNull
    Score getScore(@NonNull String entry);
    
    /**
     * Gets an entity's Score for an Objective on this Scoreboard.
     *
     * @param entity Entity for the Score
     * @return Score tracking the Objective and entity specified
     * @throws IllegalArgumentException if entity is null
     * @throws IllegalStateException if this objective has been unregistered
     */
    @NonNull Score getScoreFor(@NonNull Entity entity) throws IllegalArgumentException, IllegalStateException;
}

