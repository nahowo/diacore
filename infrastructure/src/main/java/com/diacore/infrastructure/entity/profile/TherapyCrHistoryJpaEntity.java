package com.diacore.infrastructure.entity.profile;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "therapy_cr_history", indexes = {
        @Index(name = "idx_cr_history_user_id", columnList = "user_id")
})
public class TherapyCrHistoryJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "start_time", nullable = false)
    private Integer startTime;

    @Column(name = "original_value", nullable = false)
    private Float originalValue;

    @Column(name = "new_value", nullable = false)
    private Float newValue;

    @Column(name = "reason_text", length = 255)
    private String reasonText;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    protected TherapyCrHistoryJpaEntity() {}

    public TherapyCrHistoryJpaEntity(Long userId, Integer startTime, Float originalValue,
                                     Float newValue, String reasonText) {
        this.userId = userId;
        this.startTime = startTime;
        this.originalValue = originalValue;
        this.newValue = newValue;
        this.reasonText = reasonText;
        this.createdAt = OffsetDateTime.now();
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Integer getStartTime() { return startTime; }
    public Float getOriginalValue() { return originalValue; }
    public Float getNewValue() { return newValue; }
    public String getReasonText() { return reasonText; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
}
