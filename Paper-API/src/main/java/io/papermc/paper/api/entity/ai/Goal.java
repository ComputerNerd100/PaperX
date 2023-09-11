package io.papermc.paper.api.entity.ai;

import io.papermc.paper.api.entity.Mob;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.EnumSet;

/**
 * Represents an AI goal of an entity
 */
public interface Goal<T extends Mob> {

    /**
     * Checks if this goal should be activated
     *
     * @return if this goal should be activated
     */
    boolean shouldActivate();

    /**
     * Checks if this goal should stay active, defaults to {@link Goal#shouldActivate()}
     *
     * @return if this goal should stay active
     */
    default boolean shouldStayActive() {
        return shouldActivate();
    }

    /**
     * Called when this goal gets activated
     */
    default void start() {
    }

    /**
     * Called when this goal gets stopped
     */
    default void stop() {
    }

    /**
     * Called each tick the goal is activated
     */
    default void tick() {
    }

    /**
     * A unique key that identifies this type of goal. Plugins should use their own namespace, not the minecraft
     * namespace. Additionally, this key also specifies to what mobs this goal can be applied to
     *
     * @return the goal key
     */
    @NonNull
    GoalKey<T> getKey();

    /**
     * Returns a list of all applicable flags for this goal.<br>
     *
     * This method is only called on construction.
     *
     * @return the subtypes.
     */
    @NonNull
    EnumSet<GoalType> getTypes();
}

