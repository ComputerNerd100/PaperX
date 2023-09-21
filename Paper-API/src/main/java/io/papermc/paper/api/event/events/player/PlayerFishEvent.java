package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.FishHook;
import io.papermc.paper.api.entity.Item;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.EquipmentSlot;

/**
 * Thrown when a player is fishing
 */
public interface PlayerFishEvent extends CancellablePlayerEvent {

    /**
     * Gets the entity caught by the player.
     * <p>
     * If player has fished successfully, the result may be cast to {@link Item}.
     *
     * @return Entity caught by the player, Entity if fishing, and null if
     *     bobber has gotten stuck in the ground or nothing has been caught
     */
    @Param(1)
    Entity caught();

    /**
     * Gets the amount of experience received when fishing.
     * <p>
     * Note: This value has no default effect unless the event state is {@link
     * State#CAUGHT_FISH}.
     *
     * @return the amount of experience to drop
     */
    @Param(2)
    int exp();

    /**
     * Gets the state of the fishing
     *
     * @return A State detailing the state of the fishing
     */
    @Param(3)
    State state();

    /**
     * Gets the fishing hook.
     *
     * @return the entity representing the fishing hook/bobber.
     */
    @Param(4)
    FishHook hookEntity();

    /**
     * Get the hand that was used in this event.
     * <p>
     * The hand used is only present when the event state is {@link State#FISHING}.
     * In all other states, the hand is null.
     *
     * @return the hand
     */
    @Param(5)
    EquipmentSlot hand();

    /**
     * An enum to specify the state of the fishing
     */
    enum State {
        /**
         * When a player is fishing, ie casting the line out.
         */
        FISHING,
        /**
         * When a player has successfully caught a fish and is reeling it in. In
         * this instance, a "fish" is any item retrieved from water as a result
         * of fishing, ie an item, but not necessarily a fish.
         */
        CAUGHT_FISH,
        /**
         * When a player has successfully caught an entity. This refers to any
         * already spawned entity in the world that has been hooked directly by
         * the rod.
         */
        CAUGHT_ENTITY,
        /**
         * When a bobber is stuck in the ground.
         */
        IN_GROUND,
        /**
         * When a player fails to catch a bite while fishing usually due to
         * poor timing.
         */
        FAILED_ATTEMPT,
        /**
         * When a player reels in their hook without receiving any bites.
         */
        REEL_IN,
        /**
         * Called when there is a bite on the hook and it is ready to be reeled
         * in.
         */
        BITE
    }
}
