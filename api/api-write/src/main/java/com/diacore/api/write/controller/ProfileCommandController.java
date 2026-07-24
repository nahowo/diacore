package com.diacore.api.write.controller;

import com.diacore.api.model.CarbRatioListRequest;
import com.diacore.api.model.InsulinSensitivityListRequest;
import com.diacore.api.operation.ProfileCommandApi;
import com.diacore.application.usecase.profile.RegisterCarbRatioHistory;
import com.diacore.application.usecase.profile.RegisterCarbRatioProfile;

import com.diacore.application.usecase.profile.RegisterInsulinSensitivityHistory;
import com.diacore.application.usecase.profile.RegisterInsulinSensitivityProfile;
import com.diacore.infrastructure.actor.ActorSelector;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProfileCommandController implements ProfileCommandApi {
    private final RegisterCarbRatioProfile registerCarbRatioProfile;
    private final RegisterInsulinSensitivityProfile registerInsulinSensitivityProfile;
    private final RegisterCarbRatioHistory registerCarbRatioHistory;
    private final RegisterInsulinSensitivityHistory registerInsulinSensitivityHistory;

    public ProfileCommandController(RegisterCarbRatioProfile registerCarbRatioProfile,
                                    RegisterInsulinSensitivityProfile insulinSensitivityProfile,
                                    RegisterCarbRatioHistory registerCarbRatioHistory,
                                    RegisterInsulinSensitivityHistory registerInsulinSensitivityHistory) {
        this.registerCarbRatioProfile = registerCarbRatioProfile;
        this.registerInsulinSensitivityProfile = insulinSensitivityProfile;
        this.registerCarbRatioHistory = registerCarbRatioHistory;
        this.registerInsulinSensitivityHistory = registerInsulinSensitivityHistory;
    }

    @Override
    public ResponseEntity<Void> updateCarbRatios(CarbRatioListRequest request) {
        List<RegisterCarbRatioProfile.Request.SegmentRequest> useCaseSegments = request.getSegments().stream()
                .map(seg -> new RegisterCarbRatioProfile.Request.SegmentRequest(
                        seg.getStartTime(),
                        seg.getValue()
                )).toList();

        ActorSelector.current()
                .requestTo(registerCarbRatioProfile)
                .by(new RegisterCarbRatioProfile.Request(useCaseSegments));
        ActorSelector.current()
                .requestTo(registerCarbRatioHistory)
                .by(new RegisterCarbRatioHistory.Request(useCaseSegments, request.getReasonText(),
                        request.getChangeSource()));

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> updateInsulinSensitivities(
            InsulinSensitivityListRequest request) {
        List<RegisterInsulinSensitivityProfile.Request.SegmentRequest> useCaseSegments = request.getSegments().stream()
                .map(seg -> new RegisterInsulinSensitivityProfile.Request.SegmentRequest(
                        seg.getStartTime(),
                        seg.getValue()
                )).toList();

        ActorSelector.current()
                .requestTo(registerInsulinSensitivityProfile)
                .by(new RegisterInsulinSensitivityProfile.Request(useCaseSegments));
        ActorSelector.current()
                .requestTo(registerInsulinSensitivityHistory)
                .by(new RegisterInsulinSensitivityHistory.Request(useCaseSegments, request.getReasonText(),
                        request.getChangeSource()));

        return ResponseEntity.noContent().build();
    }
}
