package com.diacore.infrastructure.adapter;

import com.diacore.domain.log.model.InsulinLog;
import com.diacore.domain.log.port.out.SaveInsulinLogPort;
import com.diacore.infrastructure.adapter.repository.InsulinLogJpaRepository;
import com.diacore.infrastructure.entity.InsulinLogJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class InsulinLogAdapter implements SaveInsulinLogPort {
    private final InsulinLogJpaRepository repository;

    public InsulinLogAdapter(InsulinLogJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public InsulinLog save(InsulinLog insulinLog) {
        InsulinLogJpaEntity entity = new InsulinLogJpaEntity(
                insulinLog.getId(),
                insulinLog.getUserId(),
                insulinLog.getTimestamp(),
                insulinLog.getDose(),
                insulinLog.getType()
        );

        InsulinLogJpaEntity savedEntity = repository.save(entity);

        return InsulinLog.withId(
                savedEntity.getId(),
                savedEntity.getUserId(),
                savedEntity.getTimestamp(),
                savedEntity.getDose(),
                savedEntity.getType()
        );
    }
}
