package com.diacore.domain.log.model;

import java.time.OffsetDateTime;

public record InsulinLog(
        Long id,
        Long userId,
        OffsetDateTime timestamp,
        Float dose,
        String type
) {
    public InsulinLog {
        if (dose == null || dose <= 0) {
            throw new IllegalArgumentException("인슐린 주입량은 0을 초과해야 합니다.");
        }
    }

    public static InsulinLog create(Long userId, OffsetDateTime timestamp, Float dose, String type) {
        return new InsulinLog(null, userId, timestamp, dose, type);
    }

    public static InsulinLog withId(Long id, Long userId, OffsetDateTime timestamp, Float dose, String type) {
        return new InsulinLog(id, userId, timestamp, dose, type);
    }
}
