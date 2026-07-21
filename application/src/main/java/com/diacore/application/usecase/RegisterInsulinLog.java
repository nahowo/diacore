package com.diacore.application.usecase;

import com.diacore.domain.common.usecase.UseCase;
import java.time.OffsetDateTime;

public interface RegisterInsulinLog extends UseCase<RegisterInsulinLog.Request, Long> {
    record Request(
            OffsetDateTime timestamp,
            Float dose,
            String type
    ) {}
}