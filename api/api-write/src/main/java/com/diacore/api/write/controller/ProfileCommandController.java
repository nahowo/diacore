package com.diacore.api.write.controller;

import com.diacore.api.model.BasalProfileResponse;
import com.diacore.api.model.CarbRatioListRequest;
import com.diacore.api.model.InsulinCharacteristicsResponse;
import com.diacore.api.model.InsulinSensitivityListRequest;
import com.diacore.api.model.UpdateBasalProfileRequest;
import com.diacore.api.model.UpdateInsulinCharacteristicsRequest;
import com.diacore.api.operation.ProfileCommandApi;
import com.diacore.application.usecase.profile.RegisterBasalProfile;
import com.diacore.application.usecase.profile.RegisterBasalProfile.Request;
import com.diacore.application.usecase.profile.RegisterCarbRatioHistory;
import com.diacore.application.usecase.profile.RegisterCarbRatioProfile;

import com.diacore.application.usecase.profile.RegisterInsulinCharacteristicsProfile;
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
    private final RegisterBasalProfile registerBasalProfile;
    private final RegisterInsulinCharacteristicsProfile registerInsulinCharacteristicsProfile;

    public ProfileCommandController(RegisterCarbRatioProfile registerCarbRatioProfile,
                                    RegisterInsulinSensitivityProfile insulinSensitivityProfile,
                                    RegisterCarbRatioHistory registerCarbRatioHistory,
                                    RegisterInsulinSensitivityHistory registerInsulinSensitivityHistory,
                                    RegisterBasalProfile registerBasalProfile,
                                    RegisterInsulinCharacteristicsProfile registerInsulinCharacteristicsProfile) {
        this.registerCarbRatioProfile = registerCarbRatioProfile;
        this.registerInsulinSensitivityProfile = insulinSensitivityProfile;
        this.registerCarbRatioHistory = registerCarbRatioHistory;
        this.registerInsulinSensitivityHistory = registerInsulinSensitivityHistory;
        this.registerBasalProfile = registerBasalProfile;
        this.registerInsulinCharacteristicsProfile = registerInsulinCharacteristicsProfile;
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

    @Override
    public ResponseEntity<Void> updateBasalDose(UpdateBasalProfileRequest request) {
        Request savedBasalDose = new Request(
                request.getDailyBasalUnits(),
                request.getBasalInsulinName()
        );

        ActorSelector.current()
                .requestTo(registerBasalProfile)
                .by(savedBasalDose);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> updateInsulinCharacteristics(
            UpdateInsulinCharacteristicsRequest request) {
        RegisterInsulinCharacteristicsProfile.Request savedInsulinCharacteristics = new RegisterInsulinCharacteristicsProfile.Request(
                request.getDiaHours(),
                request.getPeakMinutes()
        );

        ActorSelector.current()
                .requestTo(registerInsulinCharacteristicsProfile)
                .by(savedInsulinCharacteristics);
        return ResponseEntity.noContent().build();
    }
}
