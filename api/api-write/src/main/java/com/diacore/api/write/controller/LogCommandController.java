package com.diacore.api.write.controller;

import com.diacore.api.model.CreatedResponse;
import com.diacore.api.model.GlucoseLogRequest;
import com.diacore.api.model.InsulinLogRequest;
import com.diacore.api.model.MealLogRequest;
import com.diacore.api.operation.LogCommandApi;
import com.diacore.application.usecase.log.RegisterGlucoseLog;
import com.diacore.application.usecase.log.RegisterInsulinLog;
import com.diacore.application.usecase.log.RegisterMealLog;
import com.diacore.infrastructure.actor.ActorSelector;
import java.time.OffsetDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LogCommandController implements LogCommandApi {
    private final RegisterGlucoseLog registerGlucoseLog;
    private final RegisterInsulinLog registerInsulinLog;
    private final RegisterMealLog registerMealLog;

    public LogCommandController(RegisterGlucoseLog registerGlucoseLog, RegisterInsulinLog registerInsulinLog,
                                RegisterMealLog registerMealLog) {
        this.registerGlucoseLog = registerGlucoseLog;
        this.registerInsulinLog = registerInsulinLog;
        this.registerMealLog = registerMealLog;
    }

    @Override
    public ResponseEntity<CreatedResponse> createGlucoseLog(GlucoseLogRequest request) {
        Long savedId = ActorSelector.current()
                .requestTo(registerGlucoseLog)
                .by(new RegisterGlucoseLog.Request(
                        request.getTimestamp(),
                        request.getValue(),
                        request.getTrendArrow(),
                        request.getSource()
                ));

        CreatedResponse response = new CreatedResponse()
                .id(savedId)
                .createdAt(OffsetDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<CreatedResponse> createInsulinLog(InsulinLogRequest request) {
        Long savedId = ActorSelector.current()
                .requestTo(registerInsulinLog)
                .by(new RegisterInsulinLog.Request(
                        request.getTimestamp(),
                        request.getDose(),
                        request.getInsulinType()
                ));

        CreatedResponse response = new CreatedResponse()
                .id(savedId)
                .createdAt(OffsetDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<CreatedResponse> createMealLog(MealLogRequest request) {
        Long savedId = ActorSelector.current()
                .requestTo(registerMealLog)
                .by(new RegisterMealLog.Request(
                        request.getTimestamp(),
                        request.getCarbohydrateG(),
                        request.getMealType(),
                        request.getFoodDesc()
                ));

        CreatedResponse response = new CreatedResponse()
                .id(savedId)
                .createdAt(OffsetDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
