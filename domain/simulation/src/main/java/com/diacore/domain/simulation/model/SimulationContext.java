package com.diacore.domain.simulation.model;

public record SimulationContext(
        Long userId,
        int currentGlucose,
        float iob,
        float cob,
        float cr,
        float isf,
        Integer bgMomentum,
        Float plannedCarbs,
        Float plannedInsulin,
        ExerciseEvent plannedExercise
) {}
