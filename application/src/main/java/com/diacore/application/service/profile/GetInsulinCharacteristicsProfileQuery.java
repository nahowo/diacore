package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.GetInsulinCharacteristicsProfile;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.InsulinCharacteristicsProfile;
import com.diacore.domain.profile.port.out.LoadInsulinCharacteristicsProfilePort;
import com.diacore.exception.BusinessException;
import com.diacore.exception.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetInsulinCharacteristicsProfileQuery implements GetInsulinCharacteristicsProfile {
    private final LoadInsulinCharacteristicsProfilePort loadInsulinCharacteristicsProfilePort;

    public GetInsulinCharacteristicsProfileQuery(
            LoadInsulinCharacteristicsProfilePort loadInsulinCharacteristicsProfilePort) {
        this.loadInsulinCharacteristicsProfilePort = loadInsulinCharacteristicsProfilePort;
    }

    @Override
    public InsulinCharacteristicsProfile execute(Actor actor, Request request) {
        return loadInsulinCharacteristicsProfilePort.loadByUserId(actor.userId())
                .orElseThrow(() -> new BusinessException(ErrorCode.THERAPY_IC_NOT_FOUND));
    }
}
