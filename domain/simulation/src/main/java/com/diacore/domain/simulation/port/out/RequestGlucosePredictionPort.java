package com.diacore.domain.simulation.port.out;

import com.diacore.domain.simulation.model.SimulationContext;
import com.diacore.domain.simulation.model.SimulationResult;

public interface RequestGlucosePredictionPort {
    SimulationResult predict(SimulationContext context);
}
