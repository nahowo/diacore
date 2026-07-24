package com.diacore.application.usecase.profile;

import com.diacore.application.usecase.profile.RegisterInsulinSensitivityProfile.Request.SegmentRequest;
import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.profile.model.ChangeSource;
import java.util.List;

public interface RegisterInsulinSensitivityHistory extends UseCase<RegisterInsulinSensitivityHistory.Request, Long> {
    record Request(
            List<SegmentRequest> segments,
            String reasonText,
            ChangeSource changeSource
    ) {}
}
