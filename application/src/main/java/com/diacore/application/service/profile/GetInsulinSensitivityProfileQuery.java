package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.GetInsulinSensitivityProfile;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.InsulinSensitivityProfile;
import com.diacore.domain.profile.port.out.LoadInsulinSensitivityProfilePort;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetInsulinSensitivityProfileQuery implements GetInsulinSensitivityProfile {
    private final LoadInsulinSensitivityProfilePort loadInsulinSensitivityProfilePort;

    public GetInsulinSensitivityProfileQuery(LoadInsulinSensitivityProfilePort loadInsulinSensitivityProfilePort) {
        this.loadInsulinSensitivityProfilePort = loadInsulinSensitivityProfilePort;
    }

    @Override
    public InsulinSensitivityProfile execute(Actor actor, Request request) {
        return loadInsulinSensitivityProfilePort.loadByUserId(actor.userId())
                .orElseGet(() -> InsulinSensitivityProfile.create(actor.userId(), List.of()));
    }
}
