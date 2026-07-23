package com.diacore.application.usecase.user;

import com.diacore.domain.common.usecase.UseCase;

public interface AuthenticateUser extends UseCase<AuthenticateUser.Request, String> {
    record Request(
            String email,
            String password
    ) {}
}
