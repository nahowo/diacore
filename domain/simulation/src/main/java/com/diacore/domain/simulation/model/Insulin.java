package com.diacore.domain.simulation.model;

import java.time.Instant;

public record Insulin(
        float units,
        Instant timestamp
) {
    public Insulin {
        if (units <= 0) {
            throw new IllegalArgumentException("인슐린은 0을 초과해야 합니다.");
        }
    }
    public static Insulin create(float units, Instant timestamp) {
        return new Insulin(units, timestamp);
    }
}
