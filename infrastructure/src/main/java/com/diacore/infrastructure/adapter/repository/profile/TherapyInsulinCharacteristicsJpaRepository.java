package com.diacore.infrastructure.adapter.repository.profile;

import com.diacore.infrastructure.entity.profile.TherapyInsulinCharacteristicsJpaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TherapyInsulinCharacteristicsJpaRepository extends JpaRepository<TherapyInsulinCharacteristicsJpaEntity, Long> {
    Optional<TherapyInsulinCharacteristicsJpaEntity> findByUserId(Long userId);
    @Modifying
    @Query("DELETE FROM TherapyInsulinCharacteristicsJpaEntity t WHERE t.userId = :userId")
    void deleteAllByUserId(Long userId);
}
