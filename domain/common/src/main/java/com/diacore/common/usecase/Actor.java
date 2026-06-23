package com.diacore.common.usecase;

public record Actor(
        Long userId,
        String role
) {
    public static Actor of(Long userId, String role) {
        return new Actor(userId, role);
    }

    public static Actor system() {
        return new Actor(0L, "SYSTEM");
    }
}
