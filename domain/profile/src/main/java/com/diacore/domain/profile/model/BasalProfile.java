package com.diacore.domain.profile.model;

import java.time.OffsetDateTime;

public record BasalProfile(
        Long id,
        Long userId,
        Float dailyBasalUnits,
        BasalInsulinName insulinName,
        OffsetDateTime timestamp
) {
    public BasalProfile {
        validate(userId, dailyBasalUnits, insulinName, timestamp);
    }

    public static BasalProfile create(Long userId, Float dailyBasalUnits, BasalInsulinName insulinName) {
        return new BasalProfile(null, userId, dailyBasalUnits, insulinName, OffsetDateTime.now());
    }

    public static BasalProfile withId(Long id, Long userId, Float dailyBasalUnits, BasalInsulinName insulinName) {
        return new BasalProfile(id, userId, dailyBasalUnits, insulinName, OffsetDateTime.now());
    }

    public Float getHourlyBasalRate() {
        float hourlyRate = dailyBasalUnits / 24.0f;
        return (float) (Math.round(hourlyRate * 10000.0) / 10000.0);
    }

    private void validate(Long userId, Float dailyBasalUnits, BasalInsulinName insulinName, OffsetDateTime timestamp) {
        if (userId == null) {
            throw new IllegalArgumentException("userId는 필수입니다.");
        }
        if (dailyBasalUnits == null || dailyBasalUnits <= 0) {
            throw new IllegalArgumentException("하루 총 기저 인슐린 용량(dailyBasalUnits)은 0보다 커야 합니다.");
        }
        if (insulinName == null) {
            throw new IllegalArgumentException("기저 인슐린 이름(insulinName)은 필수입니다.");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("timestamp는 필수입니다.");
        }
    }
}
