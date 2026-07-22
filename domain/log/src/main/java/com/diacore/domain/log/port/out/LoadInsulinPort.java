package com.diacore.domain.log.port.out;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.log.model.InsulinLog;

public interface LoadInsulinPort {
    PageResult<InsulinLog> loadByUserId(Long userId, int page, int size);
}
