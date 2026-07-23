package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.GetCarbRatioProfile;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.CarbRatioProfile;
import com.diacore.domain.profile.port.out.LoadCarbRatioProfilePort;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetCarbRatioProfileQuery implements GetCarbRatioProfile {
    private final LoadCarbRatioProfilePort loadCarbRatioProfilePort;

    public GetCarbRatioProfileQuery(LoadCarbRatioProfilePort loadCarbRatioProfilePort) {
        this.loadCarbRatioProfilePort = loadCarbRatioProfilePort;
    }

    @Override
    public CarbRatioProfile execute(Actor actor, Request request) {
        return loadCarbRatioProfilePort.loadByUserId(actor.userId())
                .orElseGet(() -> CarbRatioProfile.create(actor.userId(), List.of()));
    }
}
