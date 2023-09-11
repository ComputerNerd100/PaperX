package io.papermc.paper.api.entity;

import io.papermc.paper.api.player.OfflinePlayer;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;


/**
 * Represents a {@link Zombie} which was once a {@link Villager}.
 */
public interface ZombieVillager extends Zombie {

    /**
     * Sets the villager profession of this zombie.
     */

    void setVillagerProfession(Villager.@Nullable Profession profession);

    /**
     * Returns the villager profession of this zombie.
     *
     * @return the profession or null
     */

    Villager.@Nullable Profession getVillagerProfession();

    /**
     * Gets the current type of this villager.
     *
     * @return Current type.
     */
    @NotNull Villager.Type getVillagerType();

    /**
     * Sets the new type of this villager.
     *
     * @param type New type.
     */
    void setVillagerType(@NotNull Villager.Type type);

    /**
     * Get if this entity is in the process of converting to a Villager as a
     * result of being cured.
     *
     * @return conversion status
     */
    @Override
    boolean isConverting();

    /**
     * Gets the amount of ticks until this entity will be converted to a
     * Villager as a result of being cured.
     *
     * When this reaches 0, the entity will be converted.
     *
     * @return conversion time
     * @throws IllegalStateException if {@link #isConverting()} is false.
     */
    @Override
    int getConversionTime();

    /**
     * Sets the amount of ticks until this entity will be converted to a
     * Villager as a result of being cured.
     *
     * When this reaches 0, the entity will be converted. A value of less than 0
     * will stop the current conversion process without converting the current
     * entity.
     *
     * @param time new conversion time
     */
    @Override
    void setConversionTime(int time);

    /**
     * Gets the player who initiated the conversion.
     *
     * @return the player, or <code>null</code> if the player is unknown or the
     * entity isn't converting currently
     */
    @Nullable
    OfflinePlayer getConversionPlayer();

    /**
     * Sets the player who initiated the conversion.
     * <p>
     * This has no effect if this entity isn't converting currently.
     *
     * @param conversionPlayer the player
     */
    void setConversionPlayer(@Nullable OfflinePlayer conversionPlayer);

    // Paper start - missing entity behaviour api - converting without entity event
    /**
     * Sets the amount of ticks until this entity will be converted to a
     * Villager as a result of being cured.
     * <p>
     * When this reaches 0, the entity will be converted. A value of less than 0
     * will stop the current conversion process without converting the current
     * entity.
     *
     * @param time new conversion time
     * @param broadcastEntityEvent whether this conversion time mutation should broadcast the
     *                             org.bukkit.{@link EntityEffect#ZOMBIE_TRANSFORM} entity event to the
     *                             world. If false, no entity event is published, preventing for example the
     *                             org.bukkit.{@link org.bukkit.Sound#ENTITY_ZOMBIE_VILLAGER_CURE} from playing.
     */
    void setConversionTime(int time, boolean broadcastEntityEvent);
}

