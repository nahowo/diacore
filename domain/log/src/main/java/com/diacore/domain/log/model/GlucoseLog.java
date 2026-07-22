package com.diacore.domain.log.model;

import java.time.OffsetDateTime;

public class GlucoseLog {
    private Long id;
    private final Long userId;
    private final OffsetDateTime timestamp;
    private final int value;
    private final String trendArrow;
    private final String source;

    private GlucoseLog(Long id, Long userId, OffsetDateTime timestamp, int value, String trendArrow, String source) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.value = value;
        this.trendArrow = trendArrow;
        this.source = source;
    }

    public static GlucoseLog create(Long userId, OffsetDateTime timestamp, int value, String trendArrow,
                                    String source) {
        if (value <= 0) {
            throw new IllegalArgumentException("Glucose must be over 0.");
        }
        return new GlucoseLog(null, userId, timestamp, value, trendArrow, source);
    }

    public static GlucoseLog withId(Long id, Long userId, OffsetDateTime timestamp, int value, String trendArrow,
                                    String source) {
        return new GlucoseLog(id, userId, timestamp, value, trendArrow, source);
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public int getValue() {
        return value;
    }

    public String getTrendArrow() {
        return trendArrow;
    }

    public String getSource() {
        return source;
    }
}
