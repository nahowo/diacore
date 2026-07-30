package com.diacore.infrastructure.adapter.profile;

import com.diacore.domain.profile.model.BasalProfile;
import com.diacore.domain.profile.port.out.LoadBasalProfilePort;
import com.diacore.domain.profile.port.out.SaveBasalProfilePort;
import com.diacore.infrastructure.adapter.repository.profile.TherapyBasalJpaRepository;
import com.diacore.infrastructure.entity.profile.TherapyBasalJpaEntity;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TherapyBasalAdapter implements SaveBasalProfilePort, LoadBasalProfilePort {
    private final TherapyBasalJpaRepository repository;

    public TherapyBasalAdapter(TherapyBasalJpaRepository repository) {
        this.repository = repository;
    }


    @Override
    public BasalProfile save(BasalProfile basalProfile) {
        TherapyBasalJpaEntity entity = new TherapyBasalJpaEntity(
                basalProfile.userId(),
                basalProfile.dailyBasalUnits(),
                basalProfile.insulinName()
        );

        TherapyBasalJpaEntity savedEntity = repository.save(entity);

        return BasalProfile.withId(
                savedEntity.getId(),
                savedEntity.getUserId(),
                savedEntity.getDailyBasalUnits(),
                savedEntity.getInsulinName()
        );
    }

    @Override
    public Optional<BasalProfile> loadByUserId(Long userId) {
        return repository.findByUserId(userId)
                .map(entity -> BasalProfile.withId(
                        entity.getId(),
                        entity.getUserId(),
                        entity.getDailyBasalUnits(),
                        entity.getInsulinName()
                ));
    }
}
