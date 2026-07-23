package com.diacore.domain.profile.model;

import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record CarbRatioProfile(
        Long userId,
        List<CarbRatioSegment> segments,
        OffsetDateTime timestamp
) {
    public CarbRatioProfile {
        validateSegments(segments);

        segments = segments.stream()
                .sorted(Comparator.comparing(CarbRatioSegment::startTime))
                .toList();
    }

    public static CarbRatioProfile create(Long userId, List<CarbRatioSegment> segments) {
        return new CarbRatioProfile(userId, segments, OffsetDateTime.now());
    }

    public static CarbRatioProfile withId(Long userId, List<CarbRatioSegment> segments, OffsetDateTime updatedAt) {
        return new CarbRatioProfile(userId, segments, updatedAt);
    }

    public Float getRatioForTime(int currentHour) {
        if (currentHour < 0 || currentHour > 23) {
            throw new IllegalArgumentException("시간은 0~23 사이여야 합니다.");
        }

        return segments.stream()
                .filter(seg -> seg.startTime() <= currentHour)
                .max(Comparator.comparing(CarbRatioSegment::startTime))
                .map(CarbRatioSegment::value)
                .orElseThrow(() -> new IllegalStateException("0시 설정이 누락되어 값을 찾을 수 없습니다."));
    }

    private void validateSegments(List<CarbRatioSegment> segments) {
        if (segments == null || segments.isEmpty()) {
            throw new IllegalArgumentException("최소 하나의 탄수비 설정이 필요합니다.");
        }

        Set<Integer> startTimes = segments.stream()
                .map(CarbRatioSegment::startTime)
                .collect(Collectors.toSet());

        if (startTimes.size() != segments.size()) {
            throw new IllegalArgumentException("중복된 시작 시간이 존재합니다.");
        }

        if (!startTimes.contains(0)) {
            throw new IllegalArgumentException("자정(0시) 기준의 탄수비 설정은 필수입니다.");
        }
    }

    public record CarbRatioSegment(
            Long id,
            int startTime,
            Float value
    ) {
        public CarbRatioSegment {
            if (startTime < 0 || startTime > 23) {
                throw new IllegalArgumentException("시작 시간은 0에서 23 사이의 정수여야 합니다.");
            }
            if (value == null || value <= 0) {
                throw new IllegalArgumentException("탄수비는 0보다 커야 합니다.");
            }
        }

        public static CarbRatioSegment create(int startTime, Float value) {
            return new CarbRatioSegment(null, startTime, value);
        }

        public static CarbRatioSegment withId(Long id, int startTime, Float value) {
            return new CarbRatioSegment(id, startTime, value);
        }
    }
}
