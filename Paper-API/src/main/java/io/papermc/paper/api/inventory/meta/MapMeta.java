package io.papermc.paper.api.inventory.meta;

import io.papermc.paper.api.block.color.Color;
import io.papermc.paper.api.map.MapView;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a map that can be scalable.
 */
public interface MapMeta extends ItemMeta {

    /**
     * Checks for existence of a map ID number.
     *
     * @return true if this has a map ID number.
     * @see #hasMapView()
     */
    boolean hasMapId();

    /**
     * Gets the map ID that is set. This is used to determine what map is
     * displayed.
     * <p>
     * Plugins should check that hasMapId() returns <code>true</code> before
     * calling this method.
     *
     * @return the map ID that is set
     * @see #getMapView()
     */
    int getMapId();

    /**
     * Checks for existence of an associated map.
     *
     * @return true if this item has an associated map
     */
    boolean hasMapView();

    /**
     * Gets the map view that is associated with this map item.
     *
     * <p>
     * Plugins should check that hasMapView() returns <code>true</code> before
     * calling this method.
     *
     * @return the map view, or null if the item hasMapView(), but this map does
     * not exist on the server
     */
    @Nullable
    MapView getMapView();

    /**
     * Sets the associated map. This is used to determine what map is displayed.
     *
     * <p>
     * The implementation <b>may</b> allow null to clear the associated map, but
     * this is not required and is liable to generate a new (undefined) map when
     * the item is first used.
     *
     * @param map the map to set
     */
    void setMapView(@Nullable MapView map);

    /**
     * Checks to see if this map is scaling.
     *
     * @return true if this map is scaling
     */
    boolean isScaling();

    /**
     * Sets if this map is scaling or not.
     *
     * @param value true to scale
     */
    void setScaling(boolean value);
    

    /**
     * Checks for existence of a map color.
     *
     * @return true if this has a custom map color
     */
    boolean hasColor();

    /**
     * Gets the map color that is set. A custom map color will alter the display
     * of the map in an inventory slot.
     * <p>
     * Plugins should check that hasColor() returns <code>true</code> before
     * calling this method.
     *
     * @return the map color that is set
     */
    @Nullable
    Color getColor();

    /**
     * Sets the map color. A custom map color will alter the display of the map
     * in an inventory slot.
     *
     * @param color the color to set
     */
    void setColor(@Nullable Color color);

    @Override
    @NonNull
    MapMeta clone();
}
