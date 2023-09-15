package io.papermc.paper.api.entity;

import io.papermc.paper.api.util.Art;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a Painting.
 */
public interface Painting extends Hanging {

    /**
     * Get the art on this painting
     *
     * @return The art
     */
    @NonNull
    public Art getArt();

    /**
     * Set the art on this painting
     *
     * @param art The new art
     * @return False if the new art won't fit at the painting's current
     *     location
     */
    public boolean setArt(@NonNull Art art);

    /**
     * Set the art on this painting
     *
     * @param art The new art
     * @param force If true, force the new art regardless of whether it fits
     *     at the current location. Note that forcing it where it can't fit
     *     normally causes it to drop as an item unless you override this by
     *     catching the {@link HangingBreakEvent}.
     * @return False if force was false and the new art won't fit at the
     *     painting's current location
     */
    public boolean setArt(@NonNull Art art, boolean force);
}

