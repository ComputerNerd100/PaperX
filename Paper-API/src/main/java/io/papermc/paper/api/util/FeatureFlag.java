package io.papermc.paper.api.util;

import io.papermc.paper.api.Paper;
import io.papermc.paper.api.annotation.MinecraftExperimental;
import io.papermc.paper.api.namespace.Keyed;
import io.papermc.paper.api.namespace.NamespacedKey;
import org.jetbrains.annotations.ApiStatus;

/**
 * This represents a Feature Flag for a World.
 */
@ApiStatus.Experimental
public interface FeatureFlag extends Keyed {

    public static final FeatureFlag VANILLA = Paper.getUnsafe().getFeatureFlag(NamespacedKey.minecraft("vanilla"));

    @MinecraftExperimental
    public static final FeatureFlag BUNDLE = Paper.getUnsafe().getFeatureFlag(NamespacedKey.minecraft("bundle"));

    /**
     * <strong>AVAILABLE BETWEEN VERSIONS:</strong> 1.19 - 1.19.4
     */
    @MinecraftExperimental
    public static final FeatureFlag UPDATE_1_20 = Paper.getUnsafe().getFeatureFlag(NamespacedKey.minecraft("update_1_20"));
}

