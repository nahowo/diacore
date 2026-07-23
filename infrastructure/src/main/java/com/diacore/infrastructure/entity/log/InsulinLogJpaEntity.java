package com.diacore.infrastructure.entity.log;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "insulin_logs")
public class InsulinLogJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "timestamp", nullable = false)
    private OffsetDateTime timestamp;

    @Column(name = "dose", nullable = false)
    private Float dose;

    @Column(name = "insulin_type", nullable = false)
    private String type;

    protected InsulinLogJpaEntity() {}

    public InsulinLogJpaEntity(Long id, Long userId, OffsetDateTime timestamp, Float dose, String type) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.dose = dose;
        this.type = type;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public OffsetDateTime getTimestamp() { return timestamp; }
    public Float getDose() { return dose; }
    public String getType() { return type; }
}
