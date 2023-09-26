package io.papermc.paper.api.event.events.brigadier;

import com.mojang.brigadier.suggestion.Suggestions;
import io.papermc.paper.api.event.events.player.CancellablePlayerEvent;
import io.papermc.paper.api.event.util.Param;

public interface AsyncPlayerSendSuggestionsEvent extends CancellablePlayerEvent {
    @Param(1)
    Suggestions suggestions();
    @Param(2)
    String buffer();

}
