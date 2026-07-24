package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.GetTherapyParameters;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.CarbRatioProfile;
import com.diacore.domain.profile.model.InsulinSensitivityProfile;
import com.diacore.domain.profile.port.out.LoadCarbRatioProfilePort;
import com.diacore.domain.profile.port.out.LoadInsulinSensitivityProfilePort;
import com.diacore.exception.BusinessException;
import com.diacore.exception.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetTherapyParametersQuery implements GetTherapyParameters {
    private final LoadCarbRatioProfilePort loadCarbRatioProfilePort;
    private final LoadInsulinSensitivityProfilePort loadInsulinSensitivityProfilePort;

    public GetTherapyParametersQuery(LoadCarbRatioProfilePort loadCarbRatioProfilePort,
                                     LoadInsulinSensitivityProfilePort loadInsulinSensitivityProfilePort) {
        this.loadCarbRatioProfilePort = loadCarbRatioProfilePort;
        this.loadInsulinSensitivityProfilePort = loadInsulinSensitivityProfilePort;
    }

    @Override
    public GetTherapyParameters.Response execute(Actor actor, Request request) {
        CarbRatioProfile carbRatioProfile = loadCarbRatioProfilePort.loadByUserId(actor.userId())
                .orElseThrow(() -> new BusinessException(ErrorCode.THERAPY_CR_NOT_FOUND));

        InsulinSensitivityProfile insulinSensitivityProfile = loadInsulinSensitivityProfilePort.loadByUserId(
                        actor.userId())
                .orElseThrow(() -> new BusinessException(ErrorCode.THERAPY_ISF_NOT_FOUND));

        int hour = request.hour();
        return new GetTherapyParameters.Response(
                hour,
                carbRatioProfile.getCarbRatioForTime(hour),
                insulinSensitivityProfile.getInsulinSensitivityForTime(hour)
        );
    }
}
