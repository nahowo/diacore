package com.diacore.infrastructure.adapter.repository.profile;

import com.diacore.infrastructure.entity.profile.TherapyBasalJpaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TherapyBasalJpaRepository extends JpaRepository<TherapyBasalJpaEntity, Long> {
    Optional<TherapyBasalJpaEntity> findByUserId(Long userId);
}
