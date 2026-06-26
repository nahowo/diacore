package com.diacore.write.controller;

import com.diacore.api.model.CommonResponse;
import com.diacore.api.model.GlucoseLogRequest;
import com.diacore.common.usecase.Actor;
import com.diacore.log.usecase.RegisterGlucoseLog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
public class LogController {
    private final RegisterGlucoseLog registerGlucoseLog;

    public LogController(RegisterGlucoseLog registerGlucoseLog) {
        this.registerGlucoseLog = registerGlucoseLog;
    }

    public ResponseEntity<CommonResponse> registerGlucoseLog(Long xUserId, GlucoseLogRequest request) {
        Actor actor = new Actor(xUserId, "");

        RegisterGlucoseLog.Request command = new RegisterGlucoseLog.Request(
                request.getTimestamp().toLocalDateTime(),
                request.getValue(),
                request.getTrendArrow()
        );

        Long savedId = registerGlucoseLog.execute(actor, command);

        CommonResponse response = new CommonResponse()
                .id(savedId)
                .status("SUCCESS");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
