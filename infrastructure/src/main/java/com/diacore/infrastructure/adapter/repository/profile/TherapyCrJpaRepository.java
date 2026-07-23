package com.diacore.infrastructure.adapter.repository.profile;

import com.diacore.infrastructure.entity.profile.TherapyCrJpaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TherapyCrJpaRepository extends JpaRepository<TherapyCrJpaEntity, Long> {
    List<TherapyCrJpaEntity> findAllByUserId(Long userId);
    @Modifying
    @Query("DELETE FROM TherapyCrJpaEntity t WHERE t.userId = :userId")
    void deleteAllByUserId(Long userId);
}
