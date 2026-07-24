package com.diacore.domain.profile.port.out;

import com.diacore.domain.profile.model.CarbRatioHistory;

public interface SaveCarbRatioHistoryPort {
    CarbRatioHistory save(CarbRatioHistory carbRatioHistory);
}
