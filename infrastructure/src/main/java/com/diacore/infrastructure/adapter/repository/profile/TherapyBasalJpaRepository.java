package com.diacore.infrastructure.adapter.repository.profile;

import com.diacore.infrastructure.entity.profile.TherapyBasalJpaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TherapyBasalJpaRepository extends JpaRepository<TherapyBasalJpaEntity, Long> {
    Optional<TherapyBasalJpaEntity> findByUserId(Long userId);
    @Modifying
    @Query("DELETE FROM TherapyBasalJpaEntity t WHERE t.userId = :userId")
    void deleteAllByUserId(Long userId);
}
