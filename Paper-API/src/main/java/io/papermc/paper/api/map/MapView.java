package io.papermc.paper.api.map;

import io.papermc.paper.api.world.World;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

/**
 * Represents a map item.
 */
public interface MapView {

    /**
     * An enum representing all possible scales a map can be set to.
     */
    enum Scale {
        CLOSEST(0),
        CLOSE(1),
        NORMAL(2),
        FAR(3),
        FARTHEST(4);

        private final byte value;

        Scale(int value) {
            this.value = (byte) value;
        }

        /**
         * Get the scale given the raw value.
         *
         * @param value The raw scale
         * @return The enum scale, or null for an invalid input
         * @deprecated Magic value
         */
        @Deprecated
        @Nullable
        public static Scale valueOf(byte value) {
            switch (value) {
                case 0: return CLOSEST;
                case 1: return CLOSE;
                case 2: return NORMAL;
                case 3: return FAR;
                case 4: return FARTHEST;
                default: return null;
            }
        }

        /**
         * Get the raw value of this scale level.
         *
         * @return The scale value
         * @deprecated Magic value
         */
        @Deprecated
        public byte getValue() {
            return value;
        }
    }

    /**
     * Get the ID of this map item for use with {@link MapMeta}.
     *
     * @return The ID of the map.
     */
    int getId();

    /**
     * Check whether this map is virtual. A map is virtual if its lowermost
     * MapRenderer is plugin-provided.
     *
     * @return Whether the map is virtual.
     */
    boolean isVirtual();

    /**
     * Get the scale of this map.
     *
     * @return The scale of the map.
     */
    @NonNull Scale getScale();

    /**
     * Set the scale of this map.
     *
     * @param scale The scale to set.
     */
    void setScale(@NonNull Scale scale);

    /**
     * Get the center X position of this map.
     *
     * @return The center X position.
     */
    int getCenterX();

    /**
     * Get the center Z position of this map.
     *
     * @return The center Z position.
     */
    int getCenterZ();

    /**
     * Set the center X position of this map.
     *
     * @param x The center X position.
     */
    void setCenterX(int x);

    /**
     * Set the center Z position of this map.
     *
     * @param z The center Z position.
     */
    void setCenterZ(int z);

    /**
     * Get the world that this map is associated with. Primarily used by the
     * internal renderer, but may be used by external renderers. May return
     * null if the world the map is associated with is not loaded.
     *
     * @return The World this map is associated with.
     */
    @Nullable World getWorld();

    /**
     * Set the world that this map is associated with. The world is used by
     * the internal renderer, and may also be used by external renderers.
     *
     * @param world The World to associate this map with.
     */
    void setWorld(@NonNull World world);

    /**
     * Get a list of MapRenderers currently in effect.
     *
     * @return A {@code List<MapRenderer>} containing each map renderer.
     */
    @NonNull List<MapRenderer> getRenderers();

    /**
     * Add a renderer to this map.
     *
     * @param renderer The MapRenderer to add.
     */
    void addRenderer(@NonNull MapRenderer renderer);

    /**
     * Remove a renderer from this map.
     *
     * @param renderer The MapRenderer to remove.
     * @return True if the renderer was successfully removed.
     */
    boolean removeRenderer(@Nullable MapRenderer renderer);

    /**
     * Gets whether a position cursor should be shown when the map is near its
     * center.
     *
     * @return tracking status
     */
    boolean isTrackingPosition();

    /**
     * Sets whether a position cursor should be shown when the map is near its
     * center.
     *
     * @param trackingPosition tracking status
     */
    void setTrackingPosition(boolean trackingPosition);

    /**
     * Whether the map will show a smaller position cursor (true), or no
     * position cursor (false) when cursor is outside of map's range.
     *
     * @return unlimited tracking state
     */
    boolean isUnlimitedTracking();

    /**
     * Whether the map will show a smaller position cursor (true), or no
     * position cursor (false) when cursor is outside of map's range.
     *
     * @param unlimited tracking state
     */
    void setUnlimitedTracking(boolean unlimited);

    /**
     * Gets whether the map is locked or not.
     *
     * A locked map may not be explored further.
     *
     * @return lock status
     */
    boolean isLocked();

    /**
     * Gets whether the map is locked or not.
     *
     * A locked map may not be explored further.
     *
     * @param locked status
     */
    void setLocked(boolean locked);
}
