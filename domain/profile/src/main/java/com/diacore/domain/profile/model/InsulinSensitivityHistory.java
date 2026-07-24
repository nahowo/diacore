package com.diacore.domain.profile.model;

import com.diacore.domain.profile.model.InsulinSensitivityProfile.InsulinSensitivitySegment;
import java.time.OffsetDateTime;
import java.util.List;

public record InsulinSensitivityHistory(
        Long id,
        Long userId,
        List<InsulinSensitivitySegment> snapshotSegments,
        ChangeSource changeSource,
        String reasonText,
        OffsetDateTime createdAt
) {
    public InsulinSensitivityHistory {
        if (userId == null) throw new IllegalArgumentException("사용자 ID는 필수입니다.");
        if (snapshotSegments == null || snapshotSegments.isEmpty()) {
            throw new IllegalArgumentException("스냅샷 세그먼트 데이터는 필수입니다.");
        }
        if (changeSource == null) throw new IllegalArgumentException("변경 출처는 필수입니다.");
        if (createdAt == null) throw new IllegalArgumentException("생성 일시는 필수입니다.");
    }

    public static InsulinSensitivityHistory create(
            Long userId,
            List<InsulinSensitivitySegment> snapshotSegments,
            ChangeSource changeSource,
            String reasonText
    ) {
        return new InsulinSensitivityHistory(
                null, userId, snapshotSegments, changeSource, reasonText, OffsetDateTime.now()
        );
    }

    public static InsulinSensitivityHistory withId(
            Long id, Long userId, List<InsulinSensitivitySegment> snapshotSegments,
            ChangeSource changeSource, String reasonText, OffsetDateTime createdAt
    ) {
        return new InsulinSensitivityHistory(
                id, userId, snapshotSegments, changeSource, reasonText, createdAt
        );
    }
}
