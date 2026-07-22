package com.diacore.api.read.controller;

import com.diacore.api.model.LoginUserRequest;
import com.diacore.api.model.TokenResponse;
import com.diacore.api.operation.UserQueryApi;
import com.diacore.application.usecase.AuthenticateUser;
import com.diacore.domain.common.usecase.Actor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserQueryController implements UserQueryApi {
    private final AuthenticateUser authenticateUser;

    public UserQueryController(AuthenticateUser authenticateUser) {
        this.authenticateUser = authenticateUser;
    }

    @Override
    public ResponseEntity<TokenResponse> loginUser(LoginUserRequest request) {
        Actor actor = new Actor(1L, ""); // TODO

        AuthenticateUser.Request command = new AuthenticateUser.Request(
                request.getEmail(),
                request.getPassword()
        );

        String token = authenticateUser.execute(actor, command);

        TokenResponse response = new TokenResponse()
                .token(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
