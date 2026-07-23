package com.diacore.domain.profile.port.out;

import com.diacore.domain.profile.model.InsulinSensitivityProfile;

public interface SaveInsulinSensitivityProfilePort {
    InsulinSensitivityProfile save(InsulinSensitivityProfile insulinSensitivityProfile);
}
