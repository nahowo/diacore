package com.diacore.domain.simulation.model;

public record RecommendedAction(
        ActionType actionType,
        Float suggestedValue,
        String message
) {}
