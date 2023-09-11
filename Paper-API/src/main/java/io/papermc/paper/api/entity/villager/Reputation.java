package io.papermc.paper.api.entity.villager;

import com.google.common.base.Preconditions;
import io.papermc.paper.api.entity.Villager;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.Map;

/**
 * A reputation score for a player on a villager.
 */
public final class Reputation {

    @NotNull
    private final Map<ReputationType, Integer> reputation;

    public Reputation() {
        this(new EnumMap<>(ReputationType.class));
    }

    public Reputation(@NotNull Map<ReputationType, Integer> reputation) {
        Preconditions.checkNotNull(reputation, "reputation cannot be null");
        this.reputation = reputation;
    }

    /**
     * Gets the reputation value for a specific {@link ReputationType}.
     *
     * @param type The {@link ReputationType type} of reputation to get.
     * @return The value of the {@link ReputationType type}.
     */
    public int getReputation(@NotNull ReputationType type) {
        Preconditions.checkNotNull(type, "the reputation type cannot be null");
        return this.reputation.getOrDefault(type, 0);
    }

    /**
     * Sets the reputation value for a specific {@link ReputationType}.
     *
     * @param type The {@link ReputationType type} of reputation to set.
     * @param value The value of the {@link ReputationType type}.
     */
    public void setReputation(@NotNull ReputationType type, int value) {
        Preconditions.checkNotNull(type, "the reputation type cannot be null");
        this.reputation.put(type, value);
    }

    /**
     * Gets if a reputation value is currently set for a specific {@link ReputationType}.
     *
     * @param type The {@link ReputationType type} to check
     * @return If there is a value for this {@link ReputationType type} set.
     */
    public boolean hasReputationSet(@NotNull ReputationType type) {
        return this.reputation.containsKey(type);
    }

    /**
     * A reputation score for a player on a villager.
     */
    /**
     * A type of reputation gained with a {@link Villager Villager}.
     * <p>
     * All types but {@link #MAJOR_POSITIVE} are shared to other villagers.
     */
    public enum ReputationType {
        /**
         * A gossip with a majorly negative effect. This is only gained through killing a nearby
         * villager.
         */
        MAJOR_NEGATIVE,

        /**
         * A gossip with a minor negative effect. This is only gained through damaging a villager.
         */
        MINOR_NEGATIVE,

        /**
         * A gossip with a minor positive effect. This is only gained through curing a zombie
         * villager.
         */
        MINOR_POSITIVE,

        /**
         * A gossip with a major positive effect. This is only gained through curing a zombie
         * villager.
         */
        MAJOR_POSITIVE,

        /**
         * A gossip with a minor positive effect. This is only gained through trading with a villager.
         */
        TRADING,
    }



}
