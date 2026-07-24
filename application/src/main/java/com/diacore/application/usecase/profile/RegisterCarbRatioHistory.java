package com.diacore.application.usecase.profile;

import com.diacore.application.usecase.profile.RegisterCarbRatioProfile.Request.SegmentRequest;
import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.profile.model.ChangeSource;
import java.util.List;

public interface RegisterCarbRatioHistory extends UseCase<RegisterCarbRatioHistory.Request, Long> {
    record Request(
            List<SegmentRequest> segments,
            String reasonText,
            ChangeSource changeSource
    ) {}
}
