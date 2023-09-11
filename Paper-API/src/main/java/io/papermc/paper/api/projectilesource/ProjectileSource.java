package io.papermc.paper.api.projectilesource;

import io.papermc.paper.api.util.vector.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

/**
 * Represents a valid source of a projectile.
 */
public interface ProjectileSource {

    /**
     * Launches a {@link Projectile} from the ProjectileSource.
     *
     * @param <T> a projectile subclass
     * @param projectile class of the projectile to launch
     * @return the launched projectile
     */
    @NotNull
    public <T extends Projectile> T launchProjectile(@NotNull Class<? extends T> projectile);

    /**
     * Launches a {@link Projectile} from the ProjectileSource with an
     * initial velocity.
     *
     * @param <T> a projectile subclass
     * @param projectile class of the projectile to launch
     * @param velocity the velocity with which to launch
     * @return the launched projectile
     */
    @NotNull
    public <T extends Projectile> T launchProjectile(@NotNull Class<? extends T> projectile, @Nullable Vector velocity);

    // Paper start
    /**
     * Launches a {@link Projectile} from the ProjectileSource with an
     * initial velocity, with the supplied function run before the
     * entity is added to the world.
     * <br>
     * Note that when the function is run, the entity will not be actually in
     * the world. Any operation involving such as teleporting the entity is undefined
     * until after this function returns.
     *
     * @param <T> a projectile subclass
     * @param projectile class of the projectile to launch
     * @param velocity the velocity with which to launch
     * @param function the function to be run before the entity is spawned
     * @return the launched projectile
     */
    @NotNull
    public <T extends Projectile> T launchProjectile(@NotNull Class<? extends T> projectile, @Nullable Vector velocity, @Nullable Consumer<T> function);
    // Paper end
}

