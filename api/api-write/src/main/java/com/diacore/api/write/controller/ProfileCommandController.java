package com.diacore.api.write.controller;

import com.diacore.api.model.CarbRatioListRequest;
import com.diacore.api.operation.ProfileCommandApi;
import com.diacore.application.usecase.profile.RegisterCarbRatioProfile;
import com.diacore.application.usecase.profile.RegisterCarbRatioProfile.Request.SegmentRequest;

import com.diacore.infrastructure.actor.ActorSelector;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProfileCommandController implements ProfileCommandApi {
    private final RegisterCarbRatioProfile registerCarbRatioProfile;

    public ProfileCommandController(RegisterCarbRatioProfile registerCarbRatioProfile) {
        this.registerCarbRatioProfile = registerCarbRatioProfile;
    }

    @Override
    public ResponseEntity<Void> updateCarbRatios(CarbRatioListRequest request) {
        List<SegmentRequest> usecaseSegments = request.getSegments().stream()
                .map(seg -> new SegmentRequest(
                        seg.getStartTime(),
                        seg.getValue()
                )).toList();

        ActorSelector.current()
                .requestTo(registerCarbRatioProfile)
                .by(new RegisterCarbRatioProfile.Request(usecaseSegments));
        return ResponseEntity.noContent().build();
    }
}
