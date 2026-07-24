package com.diacore.infrastructure.adapter.repository.profile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.diacore.infrastructure.entity.profile.TherapyCrHistoryJpaEntity;

public interface TherapyCrHistoryJpaRepository extends JpaRepository<TherapyCrHistoryJpaEntity, Long> {
    Page<TherapyCrHistoryJpaEntity> findByUserId(Long userId, Pageable pageable);
}
