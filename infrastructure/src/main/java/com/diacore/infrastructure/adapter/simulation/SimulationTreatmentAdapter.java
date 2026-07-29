package com.diacore.infrastructure.adapter.simulation;

import com.diacore.domain.simulation.model.Insulin;
import com.diacore.domain.simulation.model.Meal;
import com.diacore.domain.simulation.port.out.LoadRecentTreatmentPort;
import com.diacore.infrastructure.adapter.repository.log.InsulinLogJpaRepository;
import com.diacore.infrastructure.adapter.repository.log.MealLogJpaRepository;
import com.diacore.infrastructure.entity.log.InsulinLogJpaEntity;
import com.diacore.infrastructure.entity.log.MealLogJpaEntity;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SimulationTreatmentAdapter implements LoadRecentTreatmentPort {
    private final InsulinLogJpaRepository insulinRepository;
    private final MealLogJpaRepository mealRepository;

    public SimulationTreatmentAdapter(InsulinLogJpaRepository insulinRepository, MealLogJpaRepository mealRepository) {
        this.insulinRepository = insulinRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public List<Insulin> loadInsulinSince(Long userId, Instant since) {
        OffsetDateTime timestamp = since.atZone(ZoneId.of("Asia/Seoul")).toOffsetDateTime();
        List<InsulinLogJpaEntity> insulinEntities = insulinRepository.findByUserIdAndTimestampAfter(userId,
                timestamp);
        return insulinEntities.stream().map(this::toInsulinDomain).toList();
    }

    @Override
    public List<Meal> loadMealsSince(Long userId, Instant since) {
        OffsetDateTime timestamp = since.atZone(ZoneId.of("Asia/Seoul")).toOffsetDateTime();
        List<MealLogJpaEntity> mealEntities = mealRepository.findByUserIdAndTimestampAfter(userId,
                timestamp);
        return mealEntities.stream().map(this::toMealDomain).toList();
    }

    private Insulin toInsulinDomain(InsulinLogJpaEntity entity) {
        return Insulin.create(entity.getDose(), entity.getTimestamp().toInstant());
    }

    private Meal toMealDomain(MealLogJpaEntity entity) {
        return Meal.create(entity.getCarbohydrateG(), entity.getTimestamp().toInstant());
    }
}
