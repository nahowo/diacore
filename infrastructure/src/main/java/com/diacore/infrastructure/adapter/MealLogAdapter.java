package com.diacore.infrastructure.adapter;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.log.model.MealLog;
import com.diacore.domain.log.port.out.LoadMealPort;
import com.diacore.domain.log.port.out.SaveMealLogPort;
import com.diacore.infrastructure.adapter.repository.MealLogJpaRepository;
import com.diacore.infrastructure.entity.MealLogJpaEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

@Component
public class MealLogAdapter implements SaveMealLogPort, LoadMealPort {
    private final MealLogJpaRepository repository;

    public MealLogAdapter(MealLogJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public MealLog save(MealLog mealLog) {
        MealLogJpaEntity entity = new MealLogJpaEntity(
                mealLog.getId(),
                mealLog.getUserId(),
                mealLog.getTimestamp(),
                mealLog.getCarbohydrateG(),
                mealLog.getMealType(),
                mealLog.getFoodDesc()
        );

        MealLogJpaEntity savedEntity = repository.save(entity);

        return MealLog.withId(
                savedEntity.getId(),
                savedEntity.getUserId(),
                savedEntity.getTimestamp(),
                savedEntity.getCarbohydrateG(),
                savedEntity.getMealType(),
                savedEntity.getFoodDesc()
        );
    }

    @Override
    public PageResult<MealLog> loadByUserId(Long userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Direction.DESC, "timestamp"));
        Page<MealLogJpaEntity> entities = repository.findByUserId(userId, pageRequest);

        List<MealLog> content = entities.getContent().stream()
                .map(this::toDomain)
                .toList();

        return new PageResult<>(
                content,
                entities.getTotalElements(),
                entities.getNumber()
        );
    }

    private MealLog toDomain(MealLogJpaEntity entity) {
        return MealLog.withId(
                entity.getId(),
                entity.getUserId(),
                entity.getTimestamp(),
                entity.getCarbohydrateG(),
                entity.getMealType(),
                entity.getFoodDesc()
        );
    }
}
