package com.diacore.infrastructure.actor;

import com.diacore.domain.common.usecase.Actor;

public class ActorUtil {
    public static Actor getCurrentActor() {
        return Actor.of("");
    }
}
