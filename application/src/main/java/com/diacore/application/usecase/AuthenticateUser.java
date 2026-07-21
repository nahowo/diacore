package com.diacore.application.usecase;

import com.diacore.domain.common.usecase.UseCase;

public interface AuthenticateUser extends UseCase<AuthenticateUser.Request, Long> {
    record Request(
            String email,
            String password
    ) {}
}
