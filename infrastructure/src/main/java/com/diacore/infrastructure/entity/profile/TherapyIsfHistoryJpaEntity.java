package com.diacore.infrastructure.entity.profile;

import com.diacore.domain.profile.model.ChangeSource;
import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "therapy_isf_history", indexes = {
        @Index(name = "idx_isf_history_user_id", columnList = "user_id")
})
public class TherapyIsfHistoryJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "profile_snapshot", nullable = false, columnDefinition = "json")
    private String profileSnapshotJson;

    @Enumerated(EnumType.STRING)
    @Column(name = "change_source", nullable = false, length = 30)
    private ChangeSource changeSource;

    @Column(name = "reason_text", length = 255)
    private String reasonText;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    protected TherapyIsfHistoryJpaEntity() {}

    public TherapyIsfHistoryJpaEntity(Long userId, String profileSnapshotJson,
                                      ChangeSource changeSource, String reasonText) {
        this.userId = userId;
        this.profileSnapshotJson = profileSnapshotJson;
        this.changeSource = changeSource != null ? changeSource : ChangeSource.MANUAL;
        this.reasonText = reasonText;
        this.createdAt = OffsetDateTime.now();
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getProfileSnapshotJson() { return profileSnapshotJson; }
    public ChangeSource getChangeSource() { return changeSource; }
    public String getReasonText() { return reasonText; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
}
