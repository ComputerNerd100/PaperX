package io.papermc.paper.api.util;

import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.location.Location;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a vibration from a Skulk sensor.
 */
public class Vibration {

    private final Location origin;
    private final Destination destination;
    private final int arrivalTime;

    public Vibration(@NonNull Destination destination, @NonNull int arrivalTime) {
        this.destination = destination;
        this.arrivalTime = arrivalTime;
        this.origin = new Location(null, 0, 0, 0); // Dummy origin because getter expects null
    }

    /**
     * Get the vibration destination.
     *
     * @return destination
     */
    @NonNull
    public Destination getDestination() {
        return destination;
    }

    /**
     * Get the vibration arrival time in ticks.
     *
     * @return arrival time
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    public interface Destination {

        public static class EntityDestination implements Destination {

            private final Entity entity;

            public EntityDestination(@NonNull Entity entity) {
                this.entity = entity;
            }

            @NonNull
            public Entity getEntity() {
                return entity;
            }
        }

        public static class BlockDestination implements Destination {

            private final Location block;

            public BlockDestination(@NonNull Location block) {
                this.block = block;
            }

            public BlockDestination(@NonNull Block block) {
                this(block.getLocation());
            }

            @NonNull
            public Location getLocation() {
                return block;
            }

            @NonNull
            public Block getBlock() {
                return block.getBlock();
            }
        }
    }
}

