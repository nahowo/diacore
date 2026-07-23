package com.diacore.infrastructure.adapter.repository.profile;

import com.diacore.infrastructure.entity.profile.TherapyCrJpaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TherapyCrJpaRepository extends JpaRepository<TherapyCrJpaEntity, Long> {
    List<TherapyCrJpaEntity> findAllByUserId(Long userId);
}
