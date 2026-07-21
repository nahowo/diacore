package com.diacore.controller;

import com.diacore.api.model.CommonResponse;
import com.diacore.api.model.GlucoseLogRequest;
import com.diacore.api.model.InsulinLogRequest;
import com.diacore.api.operation.LogCommandApi;
import com.diacore.application.usecase.RegisterGlucoseLog;
import com.diacore.application.usecase.RegisterInsulinLog;
import com.diacore.domain.common.usecase.Actor;
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
    public ResponseEntity<CommonResponse> createGlucoseLog(GlucoseLogRequest request) {
        Actor actor = new Actor(1L, "");

        RegisterGlucoseLog.Request command = new RegisterGlucoseLog.Request(
                request.getTimestamp(),
                request.getValue(),
                request.getTrendArrow(),
                request.getSource()
        );

        Long savedId = registerGlucoseLog.execute(actor, command);

        CommonResponse response = new CommonResponse()
                .id(savedId)
                .status("SUCCESS");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<CommonResponse> createInsulinLog(InsulinLogRequest request) {
        Actor actor = new Actor(1L, "");

        RegisterInsulinLog.Request command = new RegisterInsulinLog.Request(
                request.getTimestamp(),
                request.getDose(),
                request.getInsulinType()
        );

        Long savedId = registerInsulinLog.execute(actor, command);

        CommonResponse response = new CommonResponse()
                .id(savedId)
                .status("SUCCESS");
        return ResponseEntity.ok(response);
    }
}
