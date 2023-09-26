package io.papermc.paper.api.command.cloud.commandframework.paper.parser.location;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

/**
 * Single coordinate with a type
 *
 * @since 1.1.0
 */
public final class LocationCoordinate {

    private final LocationCoordinateType type;
    private final double coordinate;

    private LocationCoordinate(
            final @NonNull LocationCoordinateType type,
            final double coordinate
    ) {
        this.type = type;
        this.coordinate = coordinate;
    }

    /**
     * Create a new location coordinate
     *
     * @param type       Coordinate type
     * @param coordinate Coordinate
     * @return Created coordinate instance
     */
    public static @NonNull LocationCoordinate of(
            final @NonNull LocationCoordinateType type,
            final double coordinate
    ) {
        return new LocationCoordinate(type, coordinate);
    }

    /**
     * Get the coordinate type
     *
     * @return Coordinate type
     */
    public @NonNull LocationCoordinateType getType() {
        return this.type;
    }

    /**
     * Get the coordinate
     *
     * @return Coordinate
     */
    public double getCoordinate() {
        return this.coordinate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LocationCoordinate that = (LocationCoordinate) o;
        return Double.compare(that.coordinate, this.coordinate) == 0
                && this.type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.coordinate);
    }

    @Override
    public String toString() {
        return String.format("LocationCoordinate{type=%s, coordinate=%f}", this.type.name().toLowerCase(), this.coordinate);
    }
}

