package io.papermc.paper.api.entity;


import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.world.World;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a Primed TNT.
 */
public interface TNTPrimed extends Explosive {

    /**
     * Set the number of ticks until the TNT blows up after being primed.
     *
     * @param fuseTicks The fuse ticks
     */
    void setFuseTicks(int fuseTicks);

    /**
     * Retrieve the number of ticks until the explosion of this TNTPrimed
     * entity
     *
     * @return the number of ticks until this TNTPrimed explodes
     */
    int getFuseTicks();

    /**
     * Gets the source of this primed TNT. The source is the entity
     * responsible for the creation of this primed TNT. (I.E. player ignites
     * TNT with flint and steel.) Take note that this can be null if there is
     * no suitable source. (created by the {@link
     * World#spawn(Location, Class)} method, for example.)
     * <p>
     * The source will become null if the chunk this primed TNT is in is
     * unloaded then reloaded. The source entity may be invalid if for example
     * it has since died or been unloaded. Callers should check
     * {@link Entity#isValid()}.
     *
     * @return the source of this primed TNT
     */
    @Nullable Entity getSource();

    /**
     * Sets the source of this primed TNT.
     *
     * The source is the entity responsible for the creation of this primed TNT.
     * <p>
     * Must be instance of {@link LivingEntity} otherwise will
     * be set to null. The parameter is typed {@link
     * Entity} to be consistent with {@link
     * TNTPrimed#getSource()} method.
     *
     * @param source the source of this primed TNT
     */
    void setSource(@Nullable Entity source);
}
