package com.diacore.application.usecase.profile;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.profile.model.InsulinSensitivityHistory;

public interface GetInsulinSensitivityHistory extends UseCase<GetInsulinSensitivityHistory.Request, PageResult<InsulinSensitivityHistory>> {
    record Request(
            int page,
            int size
    ) {
    }
}
