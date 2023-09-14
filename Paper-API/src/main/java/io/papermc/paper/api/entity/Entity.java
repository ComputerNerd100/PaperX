package io.papermc.paper.api.entity;

import io.papermc.paper.api.Nameable;
import io.papermc.paper.api.Server;
import io.papermc.paper.api.block.BlockFace;
import io.papermc.paper.api.block.PistonMoveReaction;
import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.metadata.Metadatable;
import io.papermc.paper.api.persistance.PersistentDataHolder;
import io.papermc.paper.api.sound.Sound;
import io.papermc.paper.api.threadedregion.scheduler.EntityScheduler;
import io.papermc.paper.api.util.vector.Vector;
import io.papermc.paper.api.world.Chunk;
import io.papermc.paper.api.world.World;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEventSource;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;


import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

/**
 * Represents a base entity in the world
 */
public interface Entity extends Metadatable, CommandSender, Nameable, PersistentDataHolder, HoverEventSource<HoverEvent.ShowEntity>, net.kyori.adventure.sound.Sound.Emitter {

    /**
     * Gets the entity's current position
     *
     * @return a new copy of Location containing the position of this entity
     */
    @NonNull
    public Location getLocation();

    /**
     * Stores the entity's current position in the provided Location object.
     * <p>
     * If the provided Location is null this method does nothing and returns
     * null.
     *
     * @param loc the location to copy into
     * @return The Location object provided or null
     */
    @Contract("null -> null; !null -> !null")
    @Nullable
    public Location getLocation(@Nullable Location loc);

    /**
     * Sets this entity's velocity in meters per tick
     *
     * @param velocity New velocity to travel with
     */
    public void setVelocity(@NonNull Vector velocity);

    /**
     * Gets this entity's current velocity
     *
     * @return Current traveling velocity of this entity
     */
    @NonNull
    public Vector getVelocity();

    /**
     * Gets the entity's height
     *
     * @return height of entity
     */
    public double getHeight();

    /**
     * Gets the entity's width
     *
     * @return width of entity
     */
    public double getWidth();

    /**
     * Gets the entity's current bounding box.
     * <p>
     * The returned bounding box reflects the entity's current location and
     * size.
     *
     * @return the entity's current bounding box
     */
    @NonNull
    public BoundingBox getBoundingBox();

    /**
     * Returns true if the entity is supported by a block. This value is a
     * state updated by the server and is not recalculated unless the entity
     * moves.
     *
     * @return True if entity is on ground.
     * @see Player#isOnGround()
     */
    public boolean isOnGround();

    /**
     * Returns true if the entity is in water.
     *
     * @return <code>true</code> if the entity is in water.
     */
    public boolean isInWater();

    /**
     * Gets the current world this entity resides in
     *
     * @return World
     */
    @NonNull
    public World getWorld();

    /**
     * Sets the entity's rotation.
     * <p>
     * Note that if the entity is affected by AI, it may override this rotation.
     *
     * @param yaw the yaw
     * @param pitch the pitch
     */
    public void setRotation(float yaw, float pitch);

    /**
     * Teleports this entity to the given location.
     *
     * @param location New location to teleport this entity to
     * @param teleportFlags Flags to be used in this teleportation
     * @return <code>true</code> if the teleport was successful
     */
    @org.jetbrains.annotations.ApiStatus.Experimental
    default boolean teleport(@NonNull Location location, @NonNull TeleportFlag @NonNull... teleportFlags) {
        return this.teleport(location, TeleportCause.PLUGIN, teleportFlags);
    }

    /**
     * Teleports this entity to the given location.
     *
     * @param location New location to teleport this entity to
     * @param cause The cause of this teleportation
     * @param teleportFlags Flags to be used in this teleportation
     * @return <code>true</code> if the teleport was successful
     */
    @org.jetbrains.annotations.ApiStatus.Experimental
    boolean teleport(@NonNull Location location, @NonNull TeleportCause cause, @NonNull TeleportFlag @NonNull... teleportFlags);

    /**
     * Teleports this entity to the given location. If this entity is riding a
     * vehicle, it will be dismounted prior to teleportation.
     *
     * @param location New location to teleport this entity to
     * @return <code>true</code> if the teleport was successful
     */
    public boolean teleport(@NonNull Location location);

    /**
     * Teleports this entity to the given location. If this entity is riding a
     * vehicle, it will be dismounted prior to teleportation.
     *
     * @param location New location to teleport this entity to
     * @param cause The cause of this teleportation
     * @return <code>true</code> if the teleport was successful
     */
    public boolean teleport(@NonNull Location location, @NonNull TeleportCause cause);

    /**
     * Teleports this entity to the target Entity. If this entity is riding a
     * vehicle, it will be dismounted prior to teleportation.
     *
     * @param destination Entity to teleport this entity to
     * @return <code>true</code> if the teleport was successful
     */
    public boolean teleport(@NonNull Entity destination);

    /**
     * Teleports this entity to the target Entity. If this entity is riding a
     * vehicle, it will be dismounted prior to teleportation.
     *
     * @param destination Entity to teleport this entity to
     * @param cause The cause of this teleportation
     * @return <code>true</code> if the teleport was successful
     */
    public boolean teleport(@NonNull Entity destination, @NonNull TeleportCause cause);

    // Paper start
    /**
     * Loads/Generates(in 1.13+) the Chunk asynchronously, and then teleports the entity when the chunk is ready.
     * @param loc Location to teleport to
     * @return A future that will be completed with the result of the teleport
     */
    @NonNull
    default CompletableFuture<Boolean> teleportAsync(@NonNull Location loc) {
        return teleportAsync(loc, TeleportCause.PLUGIN);
    }
    /**
     * Loads/Generates(in 1.13+) the Chunk asynchronously, and then teleports the entity when the chunk is ready.
     * @param loc Location to teleport to
     * @param cause Reason for teleport
     * @return A future that will be completed with the result of the teleport
     */
    @NonNull
    default CompletableFuture<Boolean> teleportAsync(@NonNull Location loc, @NonNull TeleportCause cause) {
        java.util.concurrent.CompletableFuture<Boolean> future = new java.util.concurrent.CompletableFuture<>();
        loc.getWorld().getChunkAtAsyncUrgently(loc).thenAccept((chunk) -> future.complete(teleport(loc, cause))).exceptionally(ex -> {
            future.completeExceptionally(ex);
            return null;
        });
        return future;
    }
    // Paper end

    /**
     * Returns a list of entities within a bounding box centered around this
     * entity
     *
     * @param x 1/2 the size of the box along x axis
     * @param y 1/2 the size of the box along y axis
     * @param z 1/2 the size of the box along z axis
     * @return {@code List<Entity>} List of entities nearby
     */
    @NonNull
    public List<Entity> getNearbyEntities(double x, double y, double z);

    /**
     * Returns a unique id for this entity
     *
     * @return Entity id
     */
    public int getEntityId();

    /**
     * Returns the entity's current fire ticks (ticks before the entity stops
     * being on fire).
     *
     * @return int fireTicks
     */
    public int getFireTicks();

    /**
     * Returns the entity's maximum fire ticks.
     *
     * @return int maxFireTicks
     */
    public int getMaxFireTicks();

    /**
     * Sets the entity's current fire ticks (ticks before the entity stops
     * being on fire).
     *
     * @param ticks Current ticks remaining
     */
    public void setFireTicks(int ticks);

    /**
     * Sets if the entity has visual fire (it will always appear to be on fire).
     *
     * @param fire whether visual fire is enabled
     */
    void setVisualFire(boolean fire);

    /**
     * Gets if the entity has visual fire (it will always appear to be on fire).
     *
     * @return whether visual fire is enabled
     */
    boolean isVisualFire();

    /**
     * Returns the entity's current freeze ticks (amount of ticks the entity has
     * been in powdered snow).
     *
     * @return int freeze ticks
     */
    int getFreezeTicks();

    /**
     * Returns the entity's maximum freeze ticks (amount of ticks before it will
     * be fully frozen)
     *
     * @return int max freeze ticks
     */
    int getMaxFreezeTicks();

    /**
     * Sets the entity's current freeze ticks (amount of ticks the entity has
     * been in powdered snow).
     *
     * @param ticks Current ticks
     */
    void setFreezeTicks(int ticks);

    /**
     * Gets if the entity is fully frozen (it has been in powdered snow for max
     * freeze ticks).
     *
     * @return freeze status
     */
    boolean isFrozen();

    // Paper Start - Freeze Tick Lock API
    /**
     * Gets if the entity currently has its freeze ticks locked
     * to a set amount.
     * <p>
     * This is only set by plugins
     *
     * @return locked or not
     */
    boolean isFreezeTickingLocked();

    /**
     * Sets if the entity currently has its freeze ticks locked,
     * preventing default vanilla freeze tick modification.
     *
     * @param locked prevent vanilla modification or not
     */
    void lockFreezeTicks(boolean locked);
    // Paper End - Freeze Tick Lock API

    /**
     * Mark the entity's removal.
     */
    public void remove();

    /**
     * Returns true if this entity has been marked for removal.
     *
     * @return True if it is dead.
     */
    public boolean isDead();

    /**
     * Returns false if the entity has died or been despawned for some other
     * reason.
     *
     * @return True if valid.
     */
    public boolean isValid();

    /**
     * Gets the {@link io.papermc.paper.api.Server} that contains this Entity
     *
     * @return Server instance running this Entity
     */
    @Override
    @NonNull
    Server getServer();

    /**
     * Returns true if the entity gets persisted.
     * <p>
     * By default all entities are persistent. An entity will also not get
     * persisted, if it is riding an entity that is not persistent.
     * <p>
     * The persistent flag on players controls whether or not to save their
     * playerdata file when they quit. If a player is directly or indirectly
     * riding a non-persistent entity, the vehicle at the root and all its
     * passengers won't get persisted.
     * <p>
     * <b>This should not be confused with
     * {@link LivingEntity#setRemoveWhenFarAway(boolean)} which controls
     * despawning of living entities. </b>
     *
     * @return true if this entity is persistent
     */
    public boolean isPersistent();

    /**
     * Sets whether or not the entity gets persisted.
     *
     * @param persistent the persistence status
     * @see #isPersistent()
     */
    public void setPersistent(boolean persistent);


    /**
     * Gets a list of passengers of this vehicle.
     * <p>
     * The returned list will not be directly linked to the entity's current
     * passengers, and no guarantees are made as to its mutability.
     *
     * @return list of entities corresponding to current passengers.
     */
    @NonNull
    public List<Entity> getPassengers();

    /**
     * Add a passenger to the vehicle.
     *
     * @param passenger The passenger to add
     * @return false if it could not be done for whatever reason
     */
    public boolean addPassenger(@NonNull Entity passenger);

    /**
     * Remove a passenger from the vehicle.
     *
     * @param passenger The passenger to remove
     * @return false if it could not be done for whatever reason
     */
    public boolean removePassenger(@NonNull Entity passenger);

    /**
     * Check if a vehicle has passengers.
     *
     * @return True if the vehicle has no passengers.
     */
    public boolean isEmpty();

    /**
     * Eject any passenger.
     *
     * @return True if there was a passenger.
     */
    public boolean eject();

    /**
     * Returns the distance this entity has fallen
     *
     * @return The distance.
     */
    public float getFallDistance();

    /**
     * Sets the fall distance for this entity
     *
     * @param distance The new distance.
     */
    public void setFallDistance(float distance);

    /**
     * Record the last {@link EntityDamageEvent} inflicted on this entity
     *
     * @param event a {@link EntityDamageEvent}
     */
    public void setLastDamageCause(@Nullable EntityDamageEvent event);

    /**
     * Retrieve the last {@link EntityDamageEvent} inflicted on this entity.
     * This event may have been cancelled.
     *
     * @return the last known {@link EntityDamageEvent} or null if hitherto
     *     unharmed
     */
    @Nullable
    public EntityDamageEvent getLastDamageCause();

    /**
     * Returns a unique and persistent id for this entity
     *
     * @return unique id
     */
    @NonNull
    public UUID getUniqueId();

    /**
     * Gets the amount of ticks this entity has lived for.
     * <p>
     * This is the equivalent to "age" in entities.
     *
     * @return Age of entity
     */
    public int getTicksLived();

    /**
     * Sets the amount of ticks this entity has lived for.
     * <p>
     * This is the equivalent to "age" in entities. May not be less than one
     * tick.
     *
     * @param value Age of entity
     */
    public void setTicksLived(int value);

    /**
     * Performs the specified {@link EntityEffect} for this entity.
     * <p>
     * This will be viewable to all players near the entity.
     * <p>
     * If the effect is not applicable to this class of entity, it will not play.
     *
     * @param type Effect to play.
     */
    public void playEffect(@NonNull EntityEffect type);

    /**
     * Get the type of the entity.
     *
     * @return The entity type.
     */
    @NonNull
    public EntityType getType();

    /**
     * Get the {@link Sound} this entity makes while swimming.
     *
     * @return the swimming sound
     */
    @NonNull
    public Sound getSwimSound();

    /**
     * Get the {@link Sound} this entity makes when splashing in water. For most
     * entities, this is just {@link Sound#ENTITY_GENERIC_SPLASH}.
     *
     * @return the splash sound
     */
    @NonNull
    public Sound getSwimSplashSound();

    /**
     * Get the {@link Sound} this entity makes when splashing in water at high
     * speeds. For most entities, this is just {@link Sound#ENTITY_GENERIC_SPLASH}.
     *
     * @return the splash sound
     */
    @NonNull
    public Sound getSwimHighSpeedSplashSound();

    /**
     * Returns whether this entity is inside a vehicle.
     *
     * @return True if the entity is in a vehicle.
     */
    public boolean isInsideVehicle();

    /**
     * Leave the current vehicle. If the entity is currently in a vehicle (and
     * is removed from it), true will be returned, otherwise false will be
     * returned.
     *
     * @return True if the entity was in a vehicle.
     */
    public boolean leaveVehicle();

    /**
     * Get the vehicle that this entity is inside. If there is no vehicle,
     * null will be returned.
     *
     * @return The current vehicle.
     */
    @Nullable
    public Entity getVehicle();

    /**
     * Sets whether or not to display the mob's custom name client side. The
     * name will be displayed above the mob similarly to a player.
     * <p>
     * This value has no effect on players, they will always display their
     * name.
     *
     * @param flag custom name or not
     */
    public void setCustomNameVisible(boolean flag);

    /**
     * Gets whether or not the mob's custom name is displayed client side.
     * <p>
     * This value has no effect on players, they will always display their
     * name.
     *
     * @return if the custom name is displayed
     */
    public boolean isCustomNameVisible();

    /**
     * Sets whether or not this entity is visible by default.
     *
     * If this entity is not visible by default, then
     * {@link Player#showEntity(Plugin, Entity)}
     * will need to be called before the entity is visible to a given player.
     *
     * @param visible default visibility status
     * @apiNote draft API
     */
    @ApiStatus.Experimental
    public void setVisibleByDefault(boolean visible);

    /**
     * Gets whether or not this entity is visible by default.
     *
     * If this entity is not visible by default, then
     * {@link Player#showEntity(Plugin, Entity)}
     * will need to be called before the entity is visible to a given player.
     *
     * @return default visibility status
     * @apiNote draft API
     */
    @ApiStatus.Experimental
    public boolean isVisibleByDefault();

    /**
     * Sets whether the entity has a team colored (default: white) glow.
     *
     * <b>nb: this refers to the 'Glowing' entity property, not whether a
     * glowing potion effect is applied</b>
     *
     * @param flag if the entity is glowing
     */
    void setGlowing(boolean flag);

    /**
     * Gets whether the entity is glowing or not.
     *
     * <b>nb: this refers to the 'Glowing' entity property, not whether a
     * glowing potion effect is applied</b>
     *
     * @return whether the entity is glowing
     */
    boolean isGlowing();

    /**
     * Sets whether the entity is invulnerable or not.
     * <p>
     * When an entity is invulnerable it can only be damaged by players in
     * creative mode.
     *
     * @param flag if the entity is invulnerable
     */
    public void setInvulnerable(boolean flag);

    /**
     * Gets whether the entity is invulnerable or not.
     *
     * @return whether the entity is
     */
    public boolean isInvulnerable();

    /**
     * Gets whether the entity is silent or not.
     *
     * @return whether the entity is silent.
     */
    public boolean isSilent();

    /**
     * Sets whether the entity is silent or not.
     * <p>
     * When an entity is silent it will not produce any sound.
     *
     * @param flag if the entity is silent
     */
    public void setSilent(boolean flag);

    /**
     * Returns whether gravity applies to this entity.
     *
     * @return whether gravity applies
     */
    boolean hasGravity();

    /**
     * Sets whether gravity applies to this entity.
     *
     * @param gravity whether gravity should apply
     */
    void setGravity(boolean gravity);

    /**
     * Gets the period of time (in ticks) before this entity can use a portal.
     *
     * @return portal cooldown ticks
     */
    int getPortalCooldown();

    /**
     * Sets the period of time (in ticks) before this entity can use a portal.
     *
     * @param cooldown portal cooldown ticks
     */
    void setPortalCooldown(int cooldown);

    /**
     * Returns a set of tags for this entity.
     * <br>
     * Entities can have no more than 1024 tags.
     *
     * @return a set of tags for this entity
     */
    @NonNull
    Set<String> getScoreboardTags();

    /**
     * Add a tag to this entity.
     * <br>
     * Entities can have no more than 1024 tags.
     *
     * @param tag the tag to add
     * @return true if the tag was successfully added
     */
    boolean addScoreboardTag(@NonNull String tag);

    /**
     * Removes a given tag from this entity.
     *
     * @param tag the tag to remove
     * @return true if the tag was successfully removed
     */
    boolean removeScoreboardTag(@NonNull String tag);

    /**
     * Returns the reaction of the entity when moved by a piston.
     *
     * @return reaction
     */
    @NonNull
    PistonMoveReaction getPistonMoveReaction();

    /**
     * Get the closest cardinal {@link BlockFace} direction an entity is
     * currently facing.
     * <br>
     * This will not return any non-cardinal directions such as
     * {@link BlockFace#UP} or {@link BlockFace#DOWN}.
     * <br>
     * {@link Hanging} entities will override this call and thus their behavior
     * may be different.
     *
     * @return the entity's current cardinal facing.
     * @see Hanging
     * @see io.papermc.paper.api.block.data.Directional#getFacing()
     */
    @NonNull
    BlockFace getFacing();

    /**
     * Gets the entity's current pose.
     *
     * <b>Note that the pose is only updated at the end of a tick, so may be
     * inconsistent with other methods. eg {@link Player#isSneaking()} being
     * true does not imply the current pose will be {@link Pose#SNEAKING}</b>
     *
     * @return current pose
     */
    @NonNull
    Pose getPose();

    /**
     * Returns if the entity is in sneak mode
     *
     * @return true if the entity is in sneak mode
     */
    boolean isSneaking();

    /**
     * Sets the sneak mode the entity.
     * <p>
     * Note: For most Entities this does not update Entity's pose
     * and just makes its name tag less visible.
     *
     * @param sneak true if the entity should be sneaking
     */
    void setSneaking(boolean sneak);

    /**
     * Sets the entity's current {@link Pose}.
     *
     * <p>Note: While poses affect some things like hitboxes, they do not change the entity's state
     * (e.g. having {@link Pose#SNEAKING} does not guarantee {@link #isSneaking()} being {@code true}).
     *
     * <p>If applied to the {@link Player}, they might see a different pose client-side.
     *
     * @param pose a new {@link Pose}
     * @see #setPose(Pose, boolean)
     */
    default void setPose(@NonNull Pose pose) {
        setPose(pose, false);
    }

    /**
     * Sets the entity's current {@link Pose}.
     *
     * <p>Note: While poses affect some things like hitboxes, they do not change the entity's state
     * (e.g. having {@link Pose#SNEAKING} does not guarantee {@link #isSneaking()} being {@code true}).
     *
     * <p>If applied to the {@link Player}, they might see a different pose client-side.
     *
     * @param pose a new {@link Pose}
     * @param fixed whether the new {@link Pose} should stay until manually changed
     */
    void setPose(@NonNull Pose pose, boolean fixed);

    /**
     * Checks whether the entity has a fixed {@link Pose}
     *
     * @see #setPose(Pose, boolean)
     * @return whether the entity has a fixed {@link Pose}
     */
    boolean hasFixedPose();

    /**
     * Get the category of spawn to which this entity belongs.
     *
     * @return the entity´s category spawn
     */
    @NonNull
    SpawnCategory getSpawnCategory();

    /**
     * Gets the entity's display name formatted with their team prefix/suffix and
     * the entity's default hover/click events.
     *
     * @return the team display name
     */
    net.kyori.adventure.text.@NonNull Component teamDisplayName();

    @NonNull
    @Override
    default HoverEvent<HoverEvent.ShowEntity> asHoverEvent(final @NonNull UnaryOperator<HoverEvent.ShowEntity> op) {
        return HoverEvent.showEntity(op.apply(HoverEvent.ShowEntity.of(this.getType().getKey(), this.getUniqueId(), this.customName())));
    }

    /**
     * Gets the location where this entity originates from.
     * <p>
     * This value can be null if the entity hasn't yet been added to the world.
     *
     * @return Location where entity originates or null if not yet added
     */
    @Nullable
    Location getOrigin();

    /**
     * Returns whether this entity was spawned from a mob spawner.
     *
     * @return True if entity spawned from a mob spawner
     */
    boolean fromMobSpawner();

    /**
     * Gets the latest chunk an entity is currently or was in.
     *
     * @return The current, or most recent chunk if the entity is invalid (which may load the chunk)
     */
    @NonNull
    default Chunk getChunk() {
        // TODO remove impl here
        return getLocation().getChunk();
    }

    /**
     * @return The {@link CreatureSpawnEvent.SpawnReason} that initially spawned this entity. <!-- Paper - added "initially" to clarify that the SpawnReason doesn't change after the Entity was initially spawned" -->
     */
    @NonNull
    CreatureSpawnEvent.SpawnReason getEntitySpawnReason();

    /**
     * Check if entity is underwater
     */
    boolean isUnderWater();

    /**
     * Check if entity is in rain
     */
    boolean isInRain();

    /**
     * Check if entity is in bubble column
     */
    boolean isInBubbleColumn();

    /**
     * Check if entity is in water or rain
     */
    boolean isInWaterOrRain();

    /**
     * Check if entity is in water or bubble column
     */
    boolean isInWaterOrBubbleColumn();

    /**
     * Check if entity is in water or rain or bubble column
     */
    boolean isInWaterOrRainOrBubbleColumn();

    /**
     * Check if entity is in lava
     */
    boolean isInLava();

    /**
     * Check if entity is inside a ticking chunk
     */
    boolean isTicking();

    /**
     * Returns a set of {@link Player Players} within this entity's tracking range (players that can "see" this entity).
     *
     * @return players in tracking range
     */
    @NonNull Set<Player> getTrackedPlayers();

    /**
     * Spawns the entity in the world at the given {@link Location} with the default spawn reason.
     * <p>
     * This will not spawn the entity if the entity is already spawned or has previously been despawned.
     * <p>
     * Also, this method will fire the same events as a normal entity spawn.
     *
     * @param location The location to spawn the entity at.
     * @return Whether the entity was successfully spawned.
     */
    public default boolean spawnAt(@NonNull Location location) {
        return spawnAt(location, CreatureSpawnEvent.SpawnReason.DEFAULT);
    }

    /**
     * Spawns the entity in the world at the given {@link Location} with the reason given.
     * <p>
     * This will not spawn the entity if the entity is already spawned or has previously been despawned.
     * <p>
     * Also, this method will fire the same events as a normal entity spawn.
     *
     * @param location The location to spawn the entity at.
     * @param reason   The reason for the entity being spawned.
     * @return Whether the entity was successfully spawned.
     */
    public boolean spawnAt(@NonNull Location location, @NonNull CreatureSpawnEvent.SpawnReason reason);

    /**
     * Check if entity is inside powdered snow.
     *
     * @return true if in powdered snow.
     */
    boolean isInPowderedSnow();

    /**
     * Gets the x-coordinate of this entity
     *
     * @return x-coordinate
     */
    double getX();

    /**
     * Gets the y-coordinate of this entity
     *
     * @return y-coordinate
     */
    double getY();

    /**
     * Gets the z-coordinate of this entity
     *
     * @return z-coordinate
     */
    double getZ();

    /**
     * Gets this entity's pitch
     *
     * @see Location#getPitch()
     * @return the entity's pitch
     */
    float getPitch();

    /**
     * Gets this entity's yaw
     *
     * @see Location#getYaw()
     * @return the entity's yaw
     */
    float getYaw();

    /**
     * Checks for any collisions with the entity's bounding box at the provided location.
     * This will check for any colliding entities (boats, shulkers) / worldborder / blocks.
     * Does not load chunks that are within the bounding box at the specified location.
     *
     * @param location the location to check collisions in
     * @return collides or not
     */
    boolean collidesAt(@NonNull Location location);

    /**
     * This checks using the given boundingbox as the entity's boundingbox if the entity would collide with anything.
     * This will check for any colliding entities (boats, shulkers) / worldborder / blocks.
     * Does not load chunks that are within the bounding box.
     *
     * @param boundingBox the box to check collisions in
     * @return collides or not
     */
    boolean wouldCollideUsing(@NonNull BoundingBox boundingBox);

    /**
     * Returns the task scheduler for this entity. The entity scheduler can be used to schedule tasks
     * that are guaranteed to always execute on the tick thread that owns the entity.
     * <p><b>If you do not need/want to make your plugin run on Folia, use {@link Server#getScheduler()} instead.</b></p>
     * @return the task scheduler for this entity.
     * @see EntityScheduler
     */
    @NonNull EntityScheduler getScheduler();

    /**
     * Gets the string name of the entity used to track it in {@link org.bukkit.scoreboard.Scoreboard Scoreboards}.
     *
     * @return the scoreboard entry name
     * @see Scoreboard#getScores(String)
     * @see Scoreboard#getEntries()
     */
    @NonNull String getScoreboardEntryName();
}

