package com.diacore.domain.common.usecase;

public record Actor(
        Long userId,
        String role
) {
    public static Actor of(String role) {
        return new Actor(1L, role);
    }

    public static Actor system() {
        return new Actor(0L, "SYSTEM");
    }
}
