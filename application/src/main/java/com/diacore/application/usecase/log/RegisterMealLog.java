package com.diacore.application.usecase.log;

import com.diacore.domain.common.usecase.UseCase;
import java.time.OffsetDateTime;

public interface RegisterMealLog extends UseCase<RegisterMealLog.Request, Long> {
    record Request(
            OffsetDateTime timestamp,
            Float carbohydrateG,
            String mealType,
            String foodDesc
    ) {}
}
