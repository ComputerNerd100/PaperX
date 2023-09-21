package io.papermc.paper.api.event.events.profile;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.profile.ProfileProperty;

import java.util.Set;
import java.util.UUID;

/**
 * Allows a plugin to intercept a Profile Lookup for a Profile by name
 *
 * At the point of event fire, the UUID and properties are unset.
 *
 * If a plugin sets the UUID, and optionally the properties, the API call to look up the profile may be skipped.
 *
 * No guarantees are made about thread execution context for this event. If you need to know, check
 * event.isAsync()
 */
public interface PreLookupProfileEvent extends Event {

    /**
     * @return Name of the profile
     */
    @Param(0)
    String name();

    /**
     * If this value is left null by the completion of the event call, then the server will
     * trigger a call to the Mojang API to look up the UUID (Network Request), and subsequently, fire a
     * {@link LookupProfileEvent}
     *
     * @return The UUID of the profile if it has already been provided by a plugin
     */
    @Param(1)
    UUID uuid();

    /**
     * @return The currently pending prepopulated properties.
     * Any property in this Set will be automatically prefilled on this Profile
     */
    @Param(2)
    Set<ProfileProperty> properties();
}
