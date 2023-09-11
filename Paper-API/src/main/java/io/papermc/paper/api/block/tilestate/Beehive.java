package io.papermc.paper.api.block.tilestate;

import io.papermc.paper.api.entity.Bee;
import io.papermc.paper.api.location.Location;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a captured state of a bee hive.
 */
public interface Beehive extends EntityBlockStorage<Bee> {

    /**
     * Get the hive's flower location.
     *
     * @return flower location or null
     */
    @Nullable
    Location getFlower();

    /**
     * Set the hive's flower location.
     *
     * @param location or null
     */
    void setFlower(@Nullable Location location);

    /**
     * Check if the hive is sedated due to smoke from a nearby campfire.
     *
     * @return True if hive is sedated
     */
    boolean isSedated();
}
