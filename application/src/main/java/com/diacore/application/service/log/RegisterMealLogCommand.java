package com.diacore.application.service.log;

import com.diacore.application.usecase.log.RegisterMealLog;
import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.log.model.MealLog;
import com.diacore.domain.log.port.out.SaveMealLogPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterMealLogCommand implements RegisterMealLog {
    private final SaveMealLogPort saveMealLogPort;

    public RegisterMealLogCommand(SaveMealLogPort saveMealLogPort) {
        this.saveMealLogPort = saveMealLogPort;
    }

    @Override
    public Long execute(Actor actor, Request request) {
        MealLog mealLog = MealLog.create(
                actor.userId(),
                request.timestamp(),
                request.carbohydrateG(),
                request.mealType(),
                request.foodDesc()
        );

        MealLog savedLog = saveMealLogPort.save(mealLog);

        return savedLog.id();
    }
}
