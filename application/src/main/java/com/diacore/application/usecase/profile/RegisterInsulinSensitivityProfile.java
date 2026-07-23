package com.diacore.application.usecase.profile;

import com.diacore.domain.common.usecase.UseCase;
import java.util.List;

public interface RegisterInsulinSensitivityProfile extends UseCase<RegisterInsulinSensitivityProfile.Request, Void> {
    record Request(
            List<SegmentRequest> segments
    ) {
        public record SegmentRequest(
                int startTime,
                Float value
        ) {
        }
    }
}
