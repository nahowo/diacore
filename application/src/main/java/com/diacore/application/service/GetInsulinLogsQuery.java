package com.diacore.application.service;

import com.diacore.application.usecase.GetInsulinLogs;
import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.log.model.InsulinLog;
import com.diacore.domain.log.port.out.LoadInsulinPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetInsulinLogsQuery implements GetInsulinLogs {
    private final LoadInsulinPort loadInsulinPort;

    public GetInsulinLogsQuery(LoadInsulinPort loadInsulinPort) {
        this.loadInsulinPort = loadInsulinPort;
    }

    @Override
    public PageResult<InsulinLog> execute(Actor actor, Request request) {
        return loadInsulinPort.loadByUserId(actor.userId(), request.page(), request.size());
    }
}
