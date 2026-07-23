package com.diacore.application.usecase.user;

import com.diacore.domain.common.usecase.UseCase;

public interface RegisterUser extends UseCase<RegisterUser.Request, Long> {
    record Request(
            String email,
            String password,
            String name
    ) {}
}
