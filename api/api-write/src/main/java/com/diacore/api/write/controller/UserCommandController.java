package com.diacore.api.write.controller;

import com.diacore.api.model.CreatedResponse;
import com.diacore.api.model.RegisterUserRequest;
import com.diacore.api.operation.UserCommandApi;
import com.diacore.application.usecase.user.RegisterUser;
import com.diacore.application.usecase.user.WithdrawUser;
import com.diacore.infrastructure.actor.ActorSelector;
import java.time.OffsetDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserCommandController implements UserCommandApi {
    private final RegisterUser registerUser;
    private final WithdrawUser withdrawUser;

    public UserCommandController(RegisterUser registerUser, WithdrawUser withdrawUser) {
        this.registerUser = registerUser;
        this.withdrawUser = withdrawUser;
    }

    @Override
    public ResponseEntity<CreatedResponse> registerUser(RegisterUserRequest request) {
        Long savedId = ActorSelector.anonymous()
                .requestTo(registerUser)
                .by(new RegisterUser.Request(
                        request.getEmail(),
                        request.getPassword(),
                        request.getName())
                );

        CreatedResponse response = new CreatedResponse()
                .id(savedId)
                .createdAt(OffsetDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<Void> withdrawUser() {
        ActorSelector.current()
                .requestTo(withdrawUser);

        return ResponseEntity.noContent().build();
    }
}
