package com.diacore.infrastructure.adapter.repository;

import com.diacore.infrastructure.entity.InsulinLogJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsulinLogJpaRepository extends JpaRepository<InsulinLogJpaEntity, Long> {
    Page<InsulinLogJpaEntity> findByUserId(Long userId, Pageable pageable);
}
