package com.diacore.application.service.profile;

import com.diacore.application.usecase.profile.RegisterCarbRatioHistory;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.profile.model.CarbRatioHistory;
import com.diacore.domain.profile.model.CarbRatioProfile.CarbRatioSegment;
import com.diacore.domain.profile.port.out.SaveCarbRatioHistoryPort;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterCarbRatioHistoryCommand implements RegisterCarbRatioHistory {
    private final SaveCarbRatioHistoryPort saveCarbRatioHistoryPort;

    public RegisterCarbRatioHistoryCommand(SaveCarbRatioHistoryPort saveCarbRatioHistoryPort) {
        this.saveCarbRatioHistoryPort = saveCarbRatioHistoryPort;
    }

    @Override
    public Long execute(Actor actor, Request request) {
        List<CarbRatioSegment> snapshotSegments = request.segments().stream()
                .map(seg -> CarbRatioSegment.create(seg.startTime(), seg.value()))
                .toList();
        CarbRatioHistory carbRatioHistory = CarbRatioHistory.create(
                actor.userId(),
                snapshotSegments,
                request.changeSource(),
                request.reasonText()
        );

        CarbRatioHistory savedHistory = saveCarbRatioHistoryPort.save(carbRatioHistory);

        return savedHistory.id();
    }
}
