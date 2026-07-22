package com.diacore.domain.log.model;

import java.time.OffsetDateTime;

public class InsulinLog {
    private Long id;
    private final Long userId;
    private final OffsetDateTime timestamp;
    private final Float dose;
    private final String type;

    private InsulinLog(Long id, Long userId, OffsetDateTime timestamp, Float dose, String type) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.dose = dose;
        this.type = type;
    }

    public static InsulinLog create(Long userId, OffsetDateTime timestamp, Float dose, String type) {
        if (dose == null || dose <= 0) {
            throw new IllegalArgumentException("Insulin dose must be over 0.");
        }
        return new InsulinLog(null, userId, timestamp, dose, type);
    }

    public static InsulinLog withId(Long id, Long userId, OffsetDateTime timestamp, Float dose, String type) {
        return new InsulinLog(id, userId, timestamp, dose, type);
    }

    public Long getId() { return id; }

    public Long getUserId() { return userId; }

    public OffsetDateTime getTimestamp() { return timestamp; }

    public Float getDose() { return dose; }

    public String getType() { return type; }
}
