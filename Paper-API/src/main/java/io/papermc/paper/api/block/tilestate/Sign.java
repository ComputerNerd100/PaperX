package io.papermc.paper.api.block.tilestate;

import io.papermc.paper.api.block.color.Colorable;
import io.papermc.paper.api.block.sign.Side;
import io.papermc.paper.api.block.sign.SignSide;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a captured state of either a SignPost or a WallSign.
 */
public interface Sign extends TileState, Colorable {

    /**
     * Gets whether or not this sign has been waxed. If a sign has been waxed, it
     * cannot be edited by a player.
     *
     * @return if this sign is waxed
     */
    public boolean isWaxed();

    /**
     * Sets whether or not this sign has been waxed. If a sign has been waxed, it
     * cannot be edited by a player.
     *
     * @param waxed if this sign is waxed
     */
    public void setWaxed(boolean waxed);


    /**
     * Return the side of the sign.
     *
     * @param side the side of the sign
     * @return the selected side of the sign
     */
    @NonNull
    public SignSide getSide(@NonNull Side side);

    // Paper start - get side for player
    /**
     * Compute the side facing the specified entity.
     *
     * @param entity the entity
     * @return the side it is facing
     */
    default @NotNull Side getInteractableSideFor(@NonNull Entity entity) {
        return this.getInteractableSideFor(entity.getLocation());
    }

    /**
     * Compute the side facing the specific position.
     *
     * @param position the position
     * @return the side the position is facing
     */
    default @NotNull Side getInteractableSideFor(@NonNull Position position) {
        return this.getInteractableSideFor(position.x(), position.z());
    }

    /**
     * Compute the side facing the specific x and z coordinates.
     *
     * @param x the x coord
     * @param z the z coord
     * @return the side the coordinates are facing
     */
    @NotNull Side getInteractableSideFor(double x, double z);
    // Paper end
}

