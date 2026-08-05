package com.diacore.domain.common.usecase;

public record Actor(
        Long userId,
        String role
) {
    public static Actor of(String role) {
        return new Actor(2L, role); // TODO
    }

    public static Actor system() {
        return new Actor(0L, "SYSTEM");
    }
}
