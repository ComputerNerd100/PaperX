package io.papermc.paper.api.entity.minecart;

import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.entity.IronGolem;
import io.papermc.paper.api.entity.LivingEntity;
import io.papermc.paper.api.entity.Minecart;

/**
 * Represents a minecart that can have certain {@link
 * Entity entities} as passengers. Normal passengers
 * include all {@link LivingEntity living entities} with
 * the exception of {@link IronGolem iron golems}.
 * Non-player entities that meet normal passenger criteria automatically
 * mount these minecarts when close enough.
 */
public interface RideableMinecart extends Minecart {
}
