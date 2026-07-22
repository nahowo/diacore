package com.diacore.application.service;

import com.diacore.application.usecase.RegisterGlucoseLog;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.log.model.GlucoseLog;
import com.diacore.domain.log.port.out.SaveGlucoseLogPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterGlucoseCommand implements RegisterGlucoseLog {
    private final SaveGlucoseLogPort saveGlucoseLogPort;

    public RegisterGlucoseCommand(SaveGlucoseLogPort saveGlucoseLogPort) {
        this.saveGlucoseLogPort = saveGlucoseLogPort;
    }

    @Override
    @Transactional
    public Long execute(Actor actor, Request request) {
        GlucoseLog glucoseLog = GlucoseLog.create(
                actor.userId(),
                request.timestamp(),
                request.value(),
                request.trendArrow(),
                request.source()
        );

        GlucoseLog savedLog = saveGlucoseLogPort.save(glucoseLog);

        return savedLog.getId();
    }
}
