package com.diacore.infrastructure.adapter.repository;

import com.diacore.infrastructure.entity.GlucoseLogJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlucoseLogJpaRepository extends JpaRepository<GlucoseLogJpaEntity, Long> {
    Page<GlucoseLogJpaEntity> findByUserId(Long userId, Pageable pageable);
}
