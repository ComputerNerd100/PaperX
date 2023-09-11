package io.papermc.paper.api.entity;

import io.papermc.paper.api.projectilesource.ProjectileSource;
import io.papermc.paper.api.util.vector.Vector;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;


import java.util.UUID;

/**
 * Represents a shootable entity.
 */
public interface Projectile extends Entity {

    /**
     * Retrieve the shooter of this projectile.
     *
     * @return the {@link ProjectileSource} that shot this projectile
     * @see #getOwnerUniqueId()
     */
    @Nullable ProjectileSource getShooter();

    /**
     * Set the shooter of this projectile.
     *
     * @param source the {@link ProjectileSource} that shot this projectile
     */
    void setShooter(@Nullable ProjectileSource source);

    /**
     * Gets whether the projectile has left the
     * hitbox of their shooter and can now hit entities.
     *
     * @return has left shooter's hitbox
     */
    boolean hasLeftShooter();

    /**
     * Sets whether the projectile has left the
     * hitbox of their shooter and can now hit entities.
     *
     * This is recalculated each tick if the projectile has a shooter.
     *
     * @param leftShooter has left shooter's hitbox
     */
    void setHasLeftShooter(boolean leftShooter);

    /**
     * Gets whether the projectile has been
     * shot into the world and has sent a projectile
     * shot game event.
     *
     * @return has been shot into the world
     */
    boolean hasBeenShot();

    /**
     * Sets whether the projectile has been
     * shot into the world and has sent a projectile
     * shot game event in the next tick.
     *
     * Setting this to false will cause a game event
     * to fire and the value to be set back to true.
     *
     * @param beenShot has been in shot into the world
     */
    void setHasBeenShot(boolean beenShot);

    /**
     * Gets whether this projectile can hit an entity.
     * <p>
     * This method returns true under the following conditions:
     * <p>
     * - The shooter can see the entity ({@link Player#canSee(Entity)}) <p>
     * - The entity is alive and not a spectator <p>
     * - The projectile has left the hitbox of the shooter ({@link #hasLeftShooter()})<p>
     * - If this is an arrow with piercing, it has not pierced the entity already
     *
     * @param entity the entity to check if this projectile can hit
     * @return true if this projectile can damage the entity, false otherwise
     */
    boolean canHitEntity(@org.jetbrains.annotations.NotNull Entity entity);

    /**
     * Makes this projectile hit a specific entity.
     * This uses the current position of the projectile for the hit point.
     * Using this method will result in {@link org.bukkit.event.entity.ProjectileHitEvent} being called.
     * @param entity the entity to hit
     * @see #hitEntity(Entity, Vector)
     * @see #canHitEntity(Entity)
     */
    void hitEntity(@org.jetbrains.annotations.NotNull Entity entity);

    /**
     * Makes this projectile hit a specific entity from a specific point.
     * Using this method will result in {@link org.bukkit.event.entity.ProjectileHitEvent} being called.
     * @param entity the entity to hit
     * @param vector the direction to hit from
     * @see #hitEntity(Entity)
     * @see #canHitEntity(Entity)
     */
    void hitEntity(@NonNull Entity entity, @NonNull Vector vector);

    /**
     * Gets the owner's UUID
     *
     * @return the owner's UUID, or null if not owned
     * @see #getShooter()
     */
    @Nullable
    UUID getOwnerUniqueId();
}

