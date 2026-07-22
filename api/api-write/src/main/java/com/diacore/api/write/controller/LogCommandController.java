package com.diacore.api.write.controller;

import com.diacore.api.model.CommonResponse;
import com.diacore.api.model.CreatedResponse;
import com.diacore.api.model.GlucoseLogRequest;
import com.diacore.api.model.InsulinLogRequest;
import com.diacore.api.operation.LogCommandApi;
import com.diacore.application.usecase.RegisterGlucoseLog;
import com.diacore.application.usecase.RegisterInsulinLog;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.infrastructure.actor.ActorSelector;
import com.diacore.infrastructure.actor.ActorUtil;
import com.diacore.response.ResponseCode;
import com.diacore.response.ResponseResponse;
import java.time.OffsetDateTime;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LogCommandController implements LogCommandApi {
    private final RegisterGlucoseLog registerGlucoseLog;
    private final RegisterInsulinLog registerInsulinLog;

    public LogCommandController(RegisterGlucoseLog registerGlucoseLog, RegisterInsulinLog registerInsulinLog) {
        this.registerGlucoseLog = registerGlucoseLog;
        this.registerInsulinLog = registerInsulinLog;
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
        RegisterInsulinLog.Request command = new RegisterInsulinLog.Request(
                request.getTimestamp(),
                request.getDose(),
                request.getInsulinType()
        );

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
}
