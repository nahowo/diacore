package com.diacore.application.usecase.profile;

import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.profile.model.InsulinCharacteristicsProfile;
import java.time.OffsetDateTime;

public interface GetInsulinCharacteristicsProfile extends UseCase<GetInsulinCharacteristicsProfile.Request, InsulinCharacteristicsProfile> {
    record Request() {}
}
