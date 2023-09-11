package io.papermc.paper.api.entity;

import org.checkerframework.checker.nullness.qual.NonNull;

public interface Rabbit extends Animals {

    /**
     * @return The type of rabbit.
     */
    @NonNull Type getRabbitType();

    /**
     * @param type Sets the type of rabbit for this entity.
     */
    void setRabbitType(@NonNull Type type);
    /**
     * Sets how many ticks this rabbit will wait
     * until trying to find more carrots.
     *
     * @param ticks ticks
     */
    void setMoreCarrotTicks(int ticks);

    /**
     * Returns how many ticks this rabbit
     * will wait until trying to find more carrots.
     *
     * @return ticks
     */
    int getMoreCarrotTicks();

    /**
     * Represents the various types a Rabbit might be.
     */
    enum Type {

        /**
         * Chocolate colored rabbit.
         */
        BROWN,
        /**
         * Pure white rabbit.
         */
        WHITE,
        /**
         * Black rabbit.
         */
        BLACK,
        /**
         * Black with white patches, or white with black patches?
         */
        BLACK_AND_WHITE,
        /**
         * Golden bunny.
         */
        GOLD,
        /**
         * Salt and pepper colored, whatever that means.
         */
        SALT_AND_PEPPER,
        /**
         * Rabbit with pure white fur, blood red horizontal eyes, and is hostile to players.
         */
        THE_KILLER_BUNNY
    }
}

