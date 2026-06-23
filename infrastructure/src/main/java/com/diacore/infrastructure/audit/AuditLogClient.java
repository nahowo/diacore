package com.diacore.infrastructure.audit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class AuditLogClient {
    private final RestClient restClient;
    private final String apiKey;

    public AuditLogClient(
            RestClient.Builder restClientBuilder,
            @Value("${audit.base-url}") String baseUrl,
            @Value("${audit.api-key") String apiKey
    ) {
        this.restClient = restClientBuilder.baseUrl(baseUrl).build();
        this.apiKey = apiKey;
    }

    public void send(AuditLog auditLog) {
        restClient.post()
                .uri("/api/audit-logs")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + apiKey)
                .body(auditLog)
                .retrieve()
                .toBodilessEntity();
    }
}
