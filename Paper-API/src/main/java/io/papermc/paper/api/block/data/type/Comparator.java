package io.papermc.paper.api.block.data.type;

import io.papermc.paper.api.block.data.Directional;
import io.papermc.paper.api.block.data.Powerable;
import org.jetbrains.annotations.NotNull;

/**
 * 'mode' indicates what mode this comparator will operate in.
 */
public interface Comparator extends Directional, Powerable {

    /**
     * Gets the value of the 'mode' property.
     *
     * @return the 'mode' value
     */
    @NotNull
    Mode getMode();

    /**
     * Sets the value of the 'mode' property.
     *
     * @param mode the new 'mode' value
     */
    void setMode(@NotNull Mode mode);

    /**
     * The mode in which a comparator will operate in.
     */
    enum Mode {

        /**
         * The default mode, similar to a transistor. The comparator will turn
         * off if either side input is greater than the rear input.
         */
        COMPARE,
        /**
         * Alternate subtraction mode. The output signal strength will be equal
         * to max(rear-max(left,right),0).
         */
        SUBTRACT;
    }
}
