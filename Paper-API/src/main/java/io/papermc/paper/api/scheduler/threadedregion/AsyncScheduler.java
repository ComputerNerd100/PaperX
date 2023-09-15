package io.papermc.paper.api.scheduler.threadedregion;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Scheduler that may be used by plugins to schedule tasks to execute asynchronously from the server tick process.
 */
public interface AsyncScheduler {

    /**
     * Schedules the specified task to be executed asynchronously immediately.
     * @param plugin Plugin which owns the specified task.
     * @param task Specified task.
     * @return The {@link ScheduledTask} that represents the scheduled task.
     */
    @NonNull ScheduledTask runNow(@NonNull Plugin plugin, @NonNull Consumer<ScheduledTask> task);

    /**
     * Schedules the specified task to be executed asynchronously after the time delay has passed.
     * @param plugin Plugin which owns the specified task.
     * @param task Specified task.
     * @param delay The time delay to pass before the task should be executed.
     * @param unit The time unit for the time delay.
     * @return The {@link ScheduledTask} that represents the scheduled task.
     */
    @NonNull ScheduledTask runDelayed(@NonNull Plugin plugin, @NonNull Consumer<ScheduledTask> task, long delay,
                                      @NonNull TimeUnit unit);

    /**
     * Schedules the specified task to be executed asynchronously after the initial delay has passed,
     * and then periodically executed with the specified period.
     * @param plugin Plugin which owns the specified task.
     * @param task Specified task.
     * @param initialDelay The time delay to pass before the first execution of the task.
     * @param period The time between task executions after the first execution of the task.
     * @param unit The time unit for the initial delay and period.
     * @return The {@link ScheduledTask} that represents the scheduled task.
     */
    @NonNull ScheduledTask runAtFixedRate(@NonNull Plugin plugin, @NonNull Consumer<ScheduledTask> task,
                                          long initialDelay, long period, @NonNull TimeUnit unit);

    /**
     * Attempts to cancel all tasks scheduled by the specified plugin.
     * @param plugin Specified plugin.
     */
    void cancelTasks(@NonNull Plugin plugin);
}

