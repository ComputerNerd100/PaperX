package io.papermc.paper.api.block.tilestate;


import io.papermc.paper.api.math.Position;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a captured state of a sculk catalyst.
 */
public interface SculkCatalyst extends TileState {

    /**
     * Bloom at the specified location as if an entity that drops experience just died there.
     *
     * @param position position to bloom at
     * @param charge charge to bloom with, normally the amount of experience dropped from the dead entity
     */
    void bloom(@NonNull Position position, int charge);
}

