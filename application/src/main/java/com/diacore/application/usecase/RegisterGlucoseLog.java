package com.diacore.application.usecase;

import com.diacore.domain.common.usecase.UseCase;
import java.time.OffsetDateTime;

public interface RegisterGlucoseLog extends UseCase<RegisterGlucoseLog.Request, Long> {
    record Request(
            OffsetDateTime timestamp,
            int value,
            String trendArrow,
            String source
    ) {}
}