package com.diacore.infrastructure.audit;

import com.diacore.common.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AuditLogEventListener {
    private static final Logger log = LoggerFactory.getLogger(AuditLogEventListener.class);
    private final AuditLogClient auditLogClient;

    public AuditLogEventListener(AuditLogClient auditLogClient) {
        this.auditLogClient = auditLogClient;
    }

    @Async
    @EventListener
    public void handleEvent(Event<?, ?> event) {
        try {
            String clientIp = "0.0.0.0";
            AuditLog auditLog = AuditLog.create(
                    event.eventName(),
                    event.actor().userId(),
                    event.request(),
                    event.response(),
                    clientIp
            );
            auditLogClient.send(auditLog);
            log.debug("Successfully sent Audit Log: [{}] by User {}", event.eventName(), event.actor().userId());
        } catch (Exception e) {
            log.error("Failed to send Audit Log: [{}]: {}", event.eventName(), e.getMessage());
        }
    }
}
