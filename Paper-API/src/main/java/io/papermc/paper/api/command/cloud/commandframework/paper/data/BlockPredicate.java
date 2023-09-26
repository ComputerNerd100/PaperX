package io.papermc.paper.api.command.cloud.commandframework.paper.data;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.world.World;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.function.Predicate;

/**
 * A {@link Predicate} for {@link Block Blocks} in a {@link World}, parsed from user input.
 *
 * <p>By default, a parsed {@link BlockPredicate} will not load chunks to perform tests. It will simply
 * return {@code false} when attempting to test a block in unloaded chunks.</p>
 *
 * <p>To get a {@link BlockPredicate} which will load chunks, use {@link #loadChunks()}.</p>
 *
 * @since 1.5.0
 */
public interface BlockPredicate extends Predicate<Block> {

    /**
     * Get a version of this {@link BlockPredicate} which will load chunks in order to perform
     * tests.
     *
     * <p>If this {@link BlockPredicate} already loads chunks, it will simply return itself.</p>
     *
     * @return a {@link BlockPredicate} which loads chunks
     * @since 1.5.0
     */
    @NonNull BlockPredicate loadChunks();
}

