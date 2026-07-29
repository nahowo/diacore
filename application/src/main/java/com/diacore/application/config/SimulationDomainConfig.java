package com.diacore.application.config;

import com.diacore.domain.simulation.service.IobCobCalculatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimulationDomainConfig {
    @Bean
    public IobCobCalculatorService iobCobCalculatorService() {
        return new IobCobCalculatorService();
    }
}
