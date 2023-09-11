package io.papermc.paper.api.entity;

import io.papermc.paper.api.player.OfflinePlayer;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;


/**
 * Represents an entity designed to only record interactions.
 */
public interface Interaction extends Entity {

    /**
     * Gets the width of this interaction entity.
     *
     * @return width
     */
    float getInteractionWidth();

    /**
     * Sets the width of this interaction entity.
     *
     * @param width new width
     */
    void setInteractionWidth(float width);

    /**
     * Gets the height of this interaction entity.
     *
     * @return height
     */
    float getInteractionHeight();

    /**
     * Sets the height of this interaction entity.
     *
     * @param height new height
     */
    void setInteractionHeight(float height);

    /**
     * Gets if this interaction entity should trigger a response when interacted
     * with.
     *
     * @return response setting
     */
    boolean isResponsive();

    /**
     * Sets if this interaction entity should trigger a response when interacted
     * with.
     *
     * @param response new setting
     */
    void setResponsive(boolean response);

    /**
     * Gets the last attack on this interaction entity.
     *
     * @return last attack data, if present
     */
    @Nullable PreviousInteraction getLastAttack();

    /**
     * Gets the last interaction on this entity.
     *
     * @return last interaction data, if present
     */
    @Nullable PreviousInteraction getLastInteraction();

    /**
     * Represents a previous interaction with this entity.
     */
    interface PreviousInteraction {

        /**
         * Get the previous interacting player.
         *
         * @return interacting player
         */
        @NonNull OfflinePlayer getPlayer();

        /**
         * Gets the Unix timestamp at when this interaction occurred.
         *
         * @return interaction timestamp
         */
        long getTimestamp();
    }
}
