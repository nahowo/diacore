package com.diacore.domain.simulation.port.out;

import com.diacore.domain.simulation.model.Insulin;
import com.diacore.domain.simulation.model.Meal;
import java.time.Instant;
import java.util.List;

public interface LoadRecentTreatmentPort {
    List<Insulin> loadInsulinSince(Long userId, Instant since);

    List<Meal> loadMealsSince(Long userId, Instant since);
}
