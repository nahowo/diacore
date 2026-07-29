package com.diacore.application.usecase.simulation;

import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.simulation.model.ActionType;
import com.diacore.domain.simulation.model.ExerciseIntensity;
import java.util.List;

public interface SimulateGlucoseTrajectory extends UseCase<SimulateGlucoseTrajectory.Request, SimulateGlucoseTrajectory.Response> {
    record Request(
            int currentGlucose,
            Integer bgMomentum,
            Float iob,
            Float cob,
            Float plannedCarb,
            Float plannedInsulin,
            ExerciseRequest plannedExercise
    ) {
        public record ExerciseRequest(
            ExerciseIntensity exerciseIntensity,
            int durationMinutes
        ) {}
    }
    record Response(
            String reason,
            int eventualBg,
            int snoozeBg,
            RecommendedActionResponse recommendedAction,
            List<TrajectoryPointResponse> trajectoryPoints
    ) {
        public record RecommendedActionResponse(
                ActionType actionType,
                Float suggestedValue,
                String message
        ) {}

        public record TrajectoryPointResponse(
                int offsetMinutes,
                Integer iobPred,
                Integer cobPred,
                Integer zeroTempPred,
                Integer uamPred,
                Integer simulatedPred
        ) {}
    }
}
