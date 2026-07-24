package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.GetInsulinSensitivityHistory;
import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.InsulinSensitivityHistory;
import com.diacore.domain.profile.port.out.LoadInsulinSensitivityHistoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetInsulinSensitivityHistoryQuery implements GetInsulinSensitivityHistory {
    private final LoadInsulinSensitivityHistoryPort loadInsulinSensitivityHistoryPort;

    public GetInsulinSensitivityHistoryQuery(LoadInsulinSensitivityHistoryPort loadInsulinSensitivityHistoryPort) {
        this.loadInsulinSensitivityHistoryPort = loadInsulinSensitivityHistoryPort;
    }

    @Override
    public PageResult<InsulinSensitivityHistory> execute(Actor actor, Request request) {
        return loadInsulinSensitivityHistoryPort.loadByUserId(actor.userId(), request.page(), request.size());
    }
}
