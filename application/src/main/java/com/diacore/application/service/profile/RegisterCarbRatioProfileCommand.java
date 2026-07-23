package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.RegisterCarbRatioProfile;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.CarbRatioProfile;
import com.diacore.domain.profile.model.CarbRatioProfile.CarbRatioSegment;
import com.diacore.domain.profile.port.out.SaveCarbRatioProfilePort;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterCarbRatioProfileCommand implements RegisterCarbRatioProfile {
    private final SaveCarbRatioProfilePort saveCarbRatioProfilePort;

    public RegisterCarbRatioProfileCommand(SaveCarbRatioProfilePort saveCarbRatioProfilePort) {
        this.saveCarbRatioProfilePort = saveCarbRatioProfilePort;
    }

    @Override
    public Void execute(Actor actor, Request request) {
        List<CarbRatioSegment> segments = request.segments().stream()
                .map(seg -> CarbRatioProfile.CarbRatioSegment.create(
                        seg.startTime(),
                        seg.value()
                )).toList();

        CarbRatioProfile carbRatioProfile = CarbRatioProfile.create(actor.userId(), segments);

        saveCarbRatioProfilePort.save(carbRatioProfile);
        return null;
    }
}
