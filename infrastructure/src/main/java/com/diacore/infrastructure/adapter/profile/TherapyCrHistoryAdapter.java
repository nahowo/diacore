package com.diacore.infrastructure.adapter.profile;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.profile.model.CarbRatioHistory;
import com.diacore.domain.profile.model.CarbRatioProfile.CarbRatioSegment;
import com.diacore.domain.profile.port.out.LoadCarbRatioHistoryPort;
import com.diacore.domain.profile.port.out.SaveCarbRatioHistoryPort;
import com.diacore.infrastructure.adapter.repository.profile.TherapyCrHistoryJpaRepository;
import com.diacore.infrastructure.entity.profile.TherapyCrHistoryJpaEntity;
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
public class TherapyCrHistoryAdapter implements SaveCarbRatioHistoryPort, LoadCarbRatioHistoryPort {
    private final TherapyCrHistoryJpaRepository repository;
    private final ObjectMapper objectMapper;

    public TherapyCrHistoryAdapter(TherapyCrHistoryJpaRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public CarbRatioHistory save(CarbRatioHistory carbRatioHistory) {
        List<SnapshotSegmentDto> snapshotSegmentDtos = carbRatioHistory.snapshotSegments().stream()
                .map(seg -> new SnapshotSegmentDto(seg.startTime(), seg.value())).toList();

        String snapshotSegments;
        try {
            snapshotSegments = objectMapper.writeValueAsString(snapshotSegmentDtos);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON 직렬화에 실패했습니다.", e);
        }

        TherapyCrHistoryJpaEntity entity = new TherapyCrHistoryJpaEntity(
                carbRatioHistory.userId(),
                snapshotSegments,
                carbRatioHistory.changeSource(),
                carbRatioHistory.reasonText()
        );

        TherapyCrHistoryJpaEntity savedEntity = repository.save(entity);

        return toDomain(savedEntity);
    }

    @Override
    public PageResult<CarbRatioHistory> loadByUserId(Long userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Direction.DESC, "createdAt"));
        Page<TherapyCrHistoryJpaEntity> entities = repository.findByUserId(userId, pageRequest);

        List<CarbRatioHistory> content = entities.getContent().stream()
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

    private CarbRatioHistory toDomain(TherapyCrHistoryJpaEntity entity) {
        try {
            List<CarbRatioSegment> snapshotSegments = objectMapper.readValue(
                    entity.getProfileSnapshotJson(),
                    new TypeReference<List<CarbRatioSegment>>() {
                    }
            );
            return CarbRatioHistory.withId(
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
