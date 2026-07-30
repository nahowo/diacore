package com.diacore.domain.profile.port.out;

import com.diacore.domain.profile.model.BasalProfile;
import java.util.Optional;

public interface LoadBasalProfilePort {
    Optional<BasalProfile> loadByUserId(Long userId);
}
