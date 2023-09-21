package io.papermc.paper.api.event.events.player;

import io.papermc.paper.api.entity.Player;
import io.papermc.paper.api.event.util.Param;

import java.util.Locale;

/**
 * Called when a player changes their locale in the client settings.
 */
public interface PlayerLocaleChangeEvent extends PlayerResultEvent {

    /**
     * @see Player#locale()
     *
     * @return the player's new locale
     */
    @Param(0)
    Locale adventureLocale();
}
