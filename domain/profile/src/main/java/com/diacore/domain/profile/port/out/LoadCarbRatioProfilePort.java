package com.diacore.domain.profile.port.out;

import com.diacore.domain.profile.model.CarbRatioProfile;
import java.util.Optional;

public interface LoadCarbRatioProfilePort {
    Optional<CarbRatioProfile> loadByUserId(Long userId);
}
