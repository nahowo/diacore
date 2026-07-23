package com.diacore.domain.profile.port.out;

import com.diacore.domain.profile.model.CarbRatioProfile;

public interface SaveCarbRatioProfilePort {
    CarbRatioProfile save(CarbRatioProfile carbRatioProfile);
}
