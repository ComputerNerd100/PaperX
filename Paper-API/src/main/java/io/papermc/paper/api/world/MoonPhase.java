package io.papermc.paper.api.world;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;

public enum MoonPhase {
    FULL_MOON(0L),
    WANING_GIBBOUS(1L),
    LAST_QUARTER(2L),
    WANING_CRESCENT(3L),
    NEW_MOON(4L),
    WAXING_CRESCENT(5L),
    FIRST_QUARTER(6L),
    WAXING_GIBBOUS(7L);

    private final long day;

    MoonPhase(long day) {
        this.day = day;
    }

    private static final Map<Long, MoonPhase> BY_DAY = new HashMap<>();

    static {
        for (MoonPhase phase : values()) {
            BY_DAY.put(phase.day, phase);
        }
    }

    @NonNull
    public static MoonPhase getPhase(long day) {
        return BY_DAY.get(day % 8L);
    }
}

