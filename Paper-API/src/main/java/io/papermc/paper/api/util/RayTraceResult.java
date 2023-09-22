package io.papermc.paper.api.util;

import com.google.common.base.Preconditions;
import io.papermc.paper.api.block.Block;
import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.util.vector.Vector;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

/**
 * The hit result of a ray trace.
 * <p>
 * Only the hit position is guaranteed to always be available. The availability
 * of the other attributes depends on what got hit and on the context in which
 * the ray trace was performed.
 */
public class RayTraceResult {

    private final Vector hitPosition;

    private final Block hitBlock;
    private final BlockFace hitBlockFace;
    private final Entity hitEntity;

    private RayTraceResult(@NonNull Vector hitPosition, @Nullable Block hitBlock, @Nullable BlockFace hitBlockFace, @Nullable Entity hitEntity) {
        Preconditions.checkArgument(hitPosition != null, "Hit position is null!");
        this.hitPosition = hitPosition.clone();
        this.hitBlock = hitBlock;
        this.hitBlockFace = hitBlockFace;
        this.hitEntity = hitEntity;
    }

    /**
     * Creates a RayTraceResult.
     *
     * @param hitPosition the hit position
     */
    public RayTraceResult(@NonNull Vector hitPosition) {
        this(hitPosition, null, null, null);
    }

    /**
     * Creates a RayTraceResult.
     *
     * @param hitPosition the hit position
     * @param hitBlockFace the hit block face
     */
    public RayTraceResult(@NonNull Vector hitPosition, @Nullable BlockFace hitBlockFace) {
        this(hitPosition, null, hitBlockFace, null);
    }

    /**
     * Creates a RayTraceResult.
     *
     * @param hitPosition the hit position
     * @param hitBlock the hit block
     * @param hitBlockFace the hit block face
     */
    public RayTraceResult(@NonNull Vector hitPosition, @Nullable Block hitBlock, @Nullable BlockFace hitBlockFace) {
        this(hitPosition, hitBlock, hitBlockFace, null);
    }

    /**
     * Creates a RayTraceResult.
     *
     * @param hitPosition the hit position
     * @param hitEntity the hit entity
     */
    public RayTraceResult(@NonNull Vector hitPosition, @Nullable Entity hitEntity) {
        this(hitPosition, null, null, hitEntity);
    }

    /**
     * Creates a RayTraceResult.
     *
     * @param hitPosition the hit position
     * @param hitEntity the hit entity
     * @param hitBlockFace the hit block face
     */
    public RayTraceResult(@NonNull Vector hitPosition, @Nullable Entity hitEntity, @Nullable BlockFace hitBlockFace) {
        this(hitPosition, null, hitBlockFace, hitEntity);
    }

    /**
     * Gets the exact position of the hit.
     *
     * @return a copy of the exact hit position
     */
    @NonNull
    public Vector getHitPosition() {
        return hitPosition.clone();
    }

    /**
     * Gets the hit block.
     *
     * @return the hit block, or <code>null</code> if not available
     */
    @Nullable
    public Block getHitBlock() {
        return hitBlock;
    }

    /**
     * Gets the hit block face.
     *
     * @return the hit block face, or <code>null</code> if not available
     */
    @Nullable
    public BlockFace getHitBlockFace() {
        return hitBlockFace;
    }

    /**
     * Gets the hit entity.
     *
     * @return the hit entity, or <code>null</code> if not available
     */
    @Nullable
    public Entity getHitEntity() {
        return hitEntity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + hitPosition.hashCode();
        result = prime * result + ((hitBlock == null) ? 0 : hitBlock.hashCode());
        result = prime * result + ((hitBlockFace == null) ? 0 : hitBlockFace.hashCode());
        result = prime * result + ((hitEntity == null) ? 0 : hitEntity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RayTraceResult other)) return false;
        if (!hitPosition.equals(other.hitPosition)) return false;
        if (!Objects.equals(hitBlock, other.hitBlock)) return false;
        if (!Objects.equals(hitBlockFace, other.hitBlockFace)) return false;
        return Objects.equals(hitEntity, other.hitEntity);
    }

    @Override
    public String toString() {
        String builder = "RayTraceResult [hitPosition=" +
                hitPosition +
                ", hitBlock=" +
                hitBlock +
                ", hitBlockFace=" +
                hitBlockFace +
                ", hitEntity=" +
                hitEntity +
                "]";
        return builder;
    }
}

