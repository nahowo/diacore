package com.diacore.infrastructure.entity.log;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "meal_logs")
public class MealLogJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "timestamp", nullable = false)
    private OffsetDateTime timestamp;

    @Column(name = "carbohydrate_g", nullable = false)
    private Float carbohydrateG;

    @Column(name = "meal_type", nullable = false)
    private String mealType;

    @Column(name = "food_desc", nullable = false)
    private String foodDesc;

    protected MealLogJpaEntity() {}

    public MealLogJpaEntity(Long id, Long userId, OffsetDateTime timestamp, Float carbohydrateG, String mealType,
                            String foodDesc) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.carbohydrateG = carbohydrateG;
        this.mealType = mealType;
        this.foodDesc = foodDesc;
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
