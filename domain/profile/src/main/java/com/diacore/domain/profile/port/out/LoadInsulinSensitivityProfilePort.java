package com.diacore.domain.profile.port.out;

import com.diacore.domain.profile.model.InsulinSensitivityProfile;
import java.util.Optional;

public interface LoadInsulinSensitivityProfilePort {
    Optional<InsulinSensitivityProfile> loadByUserId(Long userId);
}
