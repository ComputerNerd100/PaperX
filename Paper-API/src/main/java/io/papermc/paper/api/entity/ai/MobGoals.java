package io.papermc.paper.api.entity.ai;

import io.papermc.paper.api.entity.Mob;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;

/**
 * Represents a part of the "brain" of a mob. It tracks all tasks (running or not), allows adding and removing goals
 */
public interface MobGoals {

    <T extends Mob> void addGoal(@NonNull T mob, int priority, @NonNull Goal<T> goal);

    <T extends Mob> void removeGoal(@NonNull T mob, @NonNull Goal<T> goal);

    <T extends Mob> void removeAllGoals(@NonNull T mob);

    <T extends Mob> void removeAllGoals(@NonNull T mob, @NonNull GoalType type);

    <T extends Mob> void removeGoal(@NonNull T mob, @NonNull GoalKey<T> key);

    <T extends Mob> boolean hasGoal(@NonNull T mob, @NonNull GoalKey<T> key);

    @Nullable
    <T extends Mob> Goal<T> getGoal(@NonNull T mob, @NonNull GoalKey<T> key);

    @NonNull
    <T extends Mob> Collection<Goal<T>> getGoals(@NonNull T mob, @NonNull GoalKey<T> key);

    @NonNull
    <T extends Mob> Collection<Goal<T>> getAllGoals(@NonNull T mob);

    @NonNull
    <T extends Mob> Collection<Goal<T>> getAllGoals(@NonNull T mob, @NonNull GoalType type);

    @NonNull
    <T extends Mob> Collection<Goal<T>> getAllGoalsWithout(@NonNull T mob, @NonNull GoalType type);

    @NonNull
    <T extends Mob> Collection<Goal<T>> getRunningGoals(@NonNull T mob);

    @NonNull
    <T extends Mob> Collection<Goal<T>> getRunningGoals(@NonNull T mob, @NonNull GoalType type);

    @NonNull
    <T extends Mob> Collection<Goal<T>> getRunningGoalsWithout(@NonNull T mob, @NonNull GoalType type);
}

