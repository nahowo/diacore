package com.diacore.domain.profile.model;

import com.diacore.domain.profile.model.CarbRatioProfile.CarbRatioSegment;
import java.time.OffsetDateTime;
import java.util.List;

public record CarbRatioHistory(
        Long id,
        Long userId,
        List<CarbRatioSegment> snapshotSegments,
        ChangeSource changeSource,
        String reasonText,
        OffsetDateTime createdAt
) {
    public CarbRatioHistory {
        if (userId == null) throw new IllegalArgumentException("사용자 ID는 필수입니다.");
        if (snapshotSegments == null || snapshotSegments.isEmpty()) {
            throw new IllegalArgumentException("스냅샷 세그먼트 데이터는 필수입니다.");
        }
        if (changeSource == null) throw new IllegalArgumentException("변경 출처는 필수입니다.");
        if (createdAt == null) throw new IllegalArgumentException("생성 일시는 필수입니다.");
    }

    public static CarbRatioHistory create(
            Long userId,
            List<CarbRatioSegment> snapshotSegments,
            ChangeSource changeSource,
            String reasonText
    ) {
        return new CarbRatioHistory(
                null, userId, snapshotSegments, changeSource, reasonText, OffsetDateTime.now()
        );
    }

    public static CarbRatioHistory withId(
            Long id, Long userId, List<CarbRatioSegment> snapshotSegments,
            ChangeSource changeSource, String reasonText, OffsetDateTime createdAt
    ) {
        return new CarbRatioHistory(
                id, userId, snapshotSegments, changeSource, reasonText, createdAt
        );
    }
}
