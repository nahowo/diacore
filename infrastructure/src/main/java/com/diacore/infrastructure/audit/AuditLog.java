package com.diacore.infrastructure.audit;

import java.time.LocalDateTime;
import java.util.UUID;

public record AuditLog(
        String logId,
        String action,
        Long actorId,
        String timestamp,
        Object requestData,
        Object responseData,
        String clientIp
) {
    public static AuditLog create(String action, Long actorId, Object requestData, Object responseData, String clientIp) {
        return new AuditLog(
                UUID.randomUUID().toString(),
                action,
                actorId,
                LocalDateTime.now().toString(),
                requestData,
                responseData,
                clientIp
        );
    }
}