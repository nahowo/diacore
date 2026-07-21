package com.diacore.domain.log.port.out;

import com.diacore.domain.log.model.GlucoseLog;

public interface SaveGlucoseLogPort {
    GlucoseLog save(GlucoseLog glucoseLog);
}
