package io.papermc.paper.api.entity;

import com.google.common.base.Preconditions;
import io.papermc.paper.api.block.color.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

/**
 * Represents a display entity which is designed to only have a visual function.
 */
public interface Display extends Entity {

    /**
     * Gets the transformation applied to this display.
     *
     * @return the transformation
     */
    @NotNull
    Transformation getTransformation();

    /**
     * Sets the transformation applied to this display
     *
     * @param transformation the new transformation
     */
    void setTransformation(@NotNull Transformation transformation);

    /**
     * Sets the raw transformation matrix applied to this display
     *
     * @param transformationMatrix the transformation matrix
     */
    void setTransformationMatrix(@NotNull Matrix4f transformationMatrix);

    /**
     * Gets the interpolation duration of this display.
     *
     * @return interpolation duration
     */
    int getInterpolationDuration();

    /**
     * Sets the interpolation duration of this display.
     *
     * @param duration new duration
     */
    void setInterpolationDuration(int duration);

    /**
     * Gets the view distance/range of this display.
     *
     * @return view range
     */
    float getViewRange();

    /**
     * Sets the view distance/range of this display.
     *
     * @param range new range
     */
    void setViewRange(float range);

    /**
     * Gets the shadow radius of this display.
     *
     * @return radius
     */
    float getShadowRadius();

    /**
     * Sets the shadow radius of this display.
     *
     * @param radius new radius
     */
    void setShadowRadius(float radius);

    /**
     * Gets the shadow strength of this display.
     *
     * @return shadow strength
     */
    float getShadowStrength();

    /**
     * Sets the shadow strength of this display.
     *
     * @param strength new strength
     */
    void setShadowStrength(float strength);

    /**
     * Gets the width of this display.
     *
     * @return width
     */
    float getDisplayWidth();

    /**
     * Sets the width of this display.
     *
     * @param width new width
     */
    void setDisplayWidth(float width);

    /**
     * Gets the height of this display.
     *
     * @return height
     */
    float getDisplayHeight();

    /**
     * Sets the height if this display.
     *
     * @param height new height
     */
    void setDisplayHeight(float height);

    /**
     * Gets the amount of ticks before client-side interpolation will commence.
     *
     * @return interpolation delay ticks
     */
    int getInterpolationDelay();

    /**
     * Sets the amount of ticks before client-side interpolation will commence.
     *
     * @param ticks interpolation delay ticks
     */
    void setInterpolationDelay(int ticks);

    /**
     * Gets the billboard setting of this entity.
     *
     * The billboard setting controls the automatic rotation of the entity to
     * face the player.
     *
     * @return billboard setting
     */
    @NotNull Billboard getBillboard();

    /**
     * Sets the billboard setting of this entity.
     *
     * The billboard setting controls the automatic rotation of the entity to
     * face the player.
     *
     * @param billboard new setting
     */
    void setBillboard(@NotNull Billboard billboard);

    /**
     * Gets the scoreboard team overridden glow color of this display.
     *
     * @return glow color
     */
    @Nullable Color getGlowColorOverride();

    /**
     * Sets the scoreboard team overridden glow color of this display.
     *
     * @param color new color
     */
    void setGlowColorOverride(@Nullable Color color);

    /**
     * Gets the brightness override of the entity.
     *
     * @return brightness override, if set
     */
    @Nullable Brightness getBrightness();

    /**
     * Sets the brightness override of the entity.
     *
     * @param brightness new brightness override
     */
    void setBrightness(@Nullable Brightness brightness);

    /**
     * Describes the axes/points around which the entity can pivot.
     */
    enum Billboard {

        /**
         * No rotation (default).
         */
        FIXED,
        /**
         * Can pivot around vertical axis.
         */
        VERTICAL,
        /**
         * Can pivot around horizontal axis.
         */
        HORIZONTAL,
        /**
         * Can pivot around center point.
         */
        CENTER
    }

    /**
     * Represents the brightness rendering parameters of the entity.
     */
    class Brightness {

        private final int blockLight;
        private final int skyLight;

        public Brightness(int blockLight, int skyLight) {
            Preconditions.checkArgument(0 <= blockLight && blockLight <= 15, "Block brightness out of range: %s", blockLight);
            Preconditions.checkArgument(0 <= skyLight && skyLight <= 15, "Sky brightness out of range: %s", skyLight);

            this.blockLight = blockLight;
            this.skyLight = skyLight;
        }

        /**
         * Gets the block lighting component of this brightness.
         *
         * @return block light, between 0-15
         */
        public int getBlockLight() {
            return this.blockLight;
        }

        /**
         * Gets the sky lighting component of this brightness.
         *
         * @return sky light, between 0-15
         */
        public int getSkyLight() {
            return this.skyLight;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 47 * hash + this.blockLight;
            hash = 47 * hash + this.skyLight;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Brightness other = (Brightness) obj;
            if (this.blockLight != other.blockLight) {
                return false;
            }
            return this.skyLight == other.skyLight;
        }

        @Override
        public String toString() {
            return "Brightness{" + "blockLight=" + this.blockLight + ", skyLight=" + this.skyLight + '}';
        }
    }
}

