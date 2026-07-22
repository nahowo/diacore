package com.diacore.application.usecase;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.log.model.GlucoseLog;

public interface GetGlucoseLogs extends UseCase<GetGlucoseLogs.Request, PageResult<GlucoseLog>> {
    record Request(
            int page,
            int size
    ) {}
}
