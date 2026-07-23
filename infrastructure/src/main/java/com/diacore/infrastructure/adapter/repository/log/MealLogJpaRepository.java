package com.diacore.infrastructure.adapter.repository.log;

import com.diacore.infrastructure.entity.log.MealLogJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealLogJpaRepository extends JpaRepository<MealLogJpaEntity, Long> {
    Page<MealLogJpaEntity> findByUserId(Long userId, Pageable pageable);
}
