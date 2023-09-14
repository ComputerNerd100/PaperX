package io.papermc.paper.api.attribute;

import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Types of attributes which may be present on an {@link Attributable}.
 */
public enum Attribute implements Keyed, net.kyori.adventure.translation.Translatable { // Paper - Adventure translations

    /**
     * Maximum health of an Entity.
     */
    GENERIC_MAX_HEALTH("generic.max_health"),
    /**
     * Range at which an Entity will follow others.
     */
    GENERIC_FOLLOW_RANGE("generic.follow_range"),
    /**
     * Resistance of an Entity to knockback.
     */
    GENERIC_KNOCKBACK_RESISTANCE("generic.knockback_resistance"),
    /**
     * Movement speed of an Entity.
     */
    GENERIC_MOVEMENT_SPEED("generic.movement_speed"),
    /**
     * Flying speed of an Entity.
     */
    GENERIC_FLYING_SPEED("generic.flying_speed"),
    /**
     * Attack damage of an Entity.
     */
    GENERIC_ATTACK_DAMAGE("generic.attack_damage"),
    /**
     * Attack knockback of an Entity.
     */
    GENERIC_ATTACK_KNOCKBACK("generic.attack_knockback"),
    /**
     * Attack speed of an Entity.
     */
    GENERIC_ATTACK_SPEED("generic.attack_speed"),
    /**
     * Armor bonus of an Entity.
     */
    GENERIC_ARMOR("generic.armor"),
    /**
     * Armor durability bonus of an Entity.
     */
    GENERIC_ARMOR_TOUGHNESS("generic.armor_toughness"),
    /**
     * Luck bonus of an Entity.
     */
    GENERIC_LUCK("generic.luck"),
    /**
     * Strength with which a horse will jump.
     */
    HORSE_JUMP_STRENGTH("horse.jump_strength"),
    /**
     * Chance of a zombie to spawn reinforcements.
     */
    ZOMBIE_SPAWN_REINFORCEMENTS("zombie.spawn_reinforcements");

    private final NamespacedKey key;

    Attribute(String key) {
        this.key = NamespacedKey.minecraft(key);
    }

    @NonNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }
    @Override
    public @NonNull String translationKey() {
        return "attribute.name." + this.key.getKey();
    }
}
