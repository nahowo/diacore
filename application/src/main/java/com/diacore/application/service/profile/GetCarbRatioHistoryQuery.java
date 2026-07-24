package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.GetCarbRatioHistory;
import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.CarbRatioHistory;
import com.diacore.domain.profile.port.out.LoadCarbRatioHistoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetCarbRatioHistoryQuery implements GetCarbRatioHistory {
    private final LoadCarbRatioHistoryPort loadCarbRatioHistoryPort;

    public GetCarbRatioHistoryQuery(LoadCarbRatioHistoryPort loadCarbRatioHistoryPort) {
        this.loadCarbRatioHistoryPort = loadCarbRatioHistoryPort;
    }

    @Override
    public PageResult<CarbRatioHistory> execute(Actor actor, Request request) {
        return loadCarbRatioHistoryPort.loadByUserId(actor.userId(), request.page(), request.size());
    }
}
