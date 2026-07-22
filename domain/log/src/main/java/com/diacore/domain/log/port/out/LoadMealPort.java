package com.diacore.domain.log.port.out;

import com.diacore.domain.common.model.PageResult;
import com.diacore.domain.log.model.MealLog;

public interface LoadMealPort {
    PageResult<MealLog> loadByUserId(Long userId, int page, int size);
}
