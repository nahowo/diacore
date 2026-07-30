package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.GetBasalProfile;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.BasalProfile;
import com.diacore.domain.profile.port.out.LoadBasalProfilePort;
import com.diacore.exception.BusinessException;
import com.diacore.exception.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetBasalProfileQuery implements GetBasalProfile {
    private final LoadBasalProfilePort loadBasalProfilePort;

    public GetBasalProfileQuery(LoadBasalProfilePort loadBasalProfilePort) {
        this.loadBasalProfilePort = loadBasalProfilePort;
    }

    @Override
    public BasalProfile execute(Actor actor, Request request) {
        return loadBasalProfilePort.loadByUserId(actor.userId())
                .orElseThrow(() -> new BusinessException(ErrorCode.THERAPY_BASAL_NOT_FOUND));


    }
}
