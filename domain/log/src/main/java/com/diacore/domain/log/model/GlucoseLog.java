package com.diacore.domain.log.model;

import java.time.OffsetDateTime;

public record GlucoseLog(
        Long id,
        Long userId,
        OffsetDateTime timestamp,
        int value,
        String trendArrow,
        String source
) {
    public GlucoseLog {
        if (value <= 0) {
            throw new IllegalArgumentException("혈당값은 0을 초과해야 합니다.");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("timestamp 값은 비어있을 수 없습니다.");
        }
    }

    public static GlucoseLog create(Long userId, OffsetDateTime timestamp, int value, String trendArrow,
                                    String source) {
        return new GlucoseLog(null, userId, timestamp, value, trendArrow, source);
    }

    public static GlucoseLog withId(Long id, Long userId, OffsetDateTime timestamp, int value, String trendArrow,
                                    String source) {
        return new GlucoseLog(id, userId, timestamp, value, trendArrow, source);
    }
}
