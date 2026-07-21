package com.diacore.domain.log.port.out;

import com.diacore.domain.log.model.InsulinLog;

public interface SaveInsulinLogPort {
    InsulinLog save(InsulinLog insulinLog);
}
