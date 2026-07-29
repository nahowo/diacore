package com.diacore.domain.simulation.model;

import java.time.Instant;

public record Meal(
        float carbsGrams,
        Instant timestamp
) {
    public Meal {
        if (carbsGrams <= 0) {
            throw new IllegalArgumentException("탄수화물 양은 0을 초과해야 합니다.");
        }
    }
    public static Meal create(float carbsGrams, Instant timestamp) {
        return new Meal(carbsGrams, timestamp);
    }
}
