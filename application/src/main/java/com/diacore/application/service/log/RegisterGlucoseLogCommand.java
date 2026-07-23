package com.diacore.application.service.log;

import com.diacore.application.usecase.log.RegisterGlucoseLog;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.log.model.GlucoseLog;
import com.diacore.domain.log.port.out.SaveGlucoseLogPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterGlucoseLogCommand implements RegisterGlucoseLog {
    private final SaveGlucoseLogPort saveGlucoseLogPort;

    public RegisterGlucoseLogCommand(SaveGlucoseLogPort saveGlucoseLogPort) {
        this.saveGlucoseLogPort = saveGlucoseLogPort;
    }

    @Override
    public Long execute(Actor actor, Request request) {
        GlucoseLog glucoseLog = GlucoseLog.create(
                actor.userId(),
                request.timestamp(),
                request.value(),
                request.trendArrow(),
                request.source()
        );

        GlucoseLog savedLog = saveGlucoseLogPort.save(glucoseLog);

        return savedLog.id();
    }
}
