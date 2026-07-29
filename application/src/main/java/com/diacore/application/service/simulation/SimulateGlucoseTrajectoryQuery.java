package com.diacore.application.service.simulation;

import com.diacore.application.usecase.simulation.SimulateGlucoseTrajectory;
import com.diacore.application.usecase.simulation.SimulateGlucoseTrajectory.Request.ExerciseRequest;
import com.diacore.application.usecase.simulation.SimulateGlucoseTrajectory.Response.RecommendedActionResponse;
import com.diacore.application.usecase.simulation.SimulateGlucoseTrajectory.Response.TrajectoryPointResponse;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.CarbRatioProfile;
import com.diacore.domain.profile.model.InsulinSensitivityProfile;
import com.diacore.domain.profile.port.out.LoadCarbRatioProfilePort;
import com.diacore.domain.profile.port.out.LoadInsulinSensitivityProfilePort;
import com.diacore.domain.simulation.model.CalculatedIobCob;
import com.diacore.domain.simulation.model.ExerciseEvent;
import com.diacore.domain.simulation.model.Insulin;
import com.diacore.domain.simulation.model.Meal;
import com.diacore.domain.simulation.model.RecommendedAction;
import com.diacore.domain.simulation.model.SimulationContext;
import com.diacore.domain.simulation.model.SimulationResult;
import com.diacore.domain.simulation.model.TrajectoryPoint;
import com.diacore.domain.simulation.port.out.LoadRecentTreatmentPort;
import com.diacore.domain.simulation.port.out.RequestGlucosePredictionPort;
import com.diacore.domain.simulation.service.IobCobCalculatorService;
import com.diacore.exception.BusinessException;
import com.diacore.exception.ErrorCode;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SimulateGlucoseTrajectoryQuery implements SimulateGlucoseTrajectory {
    private final RequestGlucosePredictionPort requestGlucosePredictionPort;
    private final IobCobCalculatorService iobCobCalculatorService;
    private final LoadCarbRatioProfilePort loadCarbRatioProfilePort;
    private final LoadInsulinSensitivityProfilePort loadInsulinSensitivityProfilePort;
    private final LoadRecentTreatmentPort loadRecentTreatmentPort;

    public SimulateGlucoseTrajectoryQuery(RequestGlucosePredictionPort requestGlucosePredictionPort,
                                          IobCobCalculatorService iobCobCalculatorService,
                                          LoadCarbRatioProfilePort loadCarbRatioProfilePort,
                                          LoadInsulinSensitivityProfilePort loadInsulinSensitivityProfilePort,
                                          LoadRecentTreatmentPort loadRecentTreatmentPort) {
        this.requestGlucosePredictionPort = requestGlucosePredictionPort;
        this.iobCobCalculatorService = iobCobCalculatorService;
        this.loadCarbRatioProfilePort = loadCarbRatioProfilePort;
        this.loadInsulinSensitivityProfilePort = loadInsulinSensitivityProfilePort;
        this.loadRecentTreatmentPort = loadRecentTreatmentPort;
    }

    @Override
    public Response execute(Actor actor, Request request) {
        Long userId = actor.userId();
        int currentHour = LocalTime.now(ZoneId.of("Asia/Seoul")).getHour(); // TODO
        Instant now = Instant.now();
        // 1. 사용자 현재 iob, cob, isf, cr 값 가져오기
        CarbRatioProfile carbRatioProfile = loadCarbRatioProfilePort.loadByUserId(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.THERAPY_CR_NOT_FOUND));
        InsulinSensitivityProfile insulinSensitivityProfile = loadInsulinSensitivityProfilePort.loadByUserId(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.THERAPY_ISF_NOT_FOUND));
        Float currentCr = carbRatioProfile.getCarbRatioForTime(currentHour);
        Float currentIsf = insulinSensitivityProfile.getInsulinSensitivityForTime(currentHour);

        List<Insulin> insulinRecords = loadRecentTreatmentPort.loadInsulinSince(userId, now.minusSeconds(6 * 3600));
        List<Meal> mealRecords = loadRecentTreatmentPort.loadMealsSince(userId, now.minusSeconds(6 * 3600));
        CalculatedIobCob calculatedState = iobCobCalculatorService.calculate(
                insulinRecords,
                mealRecords,
                now
        );

        // 2. 해당 값을 묶어서 어댑터로 전달
        SimulationContext context = new SimulationContext(
                userId,
                request.currentGlucose(),
                calculatedState.iob(),
                calculatedState.cob(),
                currentCr,
                currentIsf,
                request.bgMomentum(),
                request.plannedCarb(),
                request.plannedInsulin(),
                mapToDomainExercise(request.plannedExercise())
        );

        SimulationResult result = requestGlucosePredictionPort.predict(context);

        // 3. 받아온 결과를 Response로 묶어서 반환
        return new Response(
                result.reason(),
                result.eventualBg(),
                result.snoozeBg(),
                mapToDomainRecommendedAction(result.recommendedAction()),
                mapToDomainTrajectoryPoints(result.trajectoryPoints())
        );
    }

    private ExerciseEvent mapToDomainExercise(ExerciseRequest request) {
        if (request == null) {
            return null;
        }

        return new ExerciseEvent(
                request.exerciseIntensity(),
                request.durationMinutes()
        );
    }

    private RecommendedActionResponse mapToDomainRecommendedAction(RecommendedAction recommendedAction) {
        if (recommendedAction == null) {
            return null;
        }
        return new RecommendedActionResponse(
                recommendedAction.actionType(),
                recommendedAction.suggestedValue(),
                recommendedAction.message()
        );
    }

    private List<TrajectoryPointResponse> mapToDomainTrajectoryPoints(
            List<TrajectoryPoint> trajectoryPoints) {
        return trajectoryPoints.stream()
                .map(trajectoryPoint -> new TrajectoryPointResponse(
                        trajectoryPoint.offsetMinutes(),
                        trajectoryPoint.iobPred(),
                        trajectoryPoint.cobPred(),
                        trajectoryPoint.zeroTempPred(),
                        trajectoryPoint.uamPred(),
                        trajectoryPoint.simulatedPred()
                )).toList();
    }
}
