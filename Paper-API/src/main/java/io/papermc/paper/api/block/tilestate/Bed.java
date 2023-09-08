package io.papermc.paper.api.block.tilestate;

import io.papermc.paper.api.block.color.Colorable;
import io.papermc.paper.api.block.color.DyeColor;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface Bed extends TileState, Colorable {
    @Override
    @NonNull DyeColor getColor();
}
