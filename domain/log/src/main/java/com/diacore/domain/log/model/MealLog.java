package com.diacore.domain.log.model;

import java.time.OffsetDateTime;

public record MealLog (
        Long id,
        Long userId,
        OffsetDateTime timestamp,
        Float carbohydrateG,
        String mealType,
        String foodDesc
) {
    public MealLog {
        if (carbohydrateG == null || carbohydrateG <= 0) {
            throw new IllegalArgumentException("탄수화물은 0을 초과해야 합니다.");
        }
    }

    public static MealLog create(Long userId, OffsetDateTime timestamp, Float carbohydrateG, String mealType,
                                 String foodDesc) {
        return new MealLog(null, userId, timestamp, carbohydrateG, mealType, foodDesc);
    }

    public static MealLog withId(Long id, Long userId, OffsetDateTime timestamp, Float carbohydrateG, String mealType,
                                 String foodDesc) {
        return new MealLog(id, userId, timestamp, carbohydrateG, mealType, foodDesc);
    }
}
