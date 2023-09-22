package io.papermc.paper.api.entity;

/**
 * Represents a Strider.
 */
public interface Strider extends Steerable, Vehicle {

    /**
     * Check whether or not this strider is out of warm blocks and shivering.
     *
     * @return true if shivering, false otherwise
     */
    boolean isShivering();

    /**
     * Set whether or not this strider is shivering.
     *
     * Note that the shivering state is updated frequently on the server,
     * therefore this method may not affect the entity for long enough to have a
     * noticeable difference.
     *
     * @param shivering its new shivering state
     */
    void setShivering(boolean shivering);
}

