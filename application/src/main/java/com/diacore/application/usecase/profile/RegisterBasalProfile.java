package com.diacore.application.usecase.profile;

import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.profile.model.BasalInsulinName;

public interface RegisterBasalProfile extends UseCase<RegisterBasalProfile.Request, Long> {
    record Request(
            Float dailyBasalUnits,
            BasalInsulinName insulinName
    ) {}
}
