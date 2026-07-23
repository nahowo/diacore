package com.diacore.infrastructure.adapter.profile;

import com.diacore.domain.profile.model.CarbRatioProfile;
import com.diacore.domain.profile.model.CarbRatioProfile.CarbRatioSegment;
import com.diacore.domain.profile.port.out.LoadCarbRatioProfilePort;
import com.diacore.domain.profile.port.out.SaveCarbRatioProfilePort;
import com.diacore.infrastructure.adapter.repository.profile.TherapyCrJpaRepository;
import com.diacore.infrastructure.entity.profile.TherapyCrJpaEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TherapyCrAdapter implements SaveCarbRatioProfilePort, LoadCarbRatioProfilePort {
    private final TherapyCrJpaRepository repository;

    public TherapyCrAdapter(TherapyCrJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public CarbRatioProfile save(CarbRatioProfile carbRatioProfile) {
        List<TherapyCrJpaEntity> entities = carbRatioProfile.segments().stream()
                .map(seg -> toEntity(carbRatioProfile.userId(), seg))
                .toList();

        List<TherapyCrJpaEntity> savedEntities = repository.saveAll(entities);

        return CarbRatioProfile.withId(
                carbRatioProfile.userId(),
                savedEntities.stream().map(this::toDomain).toList(),
                carbRatioProfile.timestamp()
        );
    }

    @Override
    public Optional<CarbRatioProfile> loadByUserId(Long userId) {
        List<TherapyCrJpaEntity> entities = repository.findAllByUserId(userId);
        if (entities.isEmpty()) {
            return Optional.empty();
        }

        List<CarbRatioSegment> segments = entities.stream()
                .map(this::toDomain).toList();

        return Optional.of(CarbRatioProfile.withId(
                userId,
                segments,
                entities.get(0).getTimestamp()
        ));
    }

    private TherapyCrJpaEntity toEntity(Long userId, CarbRatioSegment segment) {
        return new TherapyCrJpaEntity(
                userId,
                segment.startTime(),
                segment.value()
        );
    }

    private CarbRatioSegment toDomain(TherapyCrJpaEntity entity) {
        return CarbRatioSegment.withId(
                entity.getId(),
                entity.getStartTime(),
                entity.getCarbRatio()
        );
    }
}
