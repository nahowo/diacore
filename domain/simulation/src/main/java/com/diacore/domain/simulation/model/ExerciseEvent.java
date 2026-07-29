package com.diacore.domain.simulation.model;

public record ExerciseEvent(
        ExerciseIntensity intensity,
        int durationMinutes
) {}
