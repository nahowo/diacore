package com.diacore.application.usecase.profile;

import com.diacore.domain.common.usecase.UseCase;
import java.util.List;

public interface RegisterCarbRatioProfile extends UseCase<RegisterCarbRatioProfile.Request, Void> {
    record Request(
            List<SegmentRequest> segments
    ) {
        public record SegmentRequest(
                int startTime,
                Float value
        ) {}
    }
}
