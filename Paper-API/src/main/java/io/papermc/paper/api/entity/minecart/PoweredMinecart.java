package io.papermc.paper.api.entity.minecart;

import io.papermc.paper.api.entity.Minecart;
import io.papermc.paper.api.material.Material;

/**
 * Represents a powered minecart. A powered minecart moves on its own when a
 * player deposits {@link Material#COAL fuel}.
 */
public interface PoweredMinecart extends Minecart {

    /**
     * Get the number of ticks until the minecart runs out of fuel.
     *
     * @return Number of ticks until the minecart runs out of fuel
     */
    int getFuel();

    /**
     * Set the number of ticks until the minecart runs out of fuel.
     *
     * @param fuel Number of ticks until the minecart runs out of fuel
     */
    void setFuel(int fuel);

    /**
     * Get the x push of the minecart.
     *
     * @return The x push of the minecart
     */
    double getPushX();

    /**
     * Get the z push of the minecart.
     *
     * @return The z push of the minecart
     */
    double getPushZ();

    /**
     * Set the x push of the minecart.
     *
     * @param xPush The new x push of the minecart
     */
    void setPushX(double xPush);

    /**
     * Set the z push of the minecart.
     *
     * @param zPush The new z push of the minecart
     */
    void setPushZ(double zPush);
}

