package com.diacore.application.usecase.profile;

import com.diacore.domain.common.usecase.UseCase;
import java.time.OffsetDateTime;

public interface RegisterBasalProfile extends UseCase<RegisterBasalProfile.Request, Long> {
    record Request(
            Float dailyBasalUnits,
            String insulinName
    ) {}
}
