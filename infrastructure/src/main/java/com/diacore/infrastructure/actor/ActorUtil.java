package com.diacore.infrastructure.actor;

import com.diacore.domain.common.usecase.Actor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class ActorUtil {
    private ActorUtil() {}

    public static Actor getCurrentActor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalArgumentException("UnAuthenticated User. ");
        }

        Long userId = (Long) authentication.getPrincipal();
        return new Actor(userId, "USER");
    }

    public static Actor anonymous() {
        return new Actor(
                null,
                "ANONYMOUS"
        );
    }
}
