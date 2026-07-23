package com.diacore.application.usecase.profile;

import com.diacore.domain.common.usecase.UseCase;

public interface GetTherapyParameters extends UseCase<GetTherapyParameters.Request, GetTherapyParameters.Response> {
    record Request(
            int hour
    ) {}

    record Response(
            int hour,
            Float carbRatio,
            Float insulinSensitivity
    ) {}
}
