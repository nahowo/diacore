package com.diacore.application.usecase.profile;

import com.diacore.domain.common.usecase.UseCase;
import java.time.OffsetDateTime;

public interface RegisterInsulinCharacteristicsProfile extends UseCase<RegisterInsulinCharacteristicsProfile.Request, Long> {
    record Request(
            Float diaHours,
            Integer peakMinutes
    ) {}
}
