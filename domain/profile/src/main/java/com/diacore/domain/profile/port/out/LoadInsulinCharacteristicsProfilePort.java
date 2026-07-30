package com.diacore.domain.profile.port.out;

import com.diacore.domain.profile.model.InsulinCharacteristicsProfile;
import java.util.Optional;

public interface LoadInsulinCharacteristicsProfilePort {
    Optional<InsulinCharacteristicsProfile> loadByUserId(Long userId);
}
