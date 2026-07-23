package com.diacore.application.service.log;

import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.log.model.InsulinLog;
import com.diacore.domain.log.port.out.SaveInsulinLogPort;
import com.diacore.application.usecase.log.RegisterInsulinLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterInsulinLogCommand implements RegisterInsulinLog {
    private final SaveInsulinLogPort saveInsulinLogPort;

    public RegisterInsulinLogCommand(SaveInsulinLogPort saveInsulinLogPort) {
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

        return savedLog.id();
    }
}
