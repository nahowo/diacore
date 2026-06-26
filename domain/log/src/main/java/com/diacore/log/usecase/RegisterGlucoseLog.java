package com.diacore.log.usecase;

import com.diacore.common.usecase.EventTarget;
import com.diacore.common.usecase.UseCase;
import java.time.LocalDateTime;

public interface RegisterGlucoseLog extends UseCase<RegisterGlucoseLog.Request, Long>, EventTarget {
    record Request(
            LocalDateTime timestamp,
            Integer value,
            String trendArrow
    ) {}
}