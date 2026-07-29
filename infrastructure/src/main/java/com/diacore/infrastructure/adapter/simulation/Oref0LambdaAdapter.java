package com.diacore.infrastructure.adapter.simulation;

import com.diacore.domain.simulation.model.SimulationContext;
import com.diacore.domain.simulation.model.SimulationResult;
import com.diacore.domain.simulation.port.out.RequestGlucosePredictionPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class Oref0LambdaAdapter implements RequestGlucosePredictionPort {
    private final RestClient restClient;

    public Oref0LambdaAdapter(@Value("${simulation.lambda.url}") String serverUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(serverUrl)
                .build();
    }

    @Override
    public SimulationResult predict(SimulationContext context) {
        return restClient.post()
                .uri("/")
                .body(context)
                .retrieve()
                .body(SimulationResult.class);
    }
}
