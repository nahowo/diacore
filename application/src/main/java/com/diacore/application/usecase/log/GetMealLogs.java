package com.diacore.application.usecase.log;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.log.model.MealLog;

public interface GetMealLogs extends UseCase<GetMealLogs.Request, PageResult<MealLog>> {
    record Request(
            int page,
            int size
    ) {}
}
