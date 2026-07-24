package com.diacore.domain.profile.port.out;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.profile.model.CarbRatioHistory;

public interface LoadCarbRatioHistoryPort {
    PageResult<CarbRatioHistory> loadByUserId(Long userId, int page, int size);
}
