package io.papermc.paper.api.event.events.block;

/**
 * Called when leaves are decaying naturally.
 * <p>
 * If a Leaves Decay event is cancelled, the leaves will not decay.
 */
public interface LeavesDecayEvent extends CancellableBlockEvent {
}
