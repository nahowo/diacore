package com.diacore.infrastructure.adapter.profile;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.profile.model.InsulinSensitivityHistory;
import com.diacore.domain.profile.model.InsulinSensitivityProfile.InsulinSensitivitySegment;
import com.diacore.domain.profile.port.out.LoadInsulinSensitivityHistoryPort;
import com.diacore.domain.profile.port.out.SaveInsulinSensitivityHistoryPort;
import com.diacore.infrastructure.adapter.repository.profile.TherapyIsfHistoryJpaRepository;
import com.diacore.infrastructure.entity.profile.TherapyIsfHistoryJpaEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

@Component
public class TherapyIsfHistoryAdapter implements SaveInsulinSensitivityHistoryPort, LoadInsulinSensitivityHistoryPort {
    private final TherapyIsfHistoryJpaRepository repository;
    private final ObjectMapper objectMapper;

    public TherapyIsfHistoryAdapter(TherapyIsfHistoryJpaRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public InsulinSensitivityHistory save(InsulinSensitivityHistory insulinSensitivityHistory) {
        List<SnapshotSegmentDto> snapshotSegmentDtos = insulinSensitivityHistory.snapshotSegments().stream()
                .map(seg -> new SnapshotSegmentDto(seg.startTime(), seg.value())).toList();

        String snapshotSegments;
        try {
            snapshotSegments = objectMapper.writeValueAsString(snapshotSegmentDtos);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON 직렬화에 실패했습니다.", e);
        }

        TherapyIsfHistoryJpaEntity entity = new TherapyIsfHistoryJpaEntity(
                insulinSensitivityHistory.userId(),
                snapshotSegments,
                insulinSensitivityHistory.changeSource(),
                insulinSensitivityHistory.reasonText()
        );

        TherapyIsfHistoryJpaEntity savedEntity = repository.save(entity);

        return toDomain(savedEntity);
    }

    @Override
    public PageResult<InsulinSensitivityHistory> loadByUserId(Long userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Direction.DESC, "createdAt"));
        Page<TherapyIsfHistoryJpaEntity> entities = repository.findByUserId(userId, pageRequest);

        List<InsulinSensitivityHistory> content = entities.getContent().stream()
                .map(this::toDomain).toList();
        return new PageResult<>(
                content,
                entities.getTotalElements(),
                entities.getNumber(),
                entities.getTotalPages(),
                entities.getSize(),
                entities.getNumber()
        );
    }

    private InsulinSensitivityHistory toDomain(TherapyIsfHistoryJpaEntity entity) {
        try {
            List<InsulinSensitivitySegment> snapshotSegments = objectMapper.readValue(
                    entity.getProfileSnapshotJson(),
                    new TypeReference<List<InsulinSensitivitySegment>>() {
                    }
            );
            return InsulinSensitivityHistory.withId(
                    entity.getId(),
                    entity.getUserId(),
                    snapshotSegments,
                    entity.getChangeSource(),
                    entity.getReasonText(),
                    entity.getCreatedAt()
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException("스냅샷 JSON 역직렬화에 실패했습니다.", e);
        }
    }
}
