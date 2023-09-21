package io.papermc.paper.api.event.events.profile;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.profile.PlayerProfile;

/**
 * Allows a plugin to be notified anytime AFTER a Profile has been looked up from the Mojang API
 * This is an opportunity to view the response and potentially cache things.
 *
 * No guarantees are made about thread execution context for this event. If you need to know, check
 * event.isAsync()
 */
public interface LookupProfileEvent extends Event {

    /**
     * @return The profile that was recently looked up. This profile can be mutated
     */
    @Param(0)
    PlayerProfile profile();
}
