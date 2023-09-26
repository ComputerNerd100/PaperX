package io.papermc.paper.api.command.cloud.commandframework.paper.parser.location;

/**
 * Type of location coordinates
 *
 * @since 1.1.0
 */
public enum LocationCoordinateType {
    /**
     * Absolute coordinate
     */
    ABSOLUTE,
    /**
     * Coordinate relative to some origin
     */
    RELATIVE,
    /**
     * Coordinates relative to a local coordinate space
     */
    LOCAL
}

