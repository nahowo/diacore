package com.diacore.api.read.controller;

import com.diacore.api.model.TherapyParameterResponse;
import com.diacore.api.model.CarbRatioListResponse;
import com.diacore.api.model.CarbRatioSegment;
import com.diacore.api.model.InsulinSensitivityListResponse;
import com.diacore.api.model.InsulinSensitivitySegment;
import com.diacore.api.operation.ProfileQueryApi;
import com.diacore.application.usecase.profile.GetCarbRatioProfile;
import com.diacore.application.usecase.profile.GetInsulinSensitivityProfile;
import com.diacore.application.usecase.profile.GetInsulinSensitivityProfile.Request;
import com.diacore.application.usecase.profile.GetTherapyParameters;
import com.diacore.application.usecase.profile.GetTherapyParameters.Response;
import com.diacore.domain.profile.model.CarbRatioProfile;
import com.diacore.domain.profile.model.InsulinSensitivityProfile;
import com.diacore.infrastructure.actor.ActorSelector;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProfileQueryController implements ProfileQueryApi {
    private final GetCarbRatioProfile getCarbRatioProfile;
    private final GetInsulinSensitivityProfile getInsulinSensitivityProfile;
    private final GetTherapyParameters getTherapyParameters;

    public ProfileQueryController(GetCarbRatioProfile getCarbRatioProfile,
                                  GetInsulinSensitivityProfile getInsulinSensitivityProfile,
                                  GetTherapyParameters getTherapyParameters) {
        this.getCarbRatioProfile = getCarbRatioProfile;
        this.getInsulinSensitivityProfile = getInsulinSensitivityProfile;
        this.getTherapyParameters = getTherapyParameters;
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

    @Override
    public ResponseEntity<InsulinSensitivityListResponse> getInsulinSensitivities() {
        InsulinSensitivityProfile profile = ActorSelector.current()
                .requestTo(getInsulinSensitivityProfile)
                .by(new Request());

        List<InsulinSensitivitySegment> responseSegments = profile.segments().stream()
                .map(seg -> new InsulinSensitivitySegment(
                        seg.startTime(),
                        seg.value()
                )).toList();

        InsulinSensitivityListResponse response = new InsulinSensitivityListResponse(
                responseSegments,
                profile.timestamp()
        );
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<TherapyParameterResponse> getTherapyParametersByHour(Integer hour) {
        Response parameters = ActorSelector.current()
                .requestTo(getTherapyParameters)
                .by(new GetTherapyParameters.Request(hour));

        TherapyParameterResponse response = new TherapyParameterResponse(
                parameters.hour(),
                parameters.carbRatio(),
                parameters.insulinSensitivity()
        );

        return ResponseEntity.ok(response);
    }
}
