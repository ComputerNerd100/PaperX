package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.ClientOption;
import io.papermc.paper.api.SkinParts;
import io.papermc.paper.api.event.util.Param;
import io.papermc.paper.api.inventory.MainHand;

/**
 * Called when the player changes their client settings
 */
public interface PlayerClientOptionsChangeEvent extends PlayerResultEvent {

    /**
     * Gets the new locale of the player
     * @return the new locale of the player
     */
    @Param(0)
    String locale();

    /**
     * Gets the new view distance of the player
     * @return the new view distance of the player
     */
    @Param(1)
    int viewDistance();

    /**
     * Gets the new chat visibility of the player
     * @return the new chat visibility of the player
     */
    @Param(2)
    ClientOption.ChatVisibility chatVisibility();

    /**
     * Gets the new chat colors of the player
     * @return the new chat colors of the player
     */
    @Param(3)
    boolean chatColors();

    /**
     * Gets the new skin parts of the player
     * @return the new skin parts of the player
     */
    @Param(4)
    SkinParts skinParts();

    /**
     * Gets the new main hand of the player
     * @return the new main hand of the player
     */
    @Param(5)
    MainHand mainHand();

    /**
     * Gets whether the player allows server listings
     * @return whether the player allows server listings
     */
    @Param(6)
    boolean allowServerListings();

    /**
     * Gets whether the player allows text filtering
     * @return whether the player allows text filtering
     */
    @Param(7)
    boolean textFilteringEnabled();
}
