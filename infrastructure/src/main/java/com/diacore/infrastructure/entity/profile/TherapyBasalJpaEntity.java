package com.diacore.infrastructure.entity.profile;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "therapy_basal", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_basal", columnNames = {"user_id"})
})
public class TherapyBasalJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "daily_basal_units", nullable = false)
    private Float dailyBasalUnits;

    @Column(name = "insulin_name", nullable = false, length = 100)
    private String insulinName;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime timestamp;

    protected TherapyBasalJpaEntity() {}

    public TherapyBasalJpaEntity(Long userId, Float dailyBasalUnits, String insulinName) {
        this.userId = userId;
        this.dailyBasalUnits = dailyBasalUnits;
        this.insulinName = insulinName;
        this.timestamp = OffsetDateTime.now();
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Float getDailyBasalUnits() { return dailyBasalUnits; }
    public String getInsulinName() { return insulinName; }
    public OffsetDateTime getTimestamp() { return timestamp; }
}
