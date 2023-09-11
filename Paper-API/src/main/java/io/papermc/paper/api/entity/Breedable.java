package io.papermc.paper.api.entity;

/**
 * Represents an entity that can age and breed.
 */
public interface Breedable extends Ageable {

    /**
     * Lock the age of the animal, setting this will prevent the animal from
     * maturing or getting ready for mating.
     *
     * @param lock new lock
     */
    void setAgeLock(boolean lock);

    /**
     * Gets the current agelock.
     *
     * @return the current agelock
     */
    boolean getAgeLock();

    /**
     * Return the ability to breed of the animal.
     *
     * @return the ability to breed of the animal
     */
    boolean canBreed();

    /**
     * Set breedability of the animal, if the animal is a baby and set to
     * breed it will instantly grow up.
     *
     * @param breed breedability of the animal
     */
    void setBreed(boolean breed);

}

