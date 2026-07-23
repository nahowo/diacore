package com.diacore.infrastructure.adapter.repository.profile;

import com.diacore.infrastructure.entity.profile.TherapyIsfJpaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TherapyIsfJpaRepository extends JpaRepository<TherapyIsfJpaEntity, Long> {
    List<TherapyIsfJpaEntity> findAllByUserId(Long userId);
    @Modifying
    @Query("DELETE FROM TherapyIsfJpaEntity t WHERE t.userId = :userId")
    void deleteAllByUserId(Long userId);
}
