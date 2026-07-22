package com.diacore.domain.log.model;

import java.time.OffsetDateTime;

public class MealLog {
    private Long id;
    private final Long userId;
    private final OffsetDateTime timestamp;
    private final Float carbohydrateG;
    private final String mealType;
    private final String foodDesc;

    private MealLog(Long id, Long userId, OffsetDateTime timestamp, Float carbohydrateG, String mealType, String foodDesc) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.carbohydrateG = carbohydrateG;
        this.mealType = mealType;
        this.foodDesc = foodDesc;
    }

    public static MealLog create(Long userId, OffsetDateTime timestamp, Float carbohydrateG, String mealType,
                                 String foodDesc) {
        if (carbohydrateG == null || carbohydrateG <= 0) {
            throw new IllegalArgumentException("Carb must be over 0.");
        }
        return new MealLog(null, userId, timestamp, carbohydrateG, mealType, foodDesc);
    }

    public static MealLog withId(Long id, Long userId, OffsetDateTime timestamp, Float carbohydrateG, String mealType,
                                 String foodDesc) {
        return new MealLog(id, userId, timestamp, carbohydrateG, mealType, foodDesc);
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public Float getCarbohydrateG() {
        return carbohydrateG;
    }

    public String getMealType() {
        return mealType;
    }

    public String getFoodDesc() {
        return foodDesc;
    }
}
