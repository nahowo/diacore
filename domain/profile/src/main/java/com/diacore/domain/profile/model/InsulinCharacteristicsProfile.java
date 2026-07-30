package com.diacore.domain.profile.model;

import java.time.OffsetDateTime;

public record InsulinCharacteristicsProfile(
        Long id,
        Long userId,
        Float diaHours,
        Integer peakMinutes,
        OffsetDateTime timestamp
) {
    public InsulinCharacteristicsProfile {
        validate(userId, diaHours, peakMinutes, timestamp);
    }

    public static InsulinCharacteristicsProfile create(Long userId, Float diaHours, Integer peakMinutes) {
        return new InsulinCharacteristicsProfile(null, userId, diaHours, peakMinutes, OffsetDateTime.now());
    }

    public static InsulinCharacteristicsProfile withId(Long id, Long userId, Float diaHours, Integer peakMinutes) {
        return new InsulinCharacteristicsProfile(id, userId, diaHours, peakMinutes, OffsetDateTime.now());
    }

    private void validate(Long userId, Float diaHours, Integer peakMinutes, OffsetDateTime timestamp) {
        if (userId == null) {
            throw new IllegalArgumentException("userId는 필수입니다.");
        }
        if (diaHours == null || diaHours <= 0) {
            throw new IllegalArgumentException("인슐린 지속 시간(DIA)은 0보다 커야 합니다.");
        }
        // 의학적 상식선에서의 안전장치 (DIA는 통상적으로 2~8시간 사이)
        if (diaHours > 12.0f) {
            throw new IllegalArgumentException("인슐린 지속 시간(DIA)이 유효 범위를 벗어났습니다.");
        }

        if (peakMinutes == null || peakMinutes <= 0) {
            throw new IllegalArgumentException("인슐린 최대 작용 시점(Peak)은 0보다 커야 합니다.");
        }
        if (peakMinutes > diaHours * 60) {
            throw new IllegalArgumentException("인슐린 작용 피크(Peak) 시간이 전체 지속 시간(DIA)보다 클 수 없습니다.");
        }

        if (timestamp == null) {
            throw new IllegalArgumentException("timestamp는 필수입니다.");
        }
    }
}
