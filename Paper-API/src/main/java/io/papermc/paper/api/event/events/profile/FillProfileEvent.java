package io.papermc.paper.api.event.events.profile;

import io.papermc.paper.api.event.Event;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.profile.PlayerProfile;

/**
 * Fired once a profiles additional properties (such as textures) has been filled
 */
public interface FillProfileEvent extends Event {

    /**
     * @return The Profile that had properties filled
     */
    @Param(0)
    PlayerProfile profile();
}
