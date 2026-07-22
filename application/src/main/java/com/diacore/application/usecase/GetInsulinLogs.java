package com.diacore.application.usecase;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.log.model.InsulinLog;

public interface GetInsulinLogs extends UseCase<GetInsulinLogs.Request, PageResult<InsulinLog>> {
    record Request(
            int page,
            int size
    ) {}
}
