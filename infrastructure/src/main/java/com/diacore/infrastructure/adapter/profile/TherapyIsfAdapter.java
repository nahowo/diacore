package com.diacore.infrastructure.adapter.profile;

import com.diacore.domain.profile.model.InsulinSensitivityProfile;
import com.diacore.domain.profile.model.InsulinSensitivityProfile.InsulinSensitivitySegment;
import com.diacore.domain.profile.port.out.LoadInsulinSensitivityProfilePort;
import com.diacore.domain.profile.port.out.SaveInsulinSensitivityProfilePort;
import com.diacore.infrastructure.adapter.repository.profile.TherapyIsfJpaRepository;
import com.diacore.infrastructure.entity.profile.TherapyIsfJpaEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TherapyIsfAdapter implements SaveInsulinSensitivityProfilePort, LoadInsulinSensitivityProfilePort {
    private final TherapyIsfJpaRepository repository;

    public TherapyIsfAdapter(TherapyIsfJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public InsulinSensitivityProfile save(InsulinSensitivityProfile insulinSensitivityProfile) {
        repository.deleteAllByUserId(insulinSensitivityProfile.userId());

        List<TherapyIsfJpaEntity> entities = insulinSensitivityProfile.segments().stream()
                .map(seg -> toEntity(insulinSensitivityProfile.userId(), seg))
                .toList();

        List<TherapyIsfJpaEntity> savedEntities = repository.saveAll(entities);

        return InsulinSensitivityProfile.create(
                entities.getFirst().getUserId(),
                savedEntities.stream().map(this::toDomain).toList()
        );
    }

    @Override
    public Optional<InsulinSensitivityProfile> loadByUserId(Long userId) {
        List<TherapyIsfJpaEntity> entities = repository.findAllByUserId(userId);
        if (entities.isEmpty()) {
            return Optional.empty();
        }

        List<InsulinSensitivitySegment> segments = entities.stream()
                .map(this::toDomain).toList();

        return Optional.of(InsulinSensitivityProfile.create(
                userId,
                segments
        ));
    }

    private TherapyIsfJpaEntity toEntity(Long userId, InsulinSensitivitySegment segment) {
        return new TherapyIsfJpaEntity(
                userId,
                segment.startTime(),
                segment.value()
        );
    }

    private InsulinSensitivitySegment toDomain(TherapyIsfJpaEntity entity) {
        return InsulinSensitivitySegment.withId(
                entity.getId(),
                entity.getStartTime(),
                entity.getInsulinSensitivity()
        );
    }
}
