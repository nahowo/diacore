package com.diacore.application.usecase.profile;

import com.diacore.domain.profile.model.BasalProfile;
import java.time.OffsetDateTime;
import com.diacore.domain.common.usecase.UseCase;

public interface GetBasalProfile extends UseCase<GetBasalProfile.Request, BasalProfile>{
    record Request() {}
}
