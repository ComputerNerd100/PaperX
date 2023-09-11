package io.papermc.paper.api.entity;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents an instance of a lightning strike. May or may not do damage.
 */
public interface LightningStrike extends Entity {

    /**
     * Returns whether the strike is an effect that does no damage.
     *
     * @return whether the strike is an effect
     */
    public boolean isEffect();

    /**
     * Returns the amount of flash iterations that will be done before the lightning dies.
     *
     * @see #getLifeTicks() for how long the current flash will last
     * @return amount of flashes that will be shown before the lightning dies
     */
    int getFlashCount();

    /**
     * Sets the amount of life iterations that will be done before the lightning dies.
     * Default number of flashes on creation is between 1-3.
     *
     * @param flashes amount of iterations that will be done before the lightning dies, must to be a positive number
     */
    void setFlashCount(int flashes);

    /**
     * Returns the amount of ticks the current flash will do damage for.
     * Starts with 2 by default, will damage while it is equal to or above 0, with the next flash beginning somewhere between 0 and -9.
     *
     * @return ticks the current flash will do damage for
     */
    int getLifeTicks();

    /**
     * Sets the amount of ticks the current flash will do damage/fire for.
     * Default is 2 for each flash, on which the sound and effect will also be played.
     *
     * @param lifeTicks ticks the current flash will do damage for
     */
    void setLifeTicks(int lifeTicks);

    /**
     * Returns the potential entity that caused this lightning strike to spawn in the world.
     * <p>
     * As of implementing this method, only {@link Player}s are capable of causing a lightning strike, however as this
     * might change in future minecraft releases, this method does not guarantee a player as the cause of a lightning.
     * Consumers of this method should hence validate whether or not the entity is a player if they want to use player
     * specific methods through an {@code instanceOf} check.
     * </p>
     * <p>
     * A player is, as of implementing this method, responsible for a lightning, and will hence be returned here as
     * a cause, if they channeled a {@link Trident} to summon it or were explicitly defined as the cause of this
     * lightning through {@link #setCausingPlayer(Player)}.
     * </p>
     *
     * @return the entity that caused this lightning or null if the lightning was not caused by a entity (e.g. normal
     * weather)
     */
    @Nullable
    Entity getCausingEntity();

    /**
     * Updates the player that caused this lightning to be summoned into the world.
     * By default, players that channel their {@link Trident} will be the cause of the respective lightning.
     * <p>
     * While the respective getter method {@link #getCausingEntity()} does not guarantee a player as the cause of a
     * lightning to stay as future proof as possible, as of implementing this method, players are the only entities
     * that can cause a lightning strike and hence this setter is restricted to players.
     * </p>
     *
     * @param causingPlayer the player that should be the new cause of this lightning. {@code null} may be passed to
     *                      indicate that no player is responsible for this lightning.
     */
    void setCausingPlayer(@Nullable Player causingPlayer);
}
