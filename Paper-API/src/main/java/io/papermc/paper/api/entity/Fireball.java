package io.papermc.paper.api.entity;

import io.papermc.paper.api.util.vector.Vector;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a Fireball.
 */
public interface Fireball extends Projectile, Explosive {

    /**
     * Fireballs fly straight and do not take setVelocity(...) well.
     *
     * @param direction the direction this fireball is flying toward
     */
    void setDirection(@NonNull Vector direction);

    /**
     * Retrieve the direction this fireball is heading toward
     *
     * @return the direction
     */
    @NonNull
    Vector getDirection();

}

