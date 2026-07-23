package com.diacore.application.service.log;

import com.diacore.application.usecase.log.GetMealLogs;
import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.log.model.MealLog;
import com.diacore.domain.log.port.out.LoadMealPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetMealLogsQuery implements GetMealLogs {
    private final LoadMealPort loadMealPort;

    public GetMealLogsQuery(LoadMealPort loadMealPort) {
        this.loadMealPort = loadMealPort;
    }

    @Override
    public PageResult<MealLog> execute(Actor actor, Request request) {
        return loadMealPort.loadByUserId(actor.userId(), request.page(), request.size());
    }
}
