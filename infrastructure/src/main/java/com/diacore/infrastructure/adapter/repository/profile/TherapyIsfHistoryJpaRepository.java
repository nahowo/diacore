package com.diacore.infrastructure.adapter.repository.profile;

import com.diacore.infrastructure.entity.profile.TherapyIsfHistoryJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TherapyIsfHistoryJpaRepository extends JpaRepository<TherapyIsfHistoryJpaEntity, Long> {
    Page<TherapyIsfHistoryJpaEntity> findByUserId(Long userId, Pageable pageable);
}
