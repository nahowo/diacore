package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.RegisterInsulinSensitivityHistory;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.InsulinSensitivityHistory;
import com.diacore.domain.profile.model.InsulinSensitivityProfile.InsulinSensitivitySegment;
import com.diacore.domain.profile.port.out.SaveInsulinSensitivityHistoryPort;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterInsulinSensitivityHistoryCommand implements RegisterInsulinSensitivityHistory {
    private final SaveInsulinSensitivityHistoryPort saveInsulinSensitivityHistoryPort;

    public RegisterInsulinSensitivityHistoryCommand(SaveInsulinSensitivityHistoryPort saveInsulinSensitivityHistoryPort) {
        this.saveInsulinSensitivityHistoryPort = saveInsulinSensitivityHistoryPort;
    }

    @Override
    public Long execute(Actor actor, Request request) {
        List<InsulinSensitivitySegment> snapshotSegments = request.segments().stream()
                .map(seg -> InsulinSensitivitySegment.create(seg.startTime(), seg.value()))
                .toList();
        InsulinSensitivityHistory insulinSensitivityHistory = InsulinSensitivityHistory.create(
                actor.userId(),
                snapshotSegments,
                request.changeSource(),
                request.reasonText()
        );

        InsulinSensitivityHistory savedHistory = saveInsulinSensitivityHistoryPort.save(insulinSensitivityHistory);

        return savedHistory.id();
    }
}
