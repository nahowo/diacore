package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.RegisterInsulinCharacteristicsProfile;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.InsulinCharacteristicsProfile;
import com.diacore.domain.profile.port.out.SaveInsulinCharacteristicsProfilePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterInsulinCharacteristicsProfileCommand implements RegisterInsulinCharacteristicsProfile {
    private final SaveInsulinCharacteristicsProfilePort saveInsulinCharacteristicsProfilePort;

    public RegisterInsulinCharacteristicsProfileCommand(
            SaveInsulinCharacteristicsProfilePort saveInsulinCharacteristicsProfilePort) {
        this.saveInsulinCharacteristicsProfilePort = saveInsulinCharacteristicsProfilePort;
    }

    @Override
    public Long execute(Actor actor, Request request) {
        InsulinCharacteristicsProfile insulinCharacteristicsProfile = InsulinCharacteristicsProfile.create(
                actor.userId(),
                request.diaHours(),
                request.peakMinutes()
        );

        InsulinCharacteristicsProfile savedProfile = saveInsulinCharacteristicsProfilePort.save(insulinCharacteristicsProfile);

        return savedProfile.id();
    }
}
