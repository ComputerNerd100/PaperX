package io.papermc.paper.api.event.events.profile;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.profile.PlayerProfile;

/**
 * Fired when the server is requesting to fill in properties of an incomplete profile, such as textures.
 *
 * Allows plugins to pre populate cached properties and avoid a call to the Mojang API
 */
public interface PreFillProfileEvent extends Event {

    /**
     * @return The profile that needs its properties filled
     */
    @Param(0)
    PlayerProfile profile();
}
