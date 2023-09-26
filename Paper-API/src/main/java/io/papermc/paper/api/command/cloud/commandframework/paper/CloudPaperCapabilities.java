package io.papermc.paper.api.command.cloud.commandframework.paper;

import cloud.commandframework.CloudCapability;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Capabilities for the Bukkit module
 */
public enum CloudPaperCapabilities implements CloudCapability {
    NATIVE_BRIGADIER(true),
    ASYNCHRONOUS_COMPLETION(true);

    static final Set<CloudPaperCapabilities> CAPABLE = Arrays.stream(values())
            .filter(CloudPaperCapabilities::capable)
            .collect(Collectors.toSet());

    private final boolean capable;

    CloudPaperCapabilities(final boolean capable) {
        this.capable = capable;
    }

    boolean capable() {
        return this.capable;
    }

    @Override
    public @NonNull String toString() {
        return name();
    }
}

