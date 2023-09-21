package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.event.util.Param;

/**
 * Represents a player animation event
 * <br>Use {@link PlayerArmSwingEvent} for determining which arm was swung.
 */
public interface PlayerAnimationEvent extends CancellablePlayerEvent {

    /**
     * Get the type of this animation event
     *
     * @return the animation type
     */
    @Param(1)
    PlayerAnimationType animationType();
}
