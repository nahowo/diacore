package com.diacore.domain.profile.model;


import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record InsulinSensitivityProfile(
        Long userId,
        List<InsulinSensitivitySegment> segments,
        OffsetDateTime timestamp
) {
    public InsulinSensitivityProfile {
        validateSegments(segments);

        segments = segments.stream()
                .sorted(Comparator.comparing(InsulinSensitivitySegment::startTime))
                .toList();
    }

    public static InsulinSensitivityProfile create(Long userId, List<InsulinSensitivitySegment> segments) {
        return new InsulinSensitivityProfile(userId, segments, OffsetDateTime.now());
    }

    public Float getInsulinSensitivityForTime(int currentHour) {
        if (currentHour < 0 || currentHour > 23) {
            throw new IllegalArgumentException("시간은 0~23 사이여야 합니다.");
        }

        return segments.stream()
                .filter(seg -> seg.startTime() <= currentHour)
                .max(Comparator.comparing(InsulinSensitivitySegment::startTime))
                .map(InsulinSensitivitySegment::value)
                .orElseThrow(() -> new IllegalStateException("0시 설정이 누락되어 값을 찾을 수 없습니다."));
    }

    private void validateSegments(List<InsulinSensitivitySegment> segments) {
        if (segments == null || segments.isEmpty()) {
            throw new IllegalArgumentException("최소 하나의 인슐린 민감도 설정이 필요합니다.");
        }

        Set<Integer> startTimes = segments.stream()
                .map(InsulinSensitivitySegment::startTime)
                .collect(Collectors.toSet());

        if (startTimes.size() != segments.size()) {
            throw new IllegalArgumentException("중복된 시작 시간이 존재합니다.");
        }

        if (!startTimes.contains(0)) {
            throw new IllegalArgumentException("자정(0시) 기준의 인슐린 민감도 설정은 필수입니다.");
        }
    }

    public record InsulinSensitivitySegment(
            Long id,
            int startTime,
            Float value
    ) {
        public InsulinSensitivitySegment {
            if (startTime < 0 || startTime > 23) {
                throw new IllegalArgumentException("시작 시간은 0에서 23 사이의 정수여야 합니다.");
            }
            if (value == null || value <= 0) {
                throw new IllegalArgumentException("인슐린 민감도는 0보다 커야 합니다.");
            }
        }

        public static InsulinSensitivitySegment create(int startTime, Float value) {
            return new InsulinSensitivitySegment(null, startTime, value);
        }

        public static InsulinSensitivitySegment withId(Long id, int startTime, Float value) {
            return new InsulinSensitivitySegment(id, startTime, value);
        }
    }
}
