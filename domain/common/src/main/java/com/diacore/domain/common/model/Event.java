package com.diacore.domain.common.model;

import com.diacore.domain.common.usecase.Actor;

public record Event<T, S>(
        String resourceName,
        String eventName,
        Actor actor,
        T request,
        S response
) {
}
