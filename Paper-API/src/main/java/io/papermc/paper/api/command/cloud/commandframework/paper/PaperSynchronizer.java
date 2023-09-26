package io.papermc.paper.api.command.cloud.commandframework.paper;

import cloud.commandframework.tasks.TaskConsumer;
import cloud.commandframework.tasks.TaskFunction;
import cloud.commandframework.tasks.TaskSynchronizer;
import io.papermc.paper.api.plugin.Plugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.concurrent.CompletableFuture;

public class PaperSynchronizer implements TaskSynchronizer {

    private final Plugin plugin;

    /**
     * Create a new instance of the Bukkit synchronizer
     *
     * @param plugin Owning plugin
     */
    public PaperSynchronizer(final @NonNull Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public <I> CompletableFuture<Void> runSynchronous(final @NonNull I input, final @NonNull TaskConsumer<I> consumer) {
        final CompletableFuture<Void> future = new CompletableFuture<>();
        this.plugin.getServer().getScheduler().runTask(this.plugin, () -> {
            consumer.accept(input);
            future.complete(null);
        });
        return future;
    }

    @Override
    public <I, O> CompletableFuture<O> runSynchronous(final @NonNull I input, final @NonNull TaskFunction<I, O> function) {
        final CompletableFuture<O> future = new CompletableFuture<>();
        this.plugin.getServer().getScheduler().runTask(this.plugin, () -> future.complete(function.apply(input)));
        return future;
    }

    @Override
    public <I> CompletableFuture<Void> runAsynchronous(final @NonNull I input, final @NonNull TaskConsumer<I> consumer) {
        final CompletableFuture<Void> future = new CompletableFuture<>();
        this.plugin.getServer().getScheduler().runTaskAsynchronously(this.plugin, () -> {
            consumer.accept(input);
            future.complete(null);
        });
        return future;
    }

    @Override
    public <I, O> CompletableFuture<O> runAsynchronous(final @NonNull I input, final @NonNull TaskFunction<I, O> function) {
        final CompletableFuture<O> future = new CompletableFuture<>();
        this.plugin.getServer().getScheduler().runTaskAsynchronously(this.plugin, () -> future.complete(function.apply(input)));
        return future;
    }

}
