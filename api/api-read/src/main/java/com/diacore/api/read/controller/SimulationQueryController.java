package com.diacore.api.read.controller;

import com.diacore.api.model.ExerciseSimulationEvent;
import com.diacore.api.model.GlucoseSimulationRequest;
import com.diacore.api.model.GlucoseSimulationResponse;
import com.diacore.api.model.PredictionTrajectoryPoint;
import com.diacore.api.model.RecommendedAction;
import com.diacore.api.operation.SimulationQueryApi;
import com.diacore.application.usecase.simulation.SimulateGlucoseTrajectory;
import com.diacore.application.usecase.simulation.SimulateGlucoseTrajectory.Request;
import com.diacore.application.usecase.simulation.SimulateGlucoseTrajectory.Request.ExerciseRequest;
import com.diacore.application.usecase.simulation.SimulateGlucoseTrajectory.Response;
import com.diacore.application.usecase.simulation.SimulateGlucoseTrajectory.Response.RecommendedActionResponse;
import com.diacore.application.usecase.simulation.SimulateGlucoseTrajectory.Response.TrajectoryPointResponse;
import com.diacore.infrastructure.actor.ActorSelector;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SimulationQueryController implements SimulationQueryApi {
    private final SimulateGlucoseTrajectory simulateGlucoseTrajectory;

    public SimulationQueryController(SimulateGlucoseTrajectory simulateGlucoseTrajectory) {
        this.simulateGlucoseTrajectory = simulateGlucoseTrajectory;
    }

    @Override
    public ResponseEntity<GlucoseSimulationResponse> predictGlucose(GlucoseSimulationRequest request) {
        Response result = ActorSelector.current()
                .requestTo(simulateGlucoseTrajectory)
                .by(new Request(
                        request.getCurrentGlucose(),
                        request.getBgMomentum(),
                        request.getIob(),
                        request.getCob(),
                        request.getPlannedCarbs(),
                        request.getPlannedInsulin(),
                        toExerciseRequest(request.getPlannedExercise())
                ));

        GlucoseSimulationResponse response = new GlucoseSimulationResponse()
                .reason(result.reason())
                .eventualBg(result.eventualBg())
                .snoozeBg(result.snoozeBg())
                .recommendedAction(toRecommendedAction(result.recommendedAction()))
                .trajectories(
                        result.trajectoryPoints().stream()
                                .map(this::toPredictionTrajectoryPoint).toList()
                );

        return ResponseEntity.ok(response);
    }

    private ExerciseRequest toExerciseRequest(
            ExerciseSimulationEvent event) {
        return new ExerciseRequest(
                event.getIntensity(),
                event.getDurationMinutes()
        );
    }

    private RecommendedAction toRecommendedAction(
            RecommendedActionResponse response) {
        return new RecommendedAction()
                .actionType(response.actionType())
                .suggestedValue(response.suggestedValue())
                .message(response.message());
    }

    private PredictionTrajectoryPoint toPredictionTrajectoryPoint(TrajectoryPointResponse response) {
        return new PredictionTrajectoryPoint()
                .offsetMinutes(response.offsetMinutes())
                .iobPred(response.iobPred())
                .cobPred(response.cobPred())
                .zeroTempPred(response.zeroTempPred())
                .uamPred(response.uamPred())
                .simulatedPred(response.simulatedPred());
    }
}
