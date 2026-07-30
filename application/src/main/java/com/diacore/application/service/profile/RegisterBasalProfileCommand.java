package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.RegisterBasalProfile;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.BasalProfile;
import com.diacore.domain.profile.port.out.SaveBasalProfilePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterBasalProfileCommand implements RegisterBasalProfile {
    private final SaveBasalProfilePort saveBasalProfilePort;

    public RegisterBasalProfileCommand(SaveBasalProfilePort saveBasalProfilePort) {
        this.saveBasalProfilePort = saveBasalProfilePort;
    }

    @Override
    public Long execute(Actor actor, Request request) {
        BasalProfile basalProfile = BasalProfile.create(
                actor.userId(),
                request.dailyBasalUnits(),
                request.insulinName()
        );

        BasalProfile savedProfile = saveBasalProfilePort.save(basalProfile);

        return savedProfile.id();
    }
}

