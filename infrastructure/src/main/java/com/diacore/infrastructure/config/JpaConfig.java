package com.diacore.infrastructure.config;

import java.util.Optional;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "actorAuditorAware")
@EntityScan(basePackages = "com.diacore")
@EnableJpaRepositories(basePackages = "com.diacore")
public class JpaConfig {
    @Bean
    public AuditorAware<Long> actorAuditorAware() {
        return() -> {
            return Optional.of(1L);
        };
    }
}
