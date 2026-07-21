package com.diacore.infrastructure.adapter.repository;

import com.diacore.infrastructure.entity.GlucoseLogJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlucoseLogJpaRepository extends JpaRepository<GlucoseLogJpaEntity, Long> {
}
