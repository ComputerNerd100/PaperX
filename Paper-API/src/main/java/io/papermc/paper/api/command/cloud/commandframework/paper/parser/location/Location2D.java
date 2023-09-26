package io.papermc.paper.api.command.cloud.commandframework.paper.parser.location;

import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.world.World;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * {@link Location} projected onto the XZ-plane
 *
 * @since 1.4.0
 */
public class Location2D extends Location {

    protected Location2D(final @Nullable World world, final double x, final double z) {
        super(world, x, 0, z);
    }

    /**
     * Get a new Location2D
     *
     * @param world World this location is in
     * @param x     X position for this location
     * @param z     Z position for this location
     * @return Location2D
     */
    public static @NonNull Location2D from(final @Nullable World world, final double x, final double z) {
        return new Location2D(world, x, z);
    }
}

