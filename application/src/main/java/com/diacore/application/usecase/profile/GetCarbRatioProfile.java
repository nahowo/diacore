package com.diacore.application.usecase.profile;

import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.profile.model.CarbRatioProfile;

public interface GetCarbRatioProfile extends UseCase<GetCarbRatioProfile.Request, CarbRatioProfile> {
    record Request() {}
}
