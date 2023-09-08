package io.papermc.paper.api.block.sign;


import io.papermc.paper.api.block.color.Colorable;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a side of a sign.
 */
public interface SignSide extends Colorable {

    /**
     * Gets all the lines of text currently on the sign.
     *
     * @return List of components containing each line of text
     */
    @NotNull
    List<Component> lines();

    /**
     * Gets the line of text at the specified index.
     * <p>
     * For example, getLine(0) will return the first line of text.
     *
     * @param index Line number to get the text from, starting at 0
     * @throws IndexOutOfBoundsException Thrown when the line does not exist
     * @return Text on the given line
     */
    @NotNull
    Component line(int index) throws IndexOutOfBoundsException;

    /**
     * Sets the line of text at the specified index.
     * <p>
     * For example, setLine(0, "Line One") will set the first line of text to
     * "Line One".
     *
     * @param index Line number to set the text at, starting from 0
     * @param line New text to set at the specified index
     * @throws IndexOutOfBoundsException If the index is out of the range 0..3
     */
    void line(int index, @NonNull Component line) throws IndexOutOfBoundsException;

    /**
     * Gets whether this side of the sign has glowing text.
     *
     * @return if this side of the sign has glowing text
     */
    boolean isGlowingText();

    /**
     * Sets whether this side of the sign has glowing text.
     *
     * @param glowing if this side of the sign has glowing text
     */
    void setGlowingText(boolean glowing);
}

