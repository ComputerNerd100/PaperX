package io.papermc.paper.api.event.events.player;

/**
 * Called when a player has slept long enough
 * to count as passing the night/storm.
 * <p>
 * Cancelling this event will prevent the player from being counted as deeply sleeping
 * unless they exit and re-enter the bed.
 */
public interface PlayerDeepSleepEvent extends CancellablePlayerEvent {
}
