package com.diacore.domain.simulation.service;

import com.diacore.domain.simulation.model.CalculatedIobCob;
import com.diacore.domain.simulation.model.Insulin;
import com.diacore.domain.simulation.model.Meal;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class IobCobCalculatorService {
    private static final float DEFAULT_DIA_HOURS = 4.0f;
    private static final float DEFAULT_CARB_ABSORPTION_RATE_PER_HOUR = 30.0f;

    public CalculatedIobCob calculate(
            List<Insulin> insulinRecords,
            List<Meal> mealRecords,
            Instant currentTime,
            float diaHours,
            float carbRatioPerHour
    ) {
        float totalIob = calculateIob(insulinRecords, currentTime, diaHours);
        float totalCob = calculateCob(mealRecords, currentTime, carbRatioPerHour);

        return new CalculatedIobCob(
                Math.max(0.0f, roundToTwoDecimals(totalIob)),
                Math.max(0.0f, roundToTwoDecimals(totalCob))
        );
    }

    public CalculatedIobCob calculate(
            List<Insulin> insulinRecords,
            List<Meal> mealRecords,
            Instant currentTime
    ) {
        float totalIob = calculateIob(insulinRecords, currentTime, DEFAULT_DIA_HOURS);
        float totalCob = calculateCob(mealRecords, currentTime, DEFAULT_CARB_ABSORPTION_RATE_PER_HOUR);

        return new CalculatedIobCob(
                Math.max(0.0f, roundToTwoDecimals(totalIob)),
                Math.max(0.0f, roundToTwoDecimals(totalCob))
        );
    }

    private float calculateIob(
            List<Insulin> insulinRecords,
            Instant currentTime,
            float diaHours
    ) {
        if (insulinRecords == null || insulinRecords.isEmpty()) {
            return 0.0f;
        }

        float totalDiaMinutes = diaHours * 60.0f;
        float accumulatedIob = 0.0f;

        for (Insulin record : insulinRecords) {
            long elapsedMinutes = Duration.between(record.timestamp(), currentTime).toMinutes();

            if (elapsedMinutes < 0) {
                accumulatedIob += record.units();
            } else if (elapsedMinutes < totalDiaMinutes) {
                float remainingRatio = 1.0f - (elapsedMinutes / totalDiaMinutes);
                accumulatedIob += record.units() * remainingRatio;
            }
        }

        return accumulatedIob;
    }

    private float calculateCob(
            List<Meal> mealRecords,
            Instant currentTime,
            float carbRatePerHour
    ) {
        if (mealRecords == null || mealRecords.isEmpty()) {
            return 0.0f;
        }

        float carbRatePerMinute = carbRatePerHour / 60.0f;
        float accumulatedCob = 0.0f;

        for (Meal record : mealRecords) {
            long elapsedMinutes = Duration.between(record.timestamp(), currentTime).toMinutes();

            if (elapsedMinutes < 0) {
                accumulatedCob += record.carbsGrams();
            } else {
                // 이미 흡수된 탄수화물량 = 경과시간(분) * 분당 흡수율(g/분)
                float absorbedCarbs = elapsedMinutes * carbRatePerMinute;
                float remainingCarbs = record.carbsGrams() - absorbedCarbs;

                if (remainingCarbs > 0) {
                    accumulatedCob += remainingCarbs;
                }
            }
        }

        return accumulatedCob;
    }

    private float roundToTwoDecimals(float value) {
        return Math.round(value * 100.0f) / 100.0f;
    }
}
