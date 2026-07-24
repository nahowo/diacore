package com.diacore.infrastructure.adapter.log;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.log.model.InsulinLog;
import com.diacore.domain.log.port.out.LoadInsulinPort;
import com.diacore.domain.log.port.out.SaveInsulinLogPort;
import com.diacore.infrastructure.adapter.repository.log.InsulinLogJpaRepository;
import com.diacore.infrastructure.entity.log.InsulinLogJpaEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

@Component
public class InsulinLogAdapter implements SaveInsulinLogPort, LoadInsulinPort {
    private final InsulinLogJpaRepository repository;

    public InsulinLogAdapter(InsulinLogJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public InsulinLog save(InsulinLog insulinLog) {
        InsulinLogJpaEntity entity = new InsulinLogJpaEntity(
                insulinLog.id(),
                insulinLog.userId(),
                insulinLog.timestamp(),
                insulinLog.dose(),
                insulinLog.type()
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

    @Override
    public PageResult<InsulinLog> loadByUserId(Long userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Direction.DESC, "timestamp"));

        Page<InsulinLogJpaEntity> entities = repository.findByUserId(userId, pageRequest);

        List<InsulinLog> content = entities.getContent().stream()
                .map(this::toDomain)
                .toList();

        return new PageResult<>(
                content,
                entities.getTotalElements(),
                entities.getNumber(),
                entities.getTotalPages(),
                entities.getSize(),
                entities.getNumber()
        );
    }

    private InsulinLog toDomain(InsulinLogJpaEntity entity) {
        return InsulinLog.withId(
                entity.getId(),
                entity.getUserId(),
                entity.getTimestamp(),
                entity.getDose(),
                entity.getType()
        );
    }
}
