package com.diacore.domain.simulation.model;

import java.util.List;

public record SimulationResult(
        String reason,
        int eventualBg,
        Integer snoozeBg,
        RecommendedAction recommendedAction,
        List<TrajectoryPoint> trajectoryPoints
) {
}
