package com.diacore.application.service;

import com.diacore.application.usecase.GetGlucoseLogs;
import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.log.model.GlucoseLog;
import com.diacore.domain.log.port.out.LoadGlucosePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetGlucoseLogsQuery implements GetGlucoseLogs {
    private final LoadGlucosePort loadGlucosePort;

    public GetGlucoseLogsQuery(LoadGlucosePort loadGlucosePort) {
        this.loadGlucosePort = loadGlucosePort;
    }

    @Override
    public PageResult<GlucoseLog> execute(Actor actor, Request request) {
        return loadGlucosePort.loadByUserId(actor.userId(), request.page(), request.size());
    }
}
