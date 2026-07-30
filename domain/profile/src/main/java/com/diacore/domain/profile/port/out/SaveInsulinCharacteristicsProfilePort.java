package com.diacore.domain.profile.port.out;

import com.diacore.domain.profile.model.InsulinCharacteristicsProfile;

public interface SaveInsulinCharacteristicsProfilePort {
    InsulinCharacteristicsProfile save(InsulinCharacteristicsProfile insulinCharacteristicsProfile);
}
