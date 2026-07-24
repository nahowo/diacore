package com.diacore.domain.profile.port.out;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.profile.model.InsulinSensitivityHistory;

public interface LoadInsulinSensitivityHistoryPort {
    PageResult<InsulinSensitivityHistory> loadByUserId(Long userId, int page, int size);
}
