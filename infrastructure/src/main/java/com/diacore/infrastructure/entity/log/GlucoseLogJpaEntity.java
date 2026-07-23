package com.diacore.infrastructure.entity.log;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "glucose_logs")
public class GlucoseLogJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "timestamp", nullable = false)
    private OffsetDateTime timestamp;

    @Column(name = "value", nullable = false)
    private int value;

    @Column(name = "trend_arrow", nullable = false)
    private String trendArrow;

    @Column(name = "source", nullable = true)
    private String source;

    protected GlucoseLogJpaEntity() {}

    public GlucoseLogJpaEntity(Long id, Long userId, OffsetDateTime timestamp, int value, String trendArrow, String source) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.value = value;
        this.trendArrow = trendArrow;
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public int getValue() {
        return value;
    }

    public String getTrendArrow() {
        return trendArrow;
    }

    public String getSource() {
        return source;
    }
}
