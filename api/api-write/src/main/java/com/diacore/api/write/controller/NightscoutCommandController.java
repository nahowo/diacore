package com.diacore.api.write.controller;

import com.diacore.api.model.NightscoutEntry;
import com.diacore.api.operation.EntriesCommandApi;
import com.diacore.application.usecase.log.RegisterGlucoseLog;
import com.diacore.infrastructure.actor.ActorSelector;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import org.springframework.http.ResponseEntity;

public class NightscoutCommandController implements EntriesCommandApi {
    private final RegisterGlucoseLog registerGlucoseLog;

    public NightscoutCommandController(RegisterGlucoseLog registerGlucoseLog) {
        this.registerGlucoseLog = registerGlucoseLog;
    }

    @Override
    public ResponseEntity<Void> ingestNightscoutEntries(List<NightscoutEntry> entries) {
        if (entries == null || entries.isEmpty()) {
            return ResponseEntity.ok().build();
        }

        for (NightscoutEntry entry : entries) {
            if (!"sgv".equalsIgnoreCase(entry.getType()) || entry.getSgv() == null || entry.getDate() == null) {
                continue;
            }

            OffsetDateTime timestamp = Instant.ofEpochMilli(entry.getDate())
                    .atZone(ZoneId.of("Asia/Seoul"))
                    .toOffsetDateTime();

            ActorSelector.current()
                    .requestTo(registerGlucoseLog)
                    .by(new RegisterGlucoseLog.Request(
                            timestamp,
                            entry.getSgv(),
                            mapTrendArrow(entry.getDirection()),
                            entry.getDevice() != null ? entry.getDevice() : "Nightscout4iOS"
                    ));
        }

        return ResponseEntity.ok().build();
    }

    private String mapTrendArrow(String nsDirection) {
        if (nsDirection == null) return "NONE";
        return switch (nsDirection) {
            case "DoubleUp" -> "DOUBLE_UP";
            case "SingleUp" -> "SINGLE_UP";
            case "FortyFiveUp" -> "FORTY_FIVE_UP";
            case "Flat" -> "FLAT";
            case "FortyFiveDown" -> "FORTY_FIVE_DOWN";
            case "SingleDown" -> "SINGLE_DOWN";
            case "DoubleDown" -> "DOUBLE_DOWN";
            default -> "NONE";
        };
    }
}
