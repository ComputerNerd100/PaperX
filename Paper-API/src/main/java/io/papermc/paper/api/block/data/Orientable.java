package io.papermc.paper.api.block.data;

import io.papermc.paper.api.util.Axis;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Set;

/**
 * 'axis' represents the axis along whilst this block is oriented.
 * <br>
 * Some blocks such as the portal block may not be able to be placed in all
 * orientations, use {@link #getAxes()} to retrieve all possible such
 * orientations.
 */
public interface Orientable extends BlockData {

    /**
     * Gets the value of the 'axis' property.
     *
     * @return the 'axis' value
     */
    @NonNull
    Axis getAxis();

    /**
     * Sets the value of the 'axis' property.
     *
     * @param axis the new 'axis' value
     */
    void setAxis(@NonNull Axis axis);

    /**
     * Gets the axes which are applicable to this block.
     *
     * @return the allowed 'axis' values
     */
    @NonNull
    Set<Axis> getAxes();
}
