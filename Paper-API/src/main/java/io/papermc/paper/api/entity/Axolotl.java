package io.papermc.paper.api.entity;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * An Axolotl.
 */
public interface Axolotl extends Animals, Bucketable {

    /**
     * Gets if this axolotl is playing dead.
     *
     * An axolotl may play dead when it is damaged underwater.
     *
     * @return playing dead status
     */
    boolean isPlayingDead();

    /**
     * Sets if this axolotl is playing dead.
     *
     * An axolotl may play dead when it is damaged underwater.
     *
     * @param playingDead playing dead status
     */
    void setPlayingDead(boolean playingDead);

    /**
     * Get the variant of this axolotl.
     *
     * @return axolotl variant
     */
    @NonNull
    Variant getVariant();

    /**
     * Set the variant of this axolotl.
     *
     * @param variant axolotl variant
     */
    void setVariant(@NonNull Variant variant);

    /**
     * Represents the variant of a axolotl - ie its color.
     */
    enum Variant {

        /**
         * Leucistic (pink) axolotl.
         */
        LUCY,
        /**
         * Brown axolotl.
         */
        WILD,
        /**
         * Gold axolotl.
         */
        GOLD,
        /**
         * Cyan axolotl.
         */
        CYAN,
        /**
         * Blue axolotl.
         */
        BLUE
    }
}
