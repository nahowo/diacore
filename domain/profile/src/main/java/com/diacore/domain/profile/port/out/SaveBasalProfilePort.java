package com.diacore.domain.profile.port.out;

import com.diacore.domain.profile.model.BasalProfile;

public interface SaveBasalProfilePort {
    BasalProfile save(BasalProfile basalProfile);
}
