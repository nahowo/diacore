package com.diacore.domain.log.port.out;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.common.usecase.UseCase;
import com.diacore.domain.log.model.GlucoseLog;

public interface LoadGlucosePort {
    PageResult<GlucoseLog> loadByUserId(Long userId, int page, int size);
}
