package com.diacore.application.usecase.user;

import com.diacore.domain.common.usecase.UseCase;

public interface AuthenticateUser extends UseCase<AuthenticateUser.Request, AuthenticateUser.Response> {
    record Request(
            String email,
            String password
    ) {}
    record Response(
            String email,
            String name,
            String token
    ) {}
}
