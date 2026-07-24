package com.diacore.domain.profile.port.out;

import com.diacore.domain.profile.model.InsulinSensitivityHistory;

public interface SaveInsulinSensitivityHistoryPort {
    InsulinSensitivityHistory save(InsulinSensitivityHistory insulinSensitivityHistory);
}
