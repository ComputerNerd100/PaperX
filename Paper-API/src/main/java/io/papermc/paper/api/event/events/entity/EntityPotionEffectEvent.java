package io.papermc.paper.api.event.events.entity;

import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.event.util.Param;

/**
 * Called when a potion effect is modified on an entity.
 * <p>
 * If the event is cancelled, no change will be made on the entity.
 */
public interface EntityPotionEffectEvent extends CancellableEntityEvent {
    default LivingEntity livingEntity() {
        return (LivingEntity) entity();
    }

    /**
     * Gets the old potion effect of the changed type, which will be removed.
     *
     * @return The old potion effect or null if the entity did not have the
     * changed effect type.
     */
    @Param(0)
    PotionEffect oldEffect();

    /**
     * Gets new potion effect of the changed type to be applied.
     *
     * @return The new potion effect or null if the effect of the changed type
     * will be removed.
     */
    @Param(1)
    PotionEffect newEffect();

    /**
     * Gets the cause why the effect has changed.
     *
     * @return A Cause value why the effect has changed.
     */
    @Param(2)
    Cause cause();

    /**
     * Gets the action which will be performed on the potion effect type.
     *
     * @return An action to be performed on the potion effect type.
     */
    @Param(3)
    Action action();

    /**
     * Returns if the new potion effect will override the old potion effect
     * (Only applicable for the CHANGED Action).
     *
     * @return If the new effect will override the old one.
     */
    @Param(4)
    boolean override();

    enum Action {

        /**
         * When the potion effect is added because the entity didn't have its
         * type.
         */
        ADDED,
        /**
         * When the entity already had the potion effect type, but the effect is
         * changed.
         */
        CHANGED,
        /**
         * When the effect is removed due to all effects being removed.
         */
        CLEARED,
        /**
         * When the potion effect type is completely removed.
         */
        REMOVED
    }

    enum Cause {

        /**
         * When the entity stands inside an area effect cloud.
         */
        AREA_EFFECT_CLOUD,
        /**
         * When the entity is hit by an spectral or tipped arrow.
         */
        ARROW,
        /**
         * When the entity is inflicted with a potion effect due to an entity
         * attack (e.g. a cave spider or a shulker bullet).
         */
        ATTACK,
        /**
         * When an entity gets the effect from an axolotl.
         */
        AXOLOTL,
        /**
         * When beacon effects get applied due to the entity being nearby.
         */
        BEACON,
        /**
         * When a potion effect is changed due to the /effect command.
         */
        COMMAND,
        /**
         * When the entity gets the effect from a conduit.
         */
        CONDUIT,
        /**
         * When a conversion from a villager zombie to a villager is started or
         * finished.
         */
        CONVERSION,
        /**
         * When all effects are removed due to death (Note: This is called on
         * respawn, so it's player only!)
         */
        DEATH,
        /**
         * When the entity gets the effect from a dolphin.
         */
        DOLPHIN,
        /**
         * When the effect was removed due to expiration.
         */
        EXPIRATION,
        /**
         * When an effect is inflicted due to food (e.g. when a player eats or a
         * cookie is given to a parrot).
         */
        FOOD,
        /**
         * When an illusion illager makes himself disappear.
         */
        ILLUSION,
        /**
         * When all effects are removed due to a bucket of milk.
         */
        MILK,
        /**
         * When a player gets bad omen after killing a patrol captain.
         */
        PATROL_CAPTAIN,
        /**
         * When a potion effect is modified through the plugin methods.
         */
        PLUGIN,
        /**
         * When the entity drinks a potion.
         */
        POTION_DRINK,
        /**
         * When the entity is inflicted with an effect due to a splash potion.
         */
        POTION_SPLASH,
        /**
         * When a spider gets effects when spawning on hard difficulty.
         */
        SPIDER_SPAWN,
        /**
         * When the entity gets effects from a totem item saving its life.
         */
        TOTEM,
        /**
         * When the entity gets water breathing by wearing a turtle helmet.
         */
        TURTLE_HELMET,
        /**
         * When the Cause is missing.
         */
        UNKNOWN,
        /**
         * When a villager gets regeneration after a trade.
         */
        VILLAGER_TRADE,
        /**
         * When an entity gets the effect from a warden.
         */
        WARDEN,
        /**
         * When an entity comes in contact with a wither rose.
         */
        WITHER_ROSE
    }
}
