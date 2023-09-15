package io.papermc.paper.api.scoreboard;

import com.google.common.base.Preconditions;
import io.papermc.paper.api.Paper;
import io.papermc.paper.api.entity.EntityType;
import io.papermc.paper.api.material.Material;
import io.papermc.paper.api.util.Statistic;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a scoreboard criteria, either custom or built-in to the Minecraft server, used to
 * keep track of and manually or automatically change scores on a scoreboard.
 * <p>
 * While this class outlines constants for standard criteria, see {@link #statistic(Statistic)}
 * (and its overloads) to create instances for statistically-backed criteria.
 */
public interface Criteria {

    /**
     * The dummy criteria. Not changed by the server.
     */
    Criteria DUMMY = Paper.getScoreboardCriteria("dummy");
    /**
     * The trigger criteria. Changed when a player runs the /trigger command for an objective.
     */
    Criteria TRIGGER = Paper.getScoreboardCriteria("trigger");
    /**
     * Increments automatically when a player dies.
     */
    Criteria DEATH_COUNT = Paper.getScoreboardCriteria("deathCount");
    /**
     * Increments automatically when a player kills another player.
     */
    Criteria PLAYER_KILL_COUNT = Paper.getScoreboardCriteria("playerKillCount");
    /**
     * Increments automatically when a player kills another living entity.
     */
    Criteria TOTAL_KILL_COUNT = Paper.getScoreboardCriteria("totalKillCount");
    /**
     * Mirrors the player's health points (0 for no health, 20 for maximum default health).
     */
    Criteria HEALTH = Paper.getScoreboardCriteria("health");
    /**
     * Mirrors the player's food points (0 for no food, 20 for maximum food).
     */
    Criteria FOOD = Paper.getScoreboardCriteria("food");
    /**
     * Mirrors the player's air supply (0 for no air, 300 for maximum air).
     */
    Criteria AIR = Paper.getScoreboardCriteria("air");
    /**
     * Mirrors the player's armor points (0 for no armor, 20 for maximum armor).
     */
    Criteria ARMOR = Paper.getScoreboardCriteria("armor");
    /**
     * Mirrors the player's experience points.
     */
    Criteria XP = Paper.getScoreboardCriteria("xp");
    /**
     * Mirrors the player's experience level.
     */
    Criteria LEVEL = Paper.getScoreboardCriteria("level");

    /**
     * Increments automatically when a player kills another player on the black team.
     */
    Criteria TEAM_KILL_BLACK = Paper.getScoreboardCriteria("teamkill.black");
    /**
     * Increments automatically when a player kills another player on the dark blue team.
     */
    Criteria TEAM_KILL_DARK_BLUE = Paper.getScoreboardCriteria("teamkill.dark_blue");
    /**
     * Increments automatically when a player kills another player on the dark green team.
     */
    Criteria TEAM_KILL_DARK_GREEN = Paper.getScoreboardCriteria("teamkill.dark_green");
    /**
     * Increments automatically when a player kills another player on the dark aqua team.
     */
    Criteria TEAM_KILL_DARK_AQUA = Paper.getScoreboardCriteria("teamkill.dark_aqua");
    /**
     * Increments automatically when a player kills another player on the dark red team.
     */
    Criteria TEAM_KILL_DARK_RED = Paper.getScoreboardCriteria("teamkill.dark_red");
    /**
     * Increments automatically when a player kills another player on the dark purple team.
     */
    Criteria TEAM_KILL_DARK_PURPLE = Paper.getScoreboardCriteria("teamkill.dark_purple");
    /**
     * Increments automatically when a player kills another player on the gold team.
     */
    Criteria TEAM_KILL_GOLD = Paper.getScoreboardCriteria("teamkill.gold");
    /**
     * Increments automatically when a player kills another player on the gray team.
     */
    Criteria TEAM_KILL_GRAY = Paper.getScoreboardCriteria("teamkill.gray");
    /**
     * Increments automatically when a player kills another player on the dark gray team.
     */
    Criteria TEAM_KILL_DARK_GRAY = Paper.getScoreboardCriteria("teamkill.dark_gray");
    /**
     * Increments automatically when a player kills another player on the blue team.
     */
    Criteria TEAM_KILL_BLUE = Paper.getScoreboardCriteria("teamkill.blue");
    /**
     * Increments automatically when a player kills another player on the green team.
     */
    Criteria TEAM_KILL_GREEN = Paper.getScoreboardCriteria("teamkill.green");
    /**
     * Increments automatically when a player kills another player on the aqua team.
     */
    Criteria TEAM_KILL_AQUA = Paper.getScoreboardCriteria("teamkill.aqua");
    /**
     * Increments automatically when a player kills another player on the red team.
     */
    Criteria TEAM_KILL_RED = Paper.getScoreboardCriteria("teamkill.red");
    /**
     * Increments automatically when a player kills another player on the light purple team.
     */
    Criteria TEAM_KILL_LIGHT_PURPLE = Paper.getScoreboardCriteria("teamkill.light_purple");
    /**
     * Increments automatically when a player kills another player on the yellow team.
     */
    Criteria TEAM_KILL_YELLOW = Paper.getScoreboardCriteria("teamkill.yellow");
    /**
     * Increments automatically when a player kills another player on the white team.
     */
    Criteria TEAM_KILL_WHITE = Paper.getScoreboardCriteria("teamkill.white");

    /**
     * Increments automatically when a player is killed by a player on the black team.
     */
    Criteria KILLED_BY_TEAM_BLACK = Paper.getScoreboardCriteria("killedByTeam.black");
    /**
     * Increments automatically when a player is killed by a player on the dark blue team.
     */
    Criteria KILLED_BY_TEAM_DARK_BLUE = Paper.getScoreboardCriteria("killedByTeam.dark_blue");
    /**
     * Increments automatically when a player is killed by a player on the dark green team.
     */
    Criteria KILLED_BY_TEAM_DARK_GREEN = Paper.getScoreboardCriteria("killedByTeam.dark_green");
    /**
     * Increments automatically when a player is killed by a player on the dark aqua team.
     */
    Criteria KILLED_BY_TEAM_DARK_AQUA = Paper.getScoreboardCriteria("killedByTeam.dark_aqua");
    /**
     * Increments automatically when a player is killed by a player on the dark red team.
     */
    Criteria KILLED_BY_TEAM_DARK_RED = Paper.getScoreboardCriteria("killedByTeam.dark_red");
    /**
     * Increments automatically when a player is killed by a player on the dark purple team.
     */
    Criteria KILLED_BY_TEAM_DARK_PURPLE = Paper.getScoreboardCriteria("killedByTeam.dark_purple");
    /**
     * Increments automatically when a player is killed by a player on the gold team.
     */
    Criteria KILLED_BY_TEAM_GOLD = Paper.getScoreboardCriteria("killedByTeam.gold");
    /**
     * Increments automatically when a player is killed by a player on the gray team.
     */
    Criteria KILLED_BY_TEAM_GRAY = Paper.getScoreboardCriteria("killedByTeam.gray");
    /**
     * Increments automatically when a player is killed by a player on the dark gray team.
     */
    Criteria KILLED_BY_TEAM_DARK_GRAY = Paper.getScoreboardCriteria("killedByTeam.dark_gray");
    /**
     * Increments automatically when a player is killed by a player on the blue team.
     */
    Criteria KILLED_BY_TEAM_BLUE = Paper.getScoreboardCriteria("killedByTeam.blue");
    /**
     * Increments automatically when a player is killed by a player on the green team.
     */
    Criteria KILLED_BY_TEAM_GREEN = Paper.getScoreboardCriteria("killedByTeam.green");
    /**
     * Increments automatically when a player is killed by a player on the aqua team.
     */
    Criteria KILLED_BY_TEAM_AQUA = Paper.getScoreboardCriteria("killedByTeam.aqua");
    /**
     * Increments automatically when a player is killed by a player on the red team.
     */
    Criteria KILLED_BY_TEAM_RED = Paper.getScoreboardCriteria("killedByTeam.red");
    /**
     * Increments automatically when a player is killed by a player on the light purple team.
     */
    Criteria KILLED_BY_TEAM_LIGHT_PURPLE = Paper.getScoreboardCriteria("killedByTeam.light_purple");
    /**
     * Increments automatically when a player is killed by a player on the yellow team.
     */
    Criteria KILLED_BY_TEAM_YELLOW = Paper.getScoreboardCriteria("killedByTeam.yellow");
    /**
     * Increments automatically when a player is killed by a player on the white team.
     */
    Criteria KILLED_BY_TEAM_WHITE = Paper.getScoreboardCriteria("killedByTeam.white");

    /**
     * Get the name of this criteria (its unique id).
     *
     * @return the name
     */
    @NonNull String getName();

    /**
     * Get whether or not this criteria is read only. If read only, scoreboards with this criteria
     * cannot have their scores changed.
     *
     * @return true if read only, false otherwise
     */
    boolean isReadOnly();

    /**
     * Get the {@link RenderType} used by default for this criteria.
     *
     * @return the default render type
     */
    @NonNull RenderType getDefaultRenderType();

    /**
     * Get a {@link Criteria} for the specified statistic pertaining to blocks or items.
     * <p>
     * This method expects a {@link Statistic} of {@link Statistic.Type#BLOCK} or {@link Statistic.Type#ITEM} and the
     * {@link Material} matching said type (e.g. BLOCK statistics require materials where
     * {@link Material#isBlock()} is true). This acts as a convenience to create more complex
     * compound criteria such as those that increment on block breaks, or item uses. An example
     * would be {@code Criteria.statistic(Statistic.CRAFT_ITEM, Material.STICK)}, returning a
     * Criteria representing "minecraft.crafted:minecraft.stick" which will increment when the
     * player crafts a stick.
     * <p>
     * If the provided statistic does not require additional data, {@link #statistic(Statistic)}
     * is called and returned instead.
     * <p>
     * This method provides no guarantee that any given criteria exists on the vanilla server.
     *
     * @param statistic the statistic for which to get a criteria
     * @param material the relevant material
     * @return the criteria
     * @throws IllegalArgumentException if {@link Statistic#getType()} is anything other than
     * {@link Statistic.Type#BLOCK} or {@link Statistic.Type#ITEM}
     * @throws IllegalArgumentException if {@link Statistic#getType()} is {@link Statistic.Type#BLOCK}, but
     * {@link Material#isBlock()} is false
     * @throws IllegalArgumentException if {@link Statistic#getType()} is {@link Statistic.Type#ITEM}, but
     * {@link Material#isItem()} is false
     */
    @NonNull
    static Criteria statistic(@NonNull Statistic statistic, @NonNull Material material) {
        Preconditions.checkArgument(statistic != null, "statistic must not be null");
        Preconditions.checkArgument(material != null, "material must not be null");

        Statistic.Type type = statistic.getType();
        Preconditions.checkArgument(type == Statistic.Type.BLOCK || type == Statistic.Type.ITEM, "statistic type must be either BLOCK or ITEM, given %s", type);
        Preconditions.checkArgument(type != Statistic.Type.BLOCK || material.isBlock(), "statistic type is BLOCK but got non-block Material, %s", material);
        Preconditions.checkArgument(type != Statistic.Type.ITEM || material.isItem(), "statistic type is ITEM but got non-item Material, %s", material);

        // Good use case for a switch expression
        if (type == Statistic.Type.BLOCK) {
            if (statistic == Statistic.MINE_BLOCK) {
                return Paper.getScoreboardCriteria("minecraft.mined:minecraft." + material.getKey().getKey());
            }
        } else if (type == Statistic.Type.ITEM) {
            switch (statistic) {
                case BREAK_ITEM:
                    return Paper.getScoreboardCriteria("minecraft.broken:minecraft." + material.getKey().getKey());
                case CRAFT_ITEM:
                    return Paper.getScoreboardCriteria("minecraft.crafted:minecraft." + material.getKey().getKey());
                case USE_ITEM:
                    return Paper.getScoreboardCriteria("minecraft.used:minecraft." + material.getKey().getKey());
                case PICKUP:
                    return Paper.getScoreboardCriteria("minecraft.picked_up:minecraft." + material.getKey().getKey());
                case DROP:
                    return Paper.getScoreboardCriteria("minecraft.dropped:minecraft." + material.getKey().getKey());
                default:
                    break;
            }
        }

        return statistic(statistic); // Fallback to a regular statistic
    }

    /**
     * Get a {@link Criteria} for the specified statistic pertaining to an entity type.
     * <p>
     * This method expects a {@link Statistic} of {@link Statistic.Type#ENTITY}. This acts as a convenience
     * to create more complex compound criteria such as being killed by a specific entity type.
     * An example would be {@code Criteria.statistic(Statistic.KILL_ENTITY, EntityType.CREEPER)},
     * returning a Criteria representing "minecraft.killed:minecraft.creeper" which will increment
     * when the player kills a creepers.
     * <p>
     * If the provided statistic does not require additional data, {@link #statistic(Statistic)}
     * is called and returned instead.
     * <p>
     * This method provides no guarantee that any given criteria exists on the vanilla server.
     *
     * @param statistic the statistic for which to get a criteria
     * @param entityType the relevant entity type
     * @return the criteria
     * @throws IllegalArgumentException if {@link Statistic#getType()} is not {@link Statistic.Type#ENTITY}
     */
    @NonNull
    static Criteria statistic(@NonNull Statistic statistic, @NonNull EntityType entityType) {
        Preconditions.checkArgument(statistic != null, "statistic must not be null");
        Preconditions.checkArgument(entityType != null, "entityType must not be null");
        Preconditions.checkArgument(statistic.getType() == Statistic.Type.ENTITY, "statistic type must be ENTITY, given %s", statistic.getType());

        switch (statistic) {
            case KILL_ENTITY:
                return Paper.getScoreboardCriteria("minecraft.killed:minecraft." + entityType.getKey().getKey());
            case ENTITY_KILLED_BY:
                return Paper.getScoreboardCriteria("minecraft.killed_by:minecraft." + entityType.getKey().getKey());
            default:
                break;
        }

        return statistic(statistic); // Fallback to a regular statistic
    }

    /**
     * Get a {@link Criteria} for the specified statistic.
     * <p>
     * An example would be {@code Criteria.statistic(Statistic.FLY_ONE_CM)}, returning a Criteria
     * representing "minecraft.custom:minecraft.aviate_one_cm" which will increment when the player
     * flies with an elytra.
     * <p>
     * This method provides no guarantee that any given criteria exists on the vanilla server. All
     * statistics are accepted, however some may not operate as expected if additional data is
     * required. For block/item-related statistics, see {@link #statistic(Statistic, Material)},
     * and for entity-related statistics, see {@link #statistic(Statistic, EntityType)}
     *
     * @param statistic the statistic for which to get a criteria
     * @return the criteria
     */
    @NonNull
    static Criteria statistic(@NonNull Statistic statistic) {
        Preconditions.checkArgument(statistic != null, "statistic must not be null");
        return Paper.getScoreboardCriteria(Paper.getUnsafe().getStatisticCriteriaKey(statistic)); // Paper
    }

    /**
     * Get (or create) a new {@link Criteria} by its name.
     *
     * @param name the criteria name
     * @return the created criteria
     */
    @NonNull
    static Criteria create(@NonNull String name) {
        return Paper.getScoreboardCriteria(name);
    }

}

