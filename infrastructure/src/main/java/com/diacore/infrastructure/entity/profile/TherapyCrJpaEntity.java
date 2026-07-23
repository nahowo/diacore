package com.diacore.infrastructure.entity.profile;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "therapy_cr", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_cr_time", columnNames = {"user_id", "start_time"})
})
public class TherapyCrJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "start_time", nullable = false)
    private Integer startTime; // 0 ~ 23

    @Column(name = "carb_ratio", nullable = false)
    private Float carbRatio;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime timestamp;

    protected TherapyCrJpaEntity() {}

    public TherapyCrJpaEntity(Long userId, Integer startTime, Float carbRatio) {
        this.userId = userId;
        this.startTime = startTime;
        this.carbRatio = carbRatio;
        this.timestamp = OffsetDateTime.now();
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Integer getStartTime() { return startTime; }
    public Float getCarbRatio() { return carbRatio; }
    public OffsetDateTime getTimestamp() { return timestamp; }
}
