package io.papermc.paper.api.map;

import io.papermc.paper.api.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface MapRenderer {

    boolean isContextual(boolean contextual);
    void initialize(@NonNull MapView map);
    void render(@NonNull MapView map, @NonNull MapCanvas canvas, @NonNull Player player);
}
