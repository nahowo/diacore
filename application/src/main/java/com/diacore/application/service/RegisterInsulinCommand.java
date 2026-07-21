package com.diacore.application.service;

import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.log.model.InsulinLog;
import com.diacore.domain.log.port.out.SaveInsulinLogPort;
import com.diacore.application.usecase.RegisterInsulinLog;
import org.springframework.stereotype.Service;

@Service
public class RegisterInsulinCommand implements RegisterInsulinLog {
    private final SaveInsulinLogPort saveInsulinLogPort;

    public RegisterInsulinCommand(SaveInsulinLogPort saveInsulinLogPort) {
        this.saveInsulinLogPort = saveInsulinLogPort;
    }

    @Override
    public Long execute(Actor actor, Request request) {
        InsulinLog insulinLog = InsulinLog.create(
                actor.userId(),
                request.timestamp(),
                request.dose(),
                request.type()
        );

        InsulinLog savedLog = saveInsulinLogPort.save(insulinLog);

        return savedLog.getId();
    }
}
