package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.RegisterInsulinSensitivityProfile;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.InsulinSensitivityProfile;
import com.diacore.domain.profile.model.InsulinSensitivityProfile.InsulinSensitivitySegment;
import com.diacore.domain.profile.port.out.SaveInsulinSensitivityProfilePort;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterInsulinSensitivityProfileCommand implements RegisterInsulinSensitivityProfile {
    private final SaveInsulinSensitivityProfilePort saveInsulinSensitivityProfilePort;

    public RegisterInsulinSensitivityProfileCommand(SaveInsulinSensitivityProfilePort saveInsulinSensitivityProfilePort) {
        this.saveInsulinSensitivityProfilePort = saveInsulinSensitivityProfilePort;
    }

    @Override
    public Void execute(Actor actor, Request request) {
        List<InsulinSensitivitySegment> segments = request.segments().stream()
                .map(seg -> InsulinSensitivityProfile.InsulinSensitivitySegment.create(
                        seg.startTime(),
                        seg.value()
                )).toList();

        InsulinSensitivityProfile insulinSensitivityProfile = InsulinSensitivityProfile.create(
                actor.userId(),
                segments
        );

        saveInsulinSensitivityProfilePort.save(insulinSensitivityProfile);
        return null;
    }
}
