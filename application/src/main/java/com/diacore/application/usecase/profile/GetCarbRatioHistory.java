package com.diacore.application.usecase.profile;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.profile.model.CarbRatioHistory;

public interface GetCarbRatioHistory extends UseCase<GetCarbRatioHistory.Request, PageResult<CarbRatioHistory>> {
    record Request(
            int page,
            int size
    ) {
    }
}
