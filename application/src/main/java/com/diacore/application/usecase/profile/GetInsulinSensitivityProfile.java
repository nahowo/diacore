package com.diacore.application.usecase.profile;

import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.profile.model.InsulinSensitivityProfile;

public interface GetInsulinSensitivityProfile extends UseCase<GetInsulinSensitivityProfile.Request, InsulinSensitivityProfile> {
    record Request() {}
}
