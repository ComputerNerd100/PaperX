package io.papermc.paper.api.command.cloud.commandframework.paper.parser.location;

import cloud.commandframework.arguments.parser.ArgumentParseResult;
import cloud.commandframework.arguments.parser.ArgumentParser;
import cloud.commandframework.arguments.standard.DoubleArgument;
import cloud.commandframework.context.CommandContext;
import cloud.commandframework.exceptions.parsing.NoInputProvidedException;
import io.papermc.paper.api.command.cloud.commandframework.paper.parser.PlayerArgument;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Queue;

/**
 * A single coordinate, meant to be used as an element in a position vector
 *
 * @param <C> Command sender type
 * @since 1.1.0
 */
public final class LocationCoordinateParser<C> implements ArgumentParser<C, LocationCoordinate> {

    @Override
    public @NonNull ArgumentParseResult<@NonNull LocationCoordinate> parse(
            final @NonNull CommandContext<@NonNull C> commandContext,
            final @NonNull Queue<@NonNull String> inputQueue
    ) {
        String input = inputQueue.peek();

        if (input == null) {
            return ArgumentParseResult.failure(new NoInputProvidedException(
                    PlayerArgument.PlayerParser.class,
                    commandContext
            ));
        }

        /* Determine the type */
        final LocationCoordinateType locationCoordinateType;
        if (input.startsWith("^")) {
            locationCoordinateType = LocationCoordinateType.LOCAL;
            input = input.substring(1);
        } else if (input.startsWith("~")) {
            locationCoordinateType = LocationCoordinateType.RELATIVE;
            input = input.substring(1);
        } else {
            locationCoordinateType = LocationCoordinateType.ABSOLUTE;
        }

        final double coordinate;
        try {
            coordinate = input.isEmpty() ? 0 : Double.parseDouble(input);
        } catch (final Exception e) {
            return ArgumentParseResult.failure(new DoubleArgument.DoubleParseException(
                    input,
                    new DoubleArgument.DoubleParser<>(
                            DoubleArgument.DoubleParser.DEFAULT_MINIMUM,
                            DoubleArgument.DoubleParser.DEFAULT_MAXIMUM
                    ),
                    commandContext
            ));
        }

        inputQueue.remove();
        return ArgumentParseResult.success(
                LocationCoordinate.of(
                        locationCoordinateType,
                        coordinate
                )
        );
    }
}

