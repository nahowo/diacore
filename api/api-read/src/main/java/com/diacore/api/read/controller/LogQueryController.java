package com.diacore.api.read.controller;

import com.diacore.api.model.GlucoseLogPageResponse;
import com.diacore.api.model.GlucoseLogResponse;
import com.diacore.api.model.InsulinLogPageResponse;
import com.diacore.api.model.InsulinLogResponse;
import com.diacore.api.model.MealLogPageResponse;
import com.diacore.api.model.MealLogResponse;
import com.diacore.api.operation.LogQueryApi;
import com.diacore.application.usecase.log.GetGlucoseLogs;
import com.diacore.application.usecase.log.GetInsulinLogs;
import com.diacore.application.usecase.log.GetMealLogs;
import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.log.model.GlucoseLog;
import com.diacore.domain.log.model.InsulinLog;
import com.diacore.domain.log.model.MealLog;
import com.diacore.infrastructure.actor.ActorSelector;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LogQueryController implements LogQueryApi {
    private final GetMealLogs getMealLogs;
    private final GetInsulinLogs getInsulinLogs;
    private final GetGlucoseLogs getGlucoseLogs;

    public LogQueryController(GetMealLogs getMealLogs, GetInsulinLogs getInsulinLogs, GetGlucoseLogs getGlucoseLogs) {
        this.getMealLogs = getMealLogs;
        this.getInsulinLogs = getInsulinLogs;
        this.getGlucoseLogs = getGlucoseLogs;
    }

    @Override
    public ResponseEntity<InsulinLogPageResponse> getInsulinLogs(Integer page, Integer size) {
        PageResult<InsulinLog> result = ActorSelector.current()
                .requestTo(getInsulinLogs)
                .by(new GetInsulinLogs.Request(page, size));

        List<InsulinLogResponse> responseContent = result.content().stream()
                .map(log -> new InsulinLogResponse()
                        .id(log.id())
                        .timestamp(log.timestamp())
                        .dose(log.dose())
                        .insulinType(log.type())
                ).toList();

        InsulinLogPageResponse response = new InsulinLogPageResponse()
                .content(responseContent)
                .totalElements(result.totalElements())
                .pageNumber(result.pageNumber());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<MealLogPageResponse> getMealLogs(Integer page, Integer size) {
        PageResult<MealLog> result = ActorSelector.current()
                .requestTo(getMealLogs)
                .by(new GetMealLogs.Request(page, size));

        List<MealLogResponse> responseContent = result.content().stream()
                .map(log -> new MealLogResponse()
                        .id(log.id())
                        .timestamp(log.timestamp())
                        .carbohydrateG(log.carbohydrateG())
                        .mealType(log.mealType())
                        .foodDesc(log.foodDesc())
                ).toList();

        MealLogPageResponse response = new MealLogPageResponse()
                .content(responseContent)
                .totalElements(result.totalElements())
                .pageNumber(result.pageNumber());

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<GlucoseLogPageResponse> getGlucoseLogs(Integer page, Integer size) {
        PageResult<GlucoseLog> result = ActorSelector.current()
                .requestTo(getGlucoseLogs)
                .by(new GetGlucoseLogs.Request(page, size));

        List<GlucoseLogResponse> responseContent = result.content().stream()
                .map(log -> new GlucoseLogResponse()
                        .id(log.id())
                        .timestamp(log.timestamp())
                        .value(log.value())
                        .source(log.source())
                ).toList();

        GlucoseLogPageResponse response = new GlucoseLogPageResponse()
                .content(responseContent)
                .totalElements(result.totalElements())
                .pageNumber(result.pageNumber());

        return ResponseEntity.ok(response);
    }
}
