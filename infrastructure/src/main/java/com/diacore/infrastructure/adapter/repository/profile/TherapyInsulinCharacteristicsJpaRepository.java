package com.diacore.infrastructure.adapter.repository.profile;

import com.diacore.infrastructure.entity.profile.TherapyInsulinCharacteristicsJpaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TherapyInsulinCharacteristicsJpaRepository extends JpaRepository<TherapyInsulinCharacteristicsJpaEntity, Long> {
    Optional<TherapyInsulinCharacteristicsJpaEntity> findByUserId(Long userId);
}
