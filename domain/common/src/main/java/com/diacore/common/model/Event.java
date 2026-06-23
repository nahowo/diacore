package com.diacore.common.model;

import com.diacore.common.usecase.Actor;

public record Event<T, S>(
        String resourceName,
        String eventName,
        Actor actor,
        T request,
        S response
) {
}
