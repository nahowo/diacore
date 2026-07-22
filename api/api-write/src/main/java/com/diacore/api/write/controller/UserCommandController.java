package com.diacore.api.write.controller;

import com.diacore.api.model.CommonResponse;
import com.diacore.api.model.RegisterUserRequest;
import com.diacore.api.operation.UserCommandApi;
import com.diacore.application.usecase.RegisterUser;
import com.diacore.application.usecase.WithdrawUser;
import com.diacore.domain.common.usecase.Actor;
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
    public ResponseEntity<CommonResponse> registerUser(RegisterUserRequest request) {
        Actor actor = new Actor(1L, ""); // TODO

        RegisterUser.Request command = new RegisterUser.Request(
                request.getEmail(),
                request.getPassword(),
                request.getName()
        );

        Long savedId = registerUser.execute(actor, command);

        CommonResponse response = new CommonResponse()
                .id(savedId)
                .status("SUCCESS");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<CommonResponse> withdrawUser() {
        Actor actor = new Actor(1L, ""); // TODO

        WithdrawUser.Request command = new WithdrawUser.Request();

        Long deletedId = withdrawUser.execute(actor, command);

        CommonResponse response = new CommonResponse()
                .id(deletedId)
                .status("SUCCESS");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
