package io.papermc.paper.api.entity;

/**
 * Represents an entity that can age.
 */
public interface Ageable extends Creature {
    /**
     * Gets the age of this mob.
     *
     * @return Age
     */
    int getAge();

    /**
     * Sets the age of this mob.
     *
     * @param age New age
     */
    void setAge(int age);

    /**
     * Sets the age of the mob to a baby
     */
    void setBaby();

    /**
     * Sets the age of the mob to an adult
     */
    void setAdult();

    /**
     * Returns true if the mob is an adult.
     *
     * @return return true if the mob is an adult
     */
    boolean isAdult();
}

