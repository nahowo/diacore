package com.diacore.infrastructure.entity.profile;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "therapy_isf", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_isf_time", columnNames = {"user_id", "start_time"})
})
public class TherapyIsfJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "start_time", nullable = false)
    private Integer startTime;

    @Column(name = "insulin_sensitivity", nullable = false)
    private Float insulinSensitivity;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime timestamp;

    protected TherapyIsfJpaEntity() {}

    public TherapyIsfJpaEntity(Long userId, Integer startTime, Float insulinSensitivity) {
        this.userId = userId;
        this.startTime = startTime;
        this.insulinSensitivity = insulinSensitivity;
        this.timestamp = OffsetDateTime.now();
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Integer getStartTime() { return startTime; }
    public Float getInsulinSensitivity() { return insulinSensitivity; }
    public OffsetDateTime getTimestamp() { return timestamp; }
}
