package com.diacore.infrastructure.adapter;

import com.diacore.domain.log.model.GlucoseLog;
import com.diacore.domain.log.port.out.SaveGlucoseLogPort;
import com.diacore.infrastructure.adapter.repository.GlucoseLogJpaRepository;
import com.diacore.infrastructure.entity.GlucoseLogJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class GlucoseLogAdapter implements SaveGlucoseLogPort {
    private final GlucoseLogJpaRepository repository;

    public GlucoseLogAdapter(GlucoseLogJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public GlucoseLog save(GlucoseLog glucoseLog) {
        GlucoseLogJpaEntity entity = new GlucoseLogJpaEntity(
                glucoseLog.getId(),
                glucoseLog.getUserId(),
                glucoseLog.getTimestamp(),
                glucoseLog.getValue(),
                glucoseLog.getTrendArrow(),
                glucoseLog.getSource()
        );

        GlucoseLogJpaEntity savedEntity = repository.save(entity);

        return GlucoseLog.withId(
                savedEntity.getId(),
                savedEntity.getUserId(),
                savedEntity.getTimestamp(),
                savedEntity.getValue(),
                savedEntity.getTrendArrow(),
                savedEntity.getSource()
        );
    }
}
