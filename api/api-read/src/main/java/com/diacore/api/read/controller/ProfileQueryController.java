package com.diacore.api.read.controller;

import com.diacore.api.model.CarbRatioListResponse;
import com.diacore.api.model.CarbRatioSegment;
import com.diacore.api.operation.ProfileQueryApi;
import com.diacore.application.usecase.profile.GetCarbRatioProfile;
import com.diacore.domain.profile.model.CarbRatioProfile;
import com.diacore.infrastructure.actor.ActorSelector;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProfileQueryController implements ProfileQueryApi {
    private final GetCarbRatioProfile getCarbRatioProfile;

    public ProfileQueryController(GetCarbRatioProfile getCarbRatioProfile) {
        this.getCarbRatioProfile = getCarbRatioProfile;
    }

    @Override
    public ResponseEntity<CarbRatioListResponse> getCarbRatios() {
        CarbRatioProfile profile = ActorSelector.current()
                .requestTo(getCarbRatioProfile)
                .by(new GetCarbRatioProfile.Request());

        List<CarbRatioSegment> responseSegments = profile.segments().stream()
                .map(seg -> new CarbRatioSegment(
                        seg.startTime(),
                        seg.value()
                )).toList();

        CarbRatioListResponse response = new CarbRatioListResponse(
                responseSegments,
                profile.timestamp()
        );
        return ResponseEntity.ok(response);
    }
}
