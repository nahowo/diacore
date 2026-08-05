package com.diacore.infrastructure.adapter.profile;

import com.diacore.domain.profile.model.InsulinCharacteristicsProfile;
import com.diacore.domain.profile.port.out.LoadInsulinCharacteristicsProfilePort;
import com.diacore.domain.profile.port.out.SaveInsulinCharacteristicsProfilePort;
import com.diacore.infrastructure.adapter.repository.profile.TherapyInsulinCharacteristicsJpaRepository;
import com.diacore.infrastructure.entity.profile.TherapyInsulinCharacteristicsJpaEntity;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TherapyInsulinCharacteristicsAdapter implements SaveInsulinCharacteristicsProfilePort,
        LoadInsulinCharacteristicsProfilePort {
    private final TherapyInsulinCharacteristicsJpaRepository repository;

    public TherapyInsulinCharacteristicsAdapter(TherapyInsulinCharacteristicsJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public InsulinCharacteristicsProfile save(InsulinCharacteristicsProfile insulinCharacteristicsProfile) {
        repository.deleteAllByUserId(insulinCharacteristicsProfile.userId());

        TherapyInsulinCharacteristicsJpaEntity entity = new TherapyInsulinCharacteristicsJpaEntity(
                insulinCharacteristicsProfile.userId(),
                insulinCharacteristicsProfile.diaHours(),
                insulinCharacteristicsProfile.peakMinutes()
        );

        TherapyInsulinCharacteristicsJpaEntity saveEntity = repository.save(entity);

        return InsulinCharacteristicsProfile.withId(
                saveEntity.getId(),
                saveEntity.getUserId(),
                saveEntity.getDiaHours(),
                saveEntity.getPeakMinutes()
        );
    }

    @Override
    public Optional<InsulinCharacteristicsProfile> loadByUserId(Long userId) {
        return repository.findByUserId(userId)
                .map(entity -> InsulinCharacteristicsProfile.withId(
                        entity.getId(),
                        entity.getUserId(),
                        entity.getDiaHours(),
                        entity.getPeakMinutes()
                ));
    }
}
