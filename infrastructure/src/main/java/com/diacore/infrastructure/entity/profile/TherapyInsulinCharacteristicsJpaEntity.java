package com.diacore.infrastructure.entity.profile;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "therapy_insulin_characteristics", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_insulin_char", columnNames = {"user_id"})
})
public class TherapyInsulinCharacteristicsJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "dia_hours", nullable = false)
    private Float diaHours;

    @Column(name = "peak_minutes", nullable = false)
    private Integer peakMinutes;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime timestamp;

    protected TherapyInsulinCharacteristicsJpaEntity() {}

    public TherapyInsulinCharacteristicsJpaEntity(Long userId, Float diaHours, Integer peakMinutes) {
        this.userId = userId;
        this.diaHours = diaHours;
        this.peakMinutes = peakMinutes;
        this.timestamp = OffsetDateTime.now();
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Float getDiaHours() { return diaHours; }
    public Integer getPeakMinutes() { return peakMinutes; }
    public OffsetDateTime getTimestamp() { return timestamp; }
}
