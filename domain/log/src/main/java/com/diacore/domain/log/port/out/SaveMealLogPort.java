package com.diacore.domain.log.port.out;

import com.diacore.domain.log.model.MealLog;

public interface SaveMealLogPort {
    MealLog save(MealLog mealLog);
}
