package com.diacore.infrastructure.adapter.log;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.log.model.GlucoseLog;
import com.diacore.domain.log.port.out.LoadGlucosePort;
import com.diacore.domain.log.port.out.SaveGlucoseLogPort;
import com.diacore.infrastructure.adapter.repository.log.GlucoseLogJpaRepository;
import com.diacore.infrastructure.entity.log.GlucoseLogJpaEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class GlucoseLogAdapter implements SaveGlucoseLogPort, LoadGlucosePort {
    private final GlucoseLogJpaRepository repository;

    public GlucoseLogAdapter(GlucoseLogJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public GlucoseLog save(GlucoseLog glucoseLog) {
        GlucoseLogJpaEntity entity = new GlucoseLogJpaEntity(
                glucoseLog.id(),
                glucoseLog.userId(),
                glucoseLog.timestamp(),
                glucoseLog.value(),
                glucoseLog.trendArrow(),
                glucoseLog.source()
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


    @Override
    public PageResult<GlucoseLog> loadByUserId(Long userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "timestamp"));

        Page<GlucoseLogJpaEntity> entities = repository.findByUserId(userId, pageRequest);

        List<GlucoseLog> content = entities.getContent().stream()
                .map(this::toDomain)
                .toList();

        return new PageResult<>(
                content,
                entities.getTotalElements(),
                entities.getNumber()
        );
    }

    private GlucoseLog toDomain(GlucoseLogJpaEntity entity) {
        return GlucoseLog.withId(
                entity.getId(),
                entity.getUserId(),
                entity.getTimestamp(),
                entity.getValue(),
                entity.getTrendArrow(),
                entity.getSource()
        );
    }
}
